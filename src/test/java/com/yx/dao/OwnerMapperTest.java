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
import com.yx.model.Userinfo;

@SpringBootTest
public class OwnerMapperTest {
	private Logger log = LoggerFactory.getLogger(UserinfoMapperTest.class);
	
	@Autowired
	private OwnerMapper ownerMapper;
	
	@Test
	public void testList() {
        int count = ownerMapper.deleteById(3);
        System.out.println(count);
	}

}
