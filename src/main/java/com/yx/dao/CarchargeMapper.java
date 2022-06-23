package com.yx.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Carcharge;

@Component("carchargeDao")
public interface CarchargeMapper extends BaseMapper<Carcharge>{
	List<Carcharge> queryCarChargeAll(Carcharge carcharge);
}
