package com.yx.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.yx.model.PropertyInfo;
import com.yx.model.PropertyInto;


@SpringBootTest
public class ProperMapperTest {
	
	private Logger log = LoggerFactory.getLogger(ProperMapperTest.class);
	
//	@Autowired
//	private PropertyInfoMapper propertyInfoMapper;
	@Autowired
	private PropertyIntoMapper propertyIntoMapper;
	
	@Test
	public void testList() {
//		PropertyInfo propertyInfo = new PropertyInfo();
//		List<PropertyInfo> list = propertyInfoMapper.queryListAll(propertyInfo);
//		for (PropertyInfo propertyInfo2: list) {
//			log.info(propertyInfo2.toString());
//		}
//		PropertyInto propertyInto = new PropertyInto();
//		List<PropertyInto> list = propertyIntoMapper.queryListAll(propertyInto);
//		for (PropertyInto propertyInto2: list) {
//			log.info(propertyInto2.toString());
//		}
		PropertyInto propertyInto = new PropertyInto();
		propertyInto.setBuildingId(1);
		propertyInto.setPrice((double) 500);
		propertyInto.setRemarks(null);
		propertyInto.setTime(null);
		propertyInto.setType(1);
		
//		int ret = bas(propertyInto);
//		System.out.println(ret);
		
		
	}
}
