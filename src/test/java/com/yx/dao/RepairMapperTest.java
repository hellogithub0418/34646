package com.yx.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.yx.model.House;
import com.yx.model.Repair;

@SpringBootTest
public class RepairMapperTest {
	private Logger log = LoggerFactory.getLogger(RepairMapperTest.class);

	@Autowired
	private RepairMapper repairMapper;

	@Test
	public void testList() {
		List<Repair> list = repairMapper.queryListAll(null);
		
		list.forEach(repair->{
			log.info(repair.toString());
		});
	}
	
	@Test
	@Transactional
	public void testDelete() {
//		List<Repair> list = new ArrayList<>();
//		list.insert(new House(1));
		int count =  repairMapper.deleteById(1);
		if(count==1) {
			log.info("删除成功");
		}else {
			log.info("删除失败");
		}
	}
}
