package com.yiwei.web.domain.sysMenu;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class MenuAddRequest implements Serializable {

    public static final long serialVersionUID = 6976472575755402878L;

    /**
     * 编码
     */
    @ApiModelProperty("编码")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;
    /**
     * 父类id
     */
    @NotNull(message = "父类id不能为空")
    @ApiModelProperty("父类id")
    private Long parentId;

}
