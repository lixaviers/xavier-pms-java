package com.xavier.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xavier.pms.convertor.ApprovalConvertor;
import com.xavier.pms.dao.ApprovalMapper;
import com.xavier.pms.model.Approval;
import com.xavier.pms.req.ApprovalDto;
import com.xavier.pms.req.ApprovalStatusDto;
import com.xavier.pms.resp.ApprovalDetailVo;
import com.xavier.pms.result.ResultCode;
import com.xavier.pms.service.IApprovalService;
import com.xavier.pms.utils.BeanUtil;
import com.xavier.pms.utils.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


/**
 * 业务逻辑层-审批实现类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Slf4j
@Service
public class ApprovalServiceImpl extends ServiceImpl<ApprovalMapper, Approval> implements IApprovalService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createApproval(ApprovalDto dto) {
        Approval approval = ApprovalConvertor.toApproval(dto);
        approval.setId(null);
        super.save(approval);
        return approval.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateApproval(ApprovalDto dto) {
        getBaseApproval(dto.getId());
        Approval approval = ApprovalConvertor.toApproval(dto);
        super.updateById(approval);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteApproval(Long id) {
        getBaseApproval(id);
        super.removeById(id);
    }

    @Override
    public ApprovalDetailVo getApproval(Long id) {
        return ApprovalConvertor.toApprovalDetailVo(getBaseApproval(id));
    }


    @Override
    public Approval getBaseApproval(Long id) {
        Approval approval = super.getById(id);
        if (Objects.isNull(approval)) {
            throw new ServiceException(ResultCode.DATA_NOT_EXIST, "审批");
        }
        return approval;
    }

    @Override
    public void updateStatus(ApprovalStatusDto dto) {
        getBaseApproval(dto.getId());
        super.updateById(BeanUtil.beanCopy(dto, Approval.class));
    }


}
