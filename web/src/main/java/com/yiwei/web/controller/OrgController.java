package com.yiwei.web.controller;

import com.yiwei.common.ResponseResult;
import com.yiwei.common.ResultUtils;
import com.yiwei.web.domain.sysOrg.OrgAddRequest;
import com.yiwei.web.domain.sysOrg.OrgVO;
import com.yiwei.web.entity.SysOrg;
import com.yiwei.web.service.SysOrgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/sysOrg")
@Api(tags = "系统配置中心-组织管理")
public class OrgController {
    @Autowired
    private SysOrgService orgService;

    @GetMapping("/getOrgTree")
    @ApiOperation(value = "查询组织树", notes = "查询所有用户组织树")
    public List<OrgVO> getOrgTree() {
        List<OrgVO> orgTree = orgService.getOrgTree();
        return orgTree;
    }

    @GetMapping("/getOrgTree/currentUser")
    @ApiOperation(value = "查询组织树-当前用户", notes = "查询当前用户组织树")
    public List<OrgVO> getOrgTreeById() {
        List<OrgVO> orgTree = orgService.getCurrnetUserOrgTree();
        return orgTree;
    }


    @GetMapping("/add")
    @ApiOperation(value = "添加用户")
    public ResponseResult<SysOrg> add(OrgAddRequest orgAddRequest) {

        SysOrg org = orgService.addOrg(orgAddRequest);
        // ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        // TODO: 2024/1/9  这个问题 throwIf
        return ResultUtils.success(org);
    }


}
