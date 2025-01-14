package com.xavier.pms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xavier.pms.convertor.SealConvertor;
import com.xavier.pms.dao.SealMapper;
import com.xavier.pms.req.SealDto;
import com.xavier.pms.req.SealQueryDto;
import com.xavier.pms.utils.ServiceException;
import com.xavier.pms.model.Seal;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.result.ResultCode;
import com.xavier.pms.service.ISealService;
import com.xavier.pms.utils.BeanUtil;
import com.xavier.pms.resp.SealVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * 业务逻辑层-印章实现类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
@Slf4j
@Service("sealService")
public class SealServiceImpl extends ServiceImpl<SealMapper, Seal> implements ISealService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createSeal(SealDto sealDto) {
        Seal seal = SealConvertor.toSeal(sealDto);
        seal.setId(null);
        super.save(seal);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSeal(SealDto sealDto) {
        getBaseSeal(sealDto.getId());
        Seal seal = SealConvertor.toSeal(sealDto);
        super.updateById(seal);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSeal(List<Long> idList) {
        super.removeBatchByIds(idList);
    }

    @Override
    public SealVo getSeal(Long id) {
        return SealConvertor.toSealVo(getBaseSeal(id));
    }


    @Override
    public Seal getBaseSeal(Long id) {
        Seal seal = super.getById(id);
        if (Objects.isNull(seal)) {
            throw new ServiceException(ResultCode.DATA_NOT_EXIST, "印章");
        }
        return seal;
    }

    @Override
    public QueryResultVo<SealVo> querySeal(SealQueryDto queryDTO) {
        Page<Seal> page = new Page<>();
        page.setCurrent(queryDTO.getPageNo());
        page.setSize(queryDTO.getPageSize());
        LambdaQueryWrapper<Seal> wrapper = Seal.gw();
        if (Objects.nonNull(queryDTO.getId())) {
            // id不为空
            wrapper.eq(Seal::getId, queryDTO.getId());
        }
        if (StrUtil.isNotBlank(queryDTO.getSealName())) {
            // 印章名称不为空
            wrapper.like(Seal::getSealName, queryDTO.getSealName());
        }
        if (Objects.nonNull(queryDTO.getIsEnable())) {
            // 是否启用不为空
            wrapper.eq(Seal::getIsEnable, queryDTO.getIsEnable());
        }
        if (StrUtil.isNotBlank(queryDTO.getRemarks())) {
            // 备注不为空
            wrapper.like(Seal::getRemarks, queryDTO.getRemarks());
        }
        if (Objects.nonNull(queryDTO.getCreateTimeFrom())) {
            // 创建时间大于等于
            wrapper.ge(Seal::getCreateTime, queryDTO.getCreateTimeFrom());
        }
        if (Objects.nonNull(queryDTO.getCreateTimeTo())) {
            // 创建时间小于等于
            wrapper.le(Seal::getCreateTime, queryDTO.getCreateTimeTo());
        }
        wrapper.orderByDesc(Seal::getId);
        Page<Seal> result = super.page(page, wrapper);
        QueryResultVo<SealVo> queryResultVo = BeanUtil.pageToQueryResultVo(result, SealVo.class);
        queryResultVo.setRecords(SealConvertor.toSealVoList(result.getRecords()));
        return queryResultVo;
    }

}
