package com.yx.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yx.dao.OwnerMapper;
import com.yx.model.Building;
import com.yx.model.Userinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
public class OwnerServiceTest {
	private Logger log = LoggerFactory.getLogger(OwnerServiceTest.class);
	
//	@Autowired
//	private OwnerService ownerService;
	@Autowired
	private BuildingService buildingservice;
	@Autowired
	private OwnerMapper ownerMapper;
	
	@Test
	public void testList() {
//		//ownerService.delete(3)
//		int count = ownerMapper.deleteById(1);
//        System.out.println(count);
		Building  building  = new Building ();
		building.setBuildingId(1);
		building.setBuildingName("14动");
		building.setRemarks("xygdye");
		building.setUints("3单元");

		
		
		boolean ret = buildingservice.update(building, null);
		if(ret) {
			log.info("修改成功");
		}else {
			log.info("修改失败");
		}
	}

}
