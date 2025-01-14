package com.xavier.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xavier.pms.model.ApprovalGroup;
import com.xavier.pms.req.ApprovalGroupDto;
import com.xavier.pms.req.ApprovalGroupQueryDto;
import com.xavier.pms.resp.ApprovalGroupVo;

import java.util.List;

/**
 * 业务逻辑层-审批分组接口类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public interface IApprovalGroupService extends IService<ApprovalGroup> {

    /**
     * 创建审批分组
     *
     * @param approvalGroupDto 审批分组入参
     */
    void createApprovalGroup(ApprovalGroupDto approvalGroupDto);

    /**
     * 更新审批分组
     *
     * @param approvalGroupDto 审批分组入参
     */
    void updateApprovalGroup(ApprovalGroupDto approvalGroupDto);

    /**
     * 删除审批分组
     *
     * @param id
     */
    void deleteApprovalGroup(Long id);

    /**
     * 根据ID获取审批分组信息
     *
     * @param id
     * @return 审批分组信息
     */
    ApprovalGroupVo getApprovalGroup(Long id);

    /**
     * 分页查询审批分组信息
     *
     * @param approvalGroupQueryDto 审批分组查询入参
     * @return 审批分组信息
     */
    List<ApprovalGroupVo> queryApprovalGroup(ApprovalGroupQueryDto approvalGroupQueryDto);


    /**
     * 获取生效的审批列表
     *
     * @return
     */
    List<ApprovalGroupVo> getList();


}
