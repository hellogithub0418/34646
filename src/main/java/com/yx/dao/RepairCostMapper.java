package com.yx.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.yx.model.RepairCost;

@Component("repairCostDao")
public interface RepairCostMapper extends BaseMapper<RepairCost>{
	List<RepairCost> queryRepairCostAll(RepairCost repairCost);
}
