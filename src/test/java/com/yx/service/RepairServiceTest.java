package com.yx.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.yx.model.House;
import com.yx.model.Repair;

@SpringBootTest
public class RepairServiceTest {
private Logger log = LoggerFactory.getLogger(RepairServiceTest.class);
	

	@Autowired
	RepairService repairService;
	@Test
	public void testList() {
		QueryWrapper<Repair> queryWrapper = new QueryWrapper<Repair>();

		PageInfo<Repair>  pageInfo  =  repairService.findRepairAll(1, 10, null);
		
		pageInfo.getList().forEach(System.out::println);
	   	
		
	}
}
