package com.yiwei.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by victorlau on 2019/10/31.
 */
@ConfigurationProperties(prefix = "system")
@Component
public class CommonProp {

    private List<String> uncheckMileageTagList;

    public List<String> getUncheckMileageTagList() {
        return uncheckMileageTagList;
    }

    public void setUncheckMileageTagList(List<String> uncheckMileageTagList) {
        this.uncheckMileageTagList = uncheckMileageTagList;
    }
}
