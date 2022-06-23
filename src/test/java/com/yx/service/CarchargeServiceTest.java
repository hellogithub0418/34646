package com.yx.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.yx.model.Carcharge;
import com.yx.model.Parking;


@SpringBootTest
public class CarchargeServiceTest {
	private Logger log = LoggerFactory.getLogger(CarchargeServiceTest.class);
	@Autowired
	private CarchargeService carchargeService;
	
	@Test
		public void testList() {
			QueryWrapper<Carcharge> queryWrapper = new QueryWrapper<Carcharge>();
			
		
			
			Page<Carcharge> page = new Page<>(1,10);
			
			
			//List<Parking> userList = parkingService.list(queryWrapper);
			PageInfo<Carcharge> pageInfo= carchargeService.findCarchargeAll(1,10, null);

			pageInfo.getList().forEach(System.out::println);
		}
	
	//@Test
		//@Transactional
//		public void testAdd() {
//			
//			Carcharge carcharge = new Carcharge().setEndDate("2022-01-06").
//			
//					carchargeService.add(carcharge);
//			
//		}
		
}
