package com.yx.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yx.model.House;

@SpringBootTest
public class HouseMapperTest {
	private Logger log = LoggerFactory.getLogger(HouseMapperTest.class);

	@Autowired
	private HouseMapper houseMapper;

	@Test
	public void testList() {
		List<House> list = houseMapper.findHouseAll(null);

		list.forEach(house -> {
			//System.out.println(house);
			log.info(house.toString());
		});
	}

}
