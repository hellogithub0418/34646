package com.yx.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;

import com.yx.model.Parking;

@SpringBootTest
public class ParkingServiceTest {
	private Logger log = LoggerFactory.getLogger(ParkingServiceTest.class);
	@Autowired
	private ParkingService parkingService;
	
	
	
	//@Test
	public void testList() {
		QueryWrapper<Parking> queryWrapper = new QueryWrapper<Parking>();
		
		//queryWrapper.ge("username", "admin");
		
		Page<Parking> page = new Page<>(1,10);
		
		
		//List<Parking> userList = parkingService.list(queryWrapper);
		PageInfo<Parking> pageInfo= parkingService.findParkAll(1,10,"555");

		pageInfo.getList().forEach(System.out::println);
	}
	
	
	//@Test
	@Transactional
	public void testAdd() {
		
		Parking parking = new Parking().setNumbers("11123213")
				.setRemarks("所發生的")
				.setStatus(1).setOwnerId(10001);
		
		parkingService.add(parking);
		
	}
	//@Test
	//@Transactional
	public void testEdit() {
		Parking parking=new Parking();
		parking.setParkingId(1001);
		parking.setNumbers("TT985632");
		
		
		
		int ret = parkingService.updateData(parking);
		if(ret>0) {
			log.info("修改成功");
		}else {
			log.info("修改失败");
		}
		
	}
	//@Test
		//@Transactional
		public void testDelete() {
			Parking parking=new Parking();
			parking.setParkingId(1001);
			parking.setNumbers("TT985632");
			
			
			
			int ret = parkingService.updateData(parking);
			if(ret>0) {
				log.info("修改成功");
			}else {
				log.info("修改失败");
			}

}
}