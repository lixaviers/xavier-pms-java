package com.xavier.pms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xavier.pms.convertor.UserGroupConvertor;
import com.xavier.pms.dao.UserGroupMapper;
import com.xavier.pms.req.UserGroupDto;
import com.xavier.pms.req.UserGroupQueryDto;
import com.xavier.pms.utils.ServiceException;
import com.xavier.pms.model.UserGroup;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.ResultCode;
import com.xavier.pms.service.IUserGroupService;
import com.xavier.pms.utils.BeanUtil;
import com.xavier.pms.resp.UserGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * 业务逻辑层-员工组实现类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Slf4j
@Service("userGroupService")
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements IUserGroupService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUserGroup(UserGroupDto userGroupDto) {
        UserGroup userGroup = UserGroupConvertor.toUserGroup(userGroupDto);
        userGroup.setId(null);
        super.save(userGroup);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserGroup(UserGroupDto userGroupDto) {
        getBaseUserGroup(userGroupDto.getId());
        UserGroup userGroup = UserGroupConvertor.toUserGroup(userGroupDto);
        super.updateById(userGroup);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserGroup(List<Long> idList) {
        super.removeBatchByIds(idList);
    }

    @Override
    public UserGroupVo getUserGroup(Long id) {
        return UserGroupConvertor.toUserGroupVo(getBaseUserGroup(id));
    }


    @Override
    public UserGroup getBaseUserGroup(Long id) {
        UserGroup userGroup = super.getById(id);
        if (Objects.isNull(userGroup)) {
            throw new ServiceException(ResultCode.DATA_NOT_EXIST, "员工组");
        }
        return userGroup;
    }

    @Override
    public QueryResultVo<UserGroupVo> queryUserGroup(UserGroupQueryDto queryDTO) {
        Page<UserGroup> page = new Page<>();
        page.setCurrent(queryDTO.getPageNo());
        page.setSize(queryDTO.getPageSize());
        LambdaQueryWrapper<UserGroup> wrapper = UserGroup.gw();
        wrapper.eq(UserGroup::getUserId, queryDTO.getUserId());
        if (StrUtil.isNotBlank(queryDTO.getGroupName())) {
            // 组名称不为空
            wrapper.like(UserGroup::getGroupName, queryDTO.getGroupName());
        }
        if (StrUtil.isNotBlank(queryDTO.getRemarks())) {
            // 备注不为空
            wrapper.like(UserGroup::getRemarks, queryDTO.getRemarks());
        }
        if (Objects.nonNull(queryDTO.getCreateTimeFrom())) {
            // 创建时间大于等于
            wrapper.ge(UserGroup::getCreateTime, queryDTO.getCreateTimeFrom());
        }
        if (Objects.nonNull(queryDTO.getCreateTimeTo())) {
            // 创建时间小于等于
            wrapper.le(UserGroup::getCreateTime, queryDTO.getCreateTimeTo());
        }
        wrapper.orderByDesc(UserGroup::getId);
        Page<UserGroup> result = super.page(page, wrapper);
        QueryResultVo<UserGroupVo> queryResultVo = BeanUtil.pageToQueryResultVo(result, UserGroupVo.class);
        queryResultVo.setRecords(UserGroupConvertor.toUserGroupVoList(result.getRecords()));
        return queryResultVo;
    }

}
