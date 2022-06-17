package com.yx.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yx.model.Userinfo;

@SpringBootTest
public class UserinfoServiceTest {
	@Autowired
	private UserinfoService userinfoService;
	
	@Test
	public void testList() {
		QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<Userinfo>();
		queryWrapper.ge("username", "admin");
		
		Page<Userinfo> page = new Page<>(1,10);
		
		//List<User> list = userMapper.list(pager);
		List<Userinfo> userList = userinfoService.list();
//		IPage<Userinfo> iPage = userinfoService.findUserinfoAll(1, 10, userList);
//		System.out.println("总页数:" + iPage.getPages());
//        System.out.println("总记录数:" + iPage.getTotal());
        //List<Userinfo> userList = iPage.getRecords();

        userList.forEach(System.out::println);
	}

}
