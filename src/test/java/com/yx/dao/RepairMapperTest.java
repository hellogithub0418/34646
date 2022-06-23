package com.yx.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yx.model.Repair;

@SpringBootTest
public class RepairMapperTest {
	private Logger log = LoggerFactory.getLogger(RepairMapperTest.class);

	@Autowired
	private RepairMapper repairMapper;

	@Test
	public void testList() {
		
	}
}
