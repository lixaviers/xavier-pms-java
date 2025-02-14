package com.xavier.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xavier.pms.req.SealDto;
import com.xavier.pms.req.SealQueryDto;
import com.xavier.pms.model.Seal;
import com.xavier.pms.result.QueryResultVo;
import com.xavier.pms.resp.SealVo;

import java.util.List;

/**
 * 业务逻辑层-印章接口类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): 星辰
 */
public interface ISealService extends IService<Seal> {

    /**
     * 创建印章
     *
     * @param sealDto 印章入参
     */
    void createSeal(SealDto sealDto);

    /**
     * 更新印章
     *
     * @param sealDto 印章入参
     */
    void updateSeal(SealDto sealDto);

    /**
     * 删除印章
     *
     * @param idList id列表
     */
    void deleteSeal(List<Long> idList);

    /**
     * 根据ID获取印章信息
     *
     * @param id
     * @return 印章信息
     */
    SealVo getSeal(Long id);

    /**
     * 根据ID获取印章信息
     *
     * @param id
     * @return 印章信息
     */
    Seal getBaseSeal(Long id);

    /**
     * 分页查询印章信息
     *
     * @param sealQueryDto 印章查询入参
     * @return 印章信息
     */
    QueryResultVo<SealVo> querySeal(SealQueryDto sealQueryDto);



}
