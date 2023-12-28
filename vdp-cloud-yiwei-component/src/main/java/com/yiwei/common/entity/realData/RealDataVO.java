package com.yiwei.common.entity.realData;

import com.yiwei.common.component.anotation.DictMapping;
import lombok.Data;

import java.util.Date;

@Data
public class RealDataVO {
    private Bb bb;
    private String DATATAG;
    private String DEVCODE;
    private B1 b1;
    private B2 b2;
    private B3 b3;
    private B4 b4;
    private B5 b5;
    private B6 b6;
    private Date RECVTIME;
    private B7 b7;
    private B8 b8;
    private Boolean NEED_VALIDATE;
    private B9 b9;
    private String TAG;
    private Integer SN;
    private Date DEVTIME;
    private Ba ba;
    private Bc bc;
    private Bd bd;
    private Be be;
    private Bf bf;
    private C0 c0;
    private String driveMode;
    @DictMapping(dictCode = "driveMode",sourceField = "driveMode")
    private String driveModeStr;
}
