package com.yx.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yx.dao.OwnerMapper;
import com.yx.dao.ProperMapperTest;
import com.yx.model.PropertyInto;
import com.yx.model.PropertyType;
import com.yx.model.Userinfo;

@SpringBootTest
public class OwnerServiceTest {
	private Logger log = LoggerFactory.getLogger(OwnerServiceTest.class);
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private PropertyTypeService propertyTypeService;
	@Autowired
	private OwnerMapper ownerMapper;
	
	@Test
	public void testList() {
		//ownerService.delete(3)
//		int count = ownerMapper.deleteById(1);
//        System.out.println(count);
		PropertyType propertyType = new PropertyType();
        List<PropertyType> list=  propertyTypeService.findAll();
        for (PropertyType property: list) {
			log.info(property.toString());
		}
	}

}
