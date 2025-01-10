package com.xavier.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xavier.pms.model.Car;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据持久层-车辆管理类
 *
 * @author Xavier
 * @version 1.0
 * @CopyRright (c): <素焉>
 */
@Mapper
public interface CarMapper extends BaseMapper<Car> {
    


}