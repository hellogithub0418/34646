package com.yx.controller;


import com.yx.util.JsonObject;
import com.yx.util.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.PropertyInfo;
import com.yx.model.PropertyInto;
import com.yx.model.PropertyType;
import com.yx.service.PropertyIntoService;

@RestController
@RequestMapping("/propertyinto")
public class PropertyIntoController{
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	//@Autowired
	private PropertyIntoService propertyIntoService;
	
    
    //查询全部信息
    @RequestMapping("/queryPropertyIntoAll")
    public JsonObject queryPropertyIntoAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                    PropertyInto propertyInto){
    	JsonObject object = new JsonObject();
    	// pageinfo接受service层传来的结果
    	PageInfo<PropertyInto> pageInto = propertyIntoService.findPropertyIntoAll(page, limit, propertyInto);
    	object.setCode(0);
    	object.setMsg("ok");
    	object.setCount(pageInto.getTotal());
    	object.setData(pageInto.getList());
    	return object;
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<PropertyInto> findListByPage(@RequestParam Integer page,
                                       @RequestParam Integer pageCount){
        return propertyIntoService.findListByPage(page, pageCount);
    }
	
//	@ApiOperation(value = "新增")
//    @RequestMapping("/add")
//	public R add(@RequestBody PropertyInto propertyInto) {
//		propertyIntoService.add(propertyInto);
//        return R.ok();
//	}
	
	
	
}

