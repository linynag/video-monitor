package com.yiwei.common.rabbitmq.listener;

import com.yiwei.common.component.data.DataObj;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @program: vdp-cloud
 * @description:
 * @author: xiazj
 * @create: 2019-06-06 16:51
 **/
@Slf4j
public class DataObjHandleQueue extends AbstractDataHandleQueue<DataObj> {

    public DataObjHandleQueue(List<MqDataHandler<DataObj>> mqDataHandlers) {
        super(mqDataHandlers);
    }

    @Override
    protected int getTaskSeq(DataObj data){
        return data.getDevid().hashCode();
    }

}
