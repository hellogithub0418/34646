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
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.yx.dao.UserinfoMapperTest;
import com.yx.model.House;
import com.yx.model.Userinfo;

@SpringBootTest
public class HouseServiceTest {
	private Logger log = LoggerFactory.getLogger(HouseServiceTest.class);
	

	@Autowired
	private HouseService houseService;
	
	
	@Test
	public void testList() {
		QueryWrapper<House> queryWrapper = new QueryWrapper<House>();

		PageInfo<House>  pager  =  houseService.findHouseAll(1, 10, null);
		
	   List<House> list = 	pager.getList();
	   	
		list.forEach(house->{
			
			log.info(house.toString());
			
		});
	}
	
	
	@Test
	@Transactional
	public void testUpdate() {
		
		House house =   houseService.findById(3L);
		
		house.setNumbers("D10011");
		
		houseService.updateById(house);
		
	}
	
	@Test
	@Transactional
	public void testDelete() {
		List<House> list = new ArrayList<>();
//		list.insert(new House(1));
		int count =  houseService.delete(3L);
		if(count==1) {
			log.info("删除成功");
		}else {
			log.info("删除失败");
	}
	}
	
		
	
	@Test
	@Transactional
	public void testquery() {
		//houseMapper.queryCountHouse(1);
		log.info("查询房间数量"+houseService.queryCountH(1));
		
	}
	@Test
	@Transactional
	public void testqueryhouseId() {
		//houseMapper.queryCountHouse(1);
		log.info("查询房间"+houseService.queryHouseIdByBid(1));
		
	}
}
