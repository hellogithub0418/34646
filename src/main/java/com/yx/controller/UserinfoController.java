package com.yx.controller;


import com.yx.util.JsonObject;
import com.yx.util.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Userinfo;
import com.yx.service.UserinfoService;

@RestController
@RequestMapping("/userinfo")
public class UserinfoController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	//@Resource
	@Autowired
	private UserinfoService userinfoService;
	
	//全部信息
	@RequestMapping("/queryUserInfoAll")
	//返回的数据类型
	//@RequestParam(defaultValue = "1")当前端不传参数时，默认值为1
	public JsonObject queryUserInfoAll(@RequestParam(defaultValue = "1") Integer page,
									   @RequestParam(defaultValue = "15") Integer size,
									   Userinfo userinfo) {
		JsonObject object = new JsonObject();
		// pageinfo接受service层传来的结果
		PageInfo<Userinfo> pageInfo = userinfoService.findUserinfoAll(page, size, userinfo);
		
		object.setCode(0);
		object.setMsg("ok");
		object.setCount(pageInfo.getTotal());
		object.setData(pageInfo.getList());
		return object;
	}
	
	@ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Userinfo> findListByPage(@RequestParam Integer page,
                                          @RequestParam Integer pageCount){
        return userinfoService.findListByPage(page, pageCount);
    }
	
	@ApiOperation(value = "新增")
    @RequestMapping("/add")
	public R add(@RequestBody Userinfo userinfo) {
		userinfoService.add(userinfo);
        return R.ok();
	}
	
	@ApiOperation(value = "删除")
	@RequestMapping("/deleteByIds")
	public R delete(String ids) {
		//先转成集合对象
		List<String> list= Arrays.asList(ids.split(","));
		
		//遍历删除
		for(String id:list) {
			//string类型转换成Long
			userinfoService.delete(Long.parseLong(id));
		}
		return R.ok();
		
	}
	
    @ApiOperation(value = "修改")
    @RequestMapping("/update")
    public R update(String oldPwd,String newPwd,Integer id){
        //根据id获取当前的数据记录
        Userinfo user=userinfoService.findById(new Long(id));
        if(oldPwd.equals(user.getPassword())){//前端输入的旧密码和数据库原密码一致
            user.setPassword(newPwd);
            userinfoService.updateData(user);
            return R.ok();
        }else{
            return R.fail("旧密码输入错误！");
        }
    }
}
