package com.xavier.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xavier.pms.model.User;
import com.xavier.pms.req.EmployeeAddDto;
import com.xavier.pms.req.EmployeeQueryDto;
import com.xavier.pms.req.LoginDto;
import com.xavier.pms.req.UpdatePwdDto;
import com.xavier.pms.resp.EmployeeCardVo;
import com.xavier.pms.resp.EmployeeListVo;
import com.xavier.pms.result.QueryResultVo;

import java.util.List;

/**
 * 业务逻辑层-用户接口类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public interface IUserService extends IService<User> {

    /**
     * 用户登录
     *
     * @param dto
     */

    String login(LoginDto dto);

    /**
     * 根据令牌获取用户信息
     *
     * @param token 令牌
     * @return
     */
    User getByToken(String token);

    /**
     * 创建用户
     *
     * @param userDto 用户入参
     */
    void createUser(EmployeeAddDto userDto);

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return 用户信息
     */
    User getBaseUser(Long id);

    /**
     * 分页获取待审核员工列表信息
     */
    QueryResultVo<EmployeeListVo> queryEmployee(EmployeeQueryDto dto);

    /**
     * 根据部门id查询员工列表信息
     *
     * @param departmentId
     * @return
     */
    List<EmployeeListVo> getByDepartmentId(Long departmentId);

    /**
     * 根据id查询员工卡片信息
     *
     * @param id
     * @return
     */
    EmployeeCardVo getCard(Long id);

    /**
     * 获取员工直属上级
     *
     * @param id
     * @return
     */
    User getDirectLeader(Long id);

    /**
     * 获取员工所在部门的负责人
     *
     * @param id
     * @return
     */
    User getDepartmentUser(Long id);

    /**
     * 修改密码
     */
    void updatePwd(UpdatePwdDto dto);

}
