package com.yx.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
		QueryWrapper<Repair> queryWrapper = new QueryWrapper<>();

		PageInfo<Repair>  pageInfo  =  repairService.findRepairAll(1, 10, null);
		
		pageInfo.getList().forEach(System.out::println);
	   	
	}
	
	
	@Test
	public void testListAll() {
		List<Repair> list = repairService.queryListAll();
		
		list.forEach(repair->{
			log.info(repair.toString());
		});
	}
	
	@Test
	@Transactional
	public void testDelete() {
		List<House> list = new ArrayList<>();
//		list.insert(new House(1));
		int count =  repairService.delete(1L);
		if(count==1) {
			log.info("删除成功");
		}else {
			log.info("删除失败");
		}
	}
	
	
}
