package com.yx.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.yx.model.House;

@SpringBootTest
public class HouseMapperTest {
	private Logger log = LoggerFactory.getLogger(HouseMapperTest.class);

	@Autowired
	private HouseMapper houseMapper;

	@Test
	public void testList() {
		List<House> list = houseMapper.findHouseAll(null);

		list.forEach(house -> {
			//System.out.println(house);
			log.info(house.toString());
		});
	}
	
	@Test
	@Transactional
	public void testAdd() {
		House house=new House();
		house.setNumbers("1");
		house.setStatus(1);
		house.setRemarks("111");
		house.setBuildingId(1);
		house.setArea(10.00);
		house.setIntoDate(new Date());
		int ret = houseMapper.insert(house);
		if(ret==1) {
			log.info("新增成功");
		}else {
			log.info("新增失败");
		}
	}
	
	@Test
	@Transactional
	public void testDelete() {
		List<House> list = new ArrayList<>();
//		list.insert(new House(1));
		int count =  houseMapper.deleteById(1);
		if(count==1) {
			log.info("删除成功");
		}else {
			log.info("删除失败");
		}
	}
	
	@Test
	@Transactional
	public void testUpDate() {
		
		
	}

}
