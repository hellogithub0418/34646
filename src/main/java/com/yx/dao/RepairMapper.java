package com.yx.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Repair;

@Component("RepairDao")
public interface RepairMapper extends BaseMapper<Repair>{
	List<Repair> findRepairAll(Repair repair);

}
