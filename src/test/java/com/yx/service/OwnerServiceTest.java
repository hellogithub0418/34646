package com.yx.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yx.dao.OwnerMapper;
import com.yx.model.Userinfo;

@SpringBootTest
public class OwnerServiceTest {
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private OwnerMapper ownerMapper;
	
	@Test
	public void testList() {
		//ownerService.delete(3)
		int count = ownerMapper.deleteById(1);
        System.out.println(count);
	}

}
