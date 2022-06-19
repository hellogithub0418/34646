package com.yx.dao;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Parking;
@Component("parkingDao")
public interface ParkingMapper extends BaseMapper<Parking>{

}
