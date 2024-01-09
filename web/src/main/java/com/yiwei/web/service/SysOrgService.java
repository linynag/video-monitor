package com.yiwei.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yiwei.web.domain.sysOrg.OrgAddRequest;
import com.yiwei.web.domain.sysOrg.OrgVO;
import com.yiwei.web.entity.SysOrg;

import java.util.List;

/**
* @author EDY
* @description 针对表【sys_org(组织表)】的数据库操作Service
* @createDate 2024-01-02 11:51:08
*/
public interface SysOrgService extends IService<SysOrg> {

    List<OrgVO> getOrgTree();

    List<OrgVO> getCurrnetUserOrgTree();

    SysOrg addOrg(OrgAddRequest orgAddRequest);
}
