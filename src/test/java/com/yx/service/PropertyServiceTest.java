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
import com.yx.dao.UserinfoMapperTest;
import com.yx.model.PropertyInto;
import com.yx.model.Userinfo;

@SpringBootTest
public class PropertyServiceTest {
	private Logger log = LoggerFactory.getLogger(PropertyServiceTest.class);
	@Autowired
	private PropertyIntoService propertyIntoService;
	
	@Test
	public void testList() {
		
		PropertyInto propertyInto = new PropertyInto();
		propertyInto.setBuildingId(1);
		propertyInto.setPrice((double) 500);
		propertyInto.setRemarks(null);
		propertyInto.setTime(null);
		propertyInto.setType(1);
		propertyIntoService.add(propertyInto);

	}

}
