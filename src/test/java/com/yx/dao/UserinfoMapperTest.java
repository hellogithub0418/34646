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
public class UserinfoMapperTest {
	private Logger log = LoggerFactory.getLogger(UserinfoMapperTest.class);
	
	@Autowired
	private UserinfoMapper userinfoMapper;
	
	@Test
	public void testList() {
		QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>();
		queryWrapper.ge("username", "admin");
		
		Page<Userinfo> page = new Page<>(1,10);
		IPage<Userinfo> iPage = userinfoMapper.selectPage(page, queryWrapper);
		
		System.out.println("总页数:" + iPage.getPages());
        System.out.println("总记录数:" + iPage.getTotal());
        List<Userinfo> userList = iPage.getRecords();

        userList.forEach(System.out::println);
//		IPage<Userinfo> userpage = new Page<>(2,10);
//		
//		
//		for(Userinfo userinfo : list) {
//			log.info(userinfo.toString());
//		}
        int count = userinfoMapper.deleteById(9);
        System.out.println(count);
	}

}
