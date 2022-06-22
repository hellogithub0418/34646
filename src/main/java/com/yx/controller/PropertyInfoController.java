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
import com.yx.model.House;
import com.yx.model.Owner;
import com.yx.model.PropertyInfo;
import com.yx.service.PropertyService;

@RestController
@RequestMapping("/propertyinfo")
public class PropertyInfoController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	//@Autowired
	private PropertyService propertyService;
	
    
    //查询全部信息
    @RequestMapping("/queryPropertyAll")
    public JsonObject queryPropertyAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                    PropertyInfo propertyInfo){
    	JsonObject object = new JsonObject();
    	// pageinfo接受service层传来的结果
    	PageInfo<PropertyInfo> pageInfo = propertyService.findPropertyInfoAll(page, limit, propertyInfo);
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
    public IPage<PropertyInfo> findListByPage(@RequestParam Integer page,
                                       @RequestParam Integer pageCount){
        return propertyService.findListByPage(page, pageCount);
    }
	
	
	@ApiOperation(value = "新增")
    @RequestMapping("/add")
	public R add(@RequestBody PropertyInfo propertyInfo) {
		propertyService.add(propertyInfo);
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
			propertyService.delete(Long.parseLong(id));
		}
		return R.ok();
		
	}
	
    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(Integer id){
        PropertyInfo propertyInfo =new PropertyInfo();
        propertyInfo.setId(id);
        propertyInfo.setStatus(1);
        int num=propertyService.updateData(propertyInfo);
        if(num>0){
            return R.ok();
        }
        return R.fail("失败");
    }
	
}
