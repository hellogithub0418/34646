package com.yx.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yx.model.RepairCost;
import com.yx.service.RepairCostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {""})
@RestController
@RequestMapping("/repairCost")
public class RepairCostController{

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private RepairCostService repairCostService;



    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody RepairCost repairCost){
        return repairCostService.add(repairCost);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return repairCostService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody RepairCost repairCost){
        return repairCostService.updateData(repairCost);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<RepairCost> findListByPage(@RequestParam Integer page,
                                            @RequestParam Integer pageCount){
        return repairCostService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public RepairCost findById(@PathVariable Long id){
        return repairCostService.findById(id);
    }

}
