package com.yx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Parking;


@Component("parkingDao")
public interface ParkingMapper extends BaseMapper<Parking>{
	//分页查询车位信息
    List<Parking> queryParkAll(@Param("numbers") String numbers);

    //查询使用的车位信息
    List<Parking> queryParkAllByStatus();

}
