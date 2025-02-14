package com.xavier.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xavier.pms.req.UserGroupDto;
import com.xavier.pms.req.UserGroupQueryDto;
import com.xavier.pms.model.UserGroup;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.resp.UserGroupVo;

import java.util.List;

/**
 * 业务逻辑层-员工组接口类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public interface IUserGroupService extends IService<UserGroup> {

    /**
     * 创建员工组
     *
     * @param userGroupDto 员工组入参
     */
    void createUserGroup(UserGroupDto userGroupDto);

    /**
     * 更新员工组
     *
     * @param userGroupDto 员工组入参
     */
    void updateUserGroup(UserGroupDto userGroupDto);

    /**
     * 删除员工组
     *
     * @param idList
     */
    void deleteUserGroup(List<Long> idList);

    /**
     * 根据ID获取员工组信息
     *
     * @param id
     * @return 员工组信息
     */
    UserGroupVo getUserGroup(Long id);

    /**
     * 根据ID获取员工组信息
     *
     * @param id
     * @return 员工组信息
     */
    UserGroup getBaseUserGroup(Long id);

    /**
     * 分页查询员工组信息
     *
     * @param userGroupQueryDto 员工组查询入参
     * @return 员工组信息
     */
    QueryResultVo<UserGroupVo> queryUserGroup(UserGroupQueryDto userGroupQueryDto);



}
