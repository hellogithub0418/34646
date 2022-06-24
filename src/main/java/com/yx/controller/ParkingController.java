package com.yx.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.github.pagehelper.PageInfo;
import com.yx.model.Owner;
import com.yx.model.Parking;

import com.yx.service.ParkingService;
import com.yx.util.JsonObject;
import com.yx.util.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;



@Api(tags = {""})
@RestController
@RequestMapping("/parking")
public class ParkingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ParkingService parkingService;

    @RequestMapping("/queryParkAll")
    public JsonObject queryParkAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                    String numbers){
    	
    	log.info(numbers);
        PageInfo<Parking> pageInfo= parkingService.findParkAll(page,limit,numbers);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());

    }

    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Parking parking){
    	  //设置车位的状态为使用状态
    	  parking.setStatus(1);
    	  
    	   log.info(parking.toString());
    	
    	  
        int num= parkingService.add(parking);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("添加失败");
        }

    }

    @ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R delete(String  ids){
        List<String> list= Arrays.asList(ids.split(","));
        //遍历遍历进行删除
        for(String id:list){
            parkingService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Parking parking){
    	//parking.setStatus(1);
    	
        int num= parkingService.updateData(parking);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("修改失败");
        }
    }





    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Parking> findListByPage(@RequestParam Integer page,
                                         @RequestParam Integer pageCount){
        return parkingService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Parking findById(@PathVariable Long id){
        return parkingService.findById(id);
    }

}