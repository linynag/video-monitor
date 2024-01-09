package com.yiwei.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yiwei.web.domain.sysOrg.OrgAddRequest;
import com.yiwei.web.domain.sysOrg.OrgVO;
import com.yiwei.web.entity.SysOrg;
import com.yiwei.web.entity.SysUser;
import com.yiwei.web.mapper.SysOrgMapper;
import com.yiwei.web.service.SysOrgService;
import com.yiwei.web.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author EDY
 * @description 针对表【sys_org(组织表)】的数据库操作Service实现
 * @createDate 2024-01-02 11:51:08
 */
@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg>
        implements SysOrgService {


    @Autowired
    private SysUserService userService;

    @Override
    public List<OrgVO> getOrgTree() {
        Wrapper queryObj = new QueryWrapper<>().orderByAsc("level", "sort");
        List<SysOrg> list = baseMapper.selectList(queryObj);
        List<OrgVO> orgVOS = transferOrgVo(list, 0L);
        return orgVOS;
    }

    @Override
    public List<OrgVO> getCurrnetUserOrgTree() {
        SysUser currentUser = userService.getCurrentUser();
        // 1、查询用户的组织
        QueryWrapper<SysOrg> orgQueryWrapper = new QueryWrapper<SysOrg>().eq("id", currentUser.getOrgId());
        SysOrg sysOrg = super.list(orgQueryWrapper).get(0);
        // 2、查询组织的所有层级关系
        Set<Long> allOrgIds = new HashSet<>();
        allOrgIds.add(sysOrg.getId());
        String path = sysOrg.getPath();
        if (StringUtils.isNotEmpty(path)) {
            String[] pathIds = StringUtils.split(path, ",");
            for (String pathId : pathIds) {
                allOrgIds.add(Long.valueOf(pathId));
            }
        }
        // 3、查询对应的所有组织,并进行封装展示
        QueryWrapper<SysOrg> queryWrapper = new QueryWrapper<SysOrg>().in("id", new ArrayList<>(allOrgIds));
        List<SysOrg> allOrg = super.list(queryWrapper);
        List<OrgVO> resultList = transferOrgVo(allOrg, 0L);
        return resultList;
    }

    @Override
    public SysOrg addOrg(OrgAddRequest orgAddRequest) {
        // 对象转换
        SysOrg sysOrg = new SysOrg();
        sysOrg.setCode(orgAddRequest.getCode());
        sysOrg.setName(orgAddRequest.getName());
        sysOrg.setParentId(orgAddRequest.getParentId());
        sysOrg.setManagerName(orgAddRequest.getManagerName());
        sysOrg.setManagerPhone(orgAddRequest.getManagerPhone());
        sysOrg.setRemarks(orgAddRequest.getRemarks());

        SysUser currentUser = userService.getCurrentUser();
        sysOrg.setCreateBy(currentUser.getId());

        // 如果插入的当前节点为根节点，parentId指定为0
        if (sysOrg.getParentId().longValue() == 0) {
            sysOrg.setLevel(1);// 根节点层级为1
            sysOrg.setPath(null);// 根节点路径为
        } else {
            SysOrg parentOrg = baseMapper.selectOne(new QueryWrapper<SysOrg>().eq("id", sysOrg.getParentId()));
            if (parentOrg == null) {
                throw new RuntimeException("未查询到对应的父节点");
            }
            // 填写level
            sysOrg.setLevel(parentOrg.getLevel().intValue() + 1);
            // 填写path
            if (StringUtils.isEmpty(parentOrg.getPath())) {
                sysOrg.setPath(parentOrg.getId().toString());
            } else {
                sysOrg.setPath(parentOrg.getPath() + "," + parentOrg.getId());
            }
            // 查询同样父路径下的最大排序
            QueryWrapper<SysOrg> menuQueryWrapper = new QueryWrapper<SysOrg>()
                    .eq("parent_id", parentOrg.getId())
                    .orderByAsc("sort").last("limit 1");
            SysOrg maxSortOrg = baseMapper.selectOne(menuQueryWrapper);
            if (maxSortOrg.getSort() != null) {
                sysOrg.setSort(maxSortOrg.getSort() + 1);
            }
        }
         super.save(sysOrg);
        return sysOrg;
    }


    /**
     * 封装组织视图
     */
    private List<OrgVO> transferOrgVo(List<SysOrg> allOrg, Long parentId) {
        List<OrgVO> resultList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(allOrg)) {
            for (SysOrg source : allOrg) {
                if (parentId.longValue() == source.getParentId().longValue()) {
                    OrgVO menuVo = new OrgVO();
                    BeanUtils.copyProperties(source, menuVo);
                    // 递归查询子菜单，并封装信息
                    List<OrgVO> childList = transferOrgVo(allOrg, source.getId());
                    if (!CollectionUtils.isEmpty(childList)) {
                        menuVo.setChildMenu(childList);
                    }
                    resultList.add(menuVo);
                }
            }
        }
        return resultList;
    }
}





