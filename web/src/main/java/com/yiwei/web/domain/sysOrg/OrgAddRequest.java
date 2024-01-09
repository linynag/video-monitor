package com.yiwei.web.domain.sysOrg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel("添加组织请求类")
public class OrgAddRequest implements Serializable {

    public static final long serialVersionUID = 3122782221323103018L;
    /**
     * 机构编码
     */
    @ApiModelProperty("机构编码")
    private String code;

    /**
     * 组织名称
     */
    @ApiModelProperty("组织名称")
    private String name;

    /**
     * 父类id
     */
    @NotNull(message = "父类id不能为空")
    @ApiModelProperty("父类id")
    private Long parentId;

    /**
     * 负责人姓名
     */
    @ApiModelProperty("负责人姓名")
    private String managerName;

    /**
     * 负责人电话
     */
    @ApiModelProperty("负责人电话")
    private String managerPhone;

    /**
     * 备注信息
     */
    @ApiModelProperty("备注信息")
    private String remarks;

}
