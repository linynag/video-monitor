package com.yiwei.web.domain.sysOrg;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class OrgVO implements Serializable {

    public static final long serialVersionUID = 4302407088073631342L;
    /**
     * 子菜单集合
     */
    List<OrgVO> childMenu;
    /**
     * 主键
     */
    private Long id;

    /**
     * 机构编码
     */
    private String code;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 父类id
     */
    private Long parentId;

    /**
     * 路径
     */
    private String path;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 负责人姓名
     */
    private String managerName;

    /**
     * 负责人电话
     */
    private String managerPhone;

    /**
     * 备注信息
     */
    private String remarks;

}
