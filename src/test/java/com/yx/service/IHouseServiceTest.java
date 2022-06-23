package com.yx.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.yx.dao.UserinfoMapperTest;
import com.yx.model.House;
import com.yx.model.Userinfo;

@SpringBootTest
public class IHouseServiceTest {
	private Logger log = LoggerFactory.getLogger(IHouseServiceTest.class);
	

	@Autowired
	private IHouseService houseService;
	
	
	@Test
	public void testList() {
		QueryWrapper<House> queryWrapper = new QueryWrapper<House>();

		PageInfo<House>  pager  =  houseService.findHouseAll(1, 10, null);
		
	   List<House> list = 	pager.getList();
	   	
		list.forEach(house->{
			
			log.info(house.toString());
			
		});
	}
	
	
}
