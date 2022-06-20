package com.yx.controller;

import java.io.Console;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yx.model.Building;
import com.yx.service.impl.BuildingServiceImpl;
import com.yx.util.JsonObject;
import com.yx.util.R;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Controller
@ResponseBody
@RequestMapping("/building")
@Slf4j
public class BuildingController{
	@Autowired
	BuildingServiceImpl buildingService;
	@RequestMapping("/queryBuildAll")
    public JsonObject queryBuildAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size,
                                    String numbers){
        JsonObject object=new JsonObject();
        object.setCode(0);
        object.setMsg("ok");
        List<Building> buildings=buildingService.findBuildAll(page, size, numbers);
        object.setCount((long)2);
        object.setData(buildings);
        return object;
    }
	
	@ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Building building){
        int num= buildingService.updateData(building);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("修改失败");
        }
    }

	@ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Building building){
        int num= buildingService.add(building);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("添加失败");
        }

    }
	
	@ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R delete(Building building){
		log.info(building.toString());
		int num= buildingService.delete(building);
		
        if(num>0){
            return R.ok();
        }else{
            return R.fail("删除失败");
        }
    }
}
