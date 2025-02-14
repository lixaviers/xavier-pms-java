package com.xavier.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xavier.pms.req.DepartmentDto;
import com.xavier.pms.req.DepartmentQueryDto;
import com.xavier.pms.model.Department;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.resp.DepartmentVo;

/**
 * 业务逻辑层-部门接口类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 创建部门
     *
     * @param departmentDto 部门入参
     * @return id
     */
    void createDepartment(DepartmentDto departmentDto);

    /**
     * 更新部门
     *
     * @param departmentDto 部门入参
     */
    void updateDepartment(DepartmentDto departmentDto);

    /**
     * 删除部门
     *
     * @param id
     */
    void deleteDepartment(Long id);

    /**
     * 根据ID获取部门信息
     *
     * @param id
     * @return 部门信息
     */
    DepartmentVo getDepartment(Long id);

    /**
     * 根据ID获取部门信息
     *
     * @param id
     * @return 部门信息
     */
    Department getBaseDepartment(Long id);

    /**
     * 分页查询部门信息
     *
     * @param departmentQueryDto 部门查询入参
     * @return 部门信息
     */
    QueryResultVo<DepartmentVo> queryDepartment(DepartmentQueryDto departmentQueryDto);



}
