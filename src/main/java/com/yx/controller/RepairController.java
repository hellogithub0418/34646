package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.model.*;
import com.yx.service.OwnerService;
import com.yx.service.RepairCostService;
import com.yx.service.RepairService;

import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Api(tags = {""})
@RestController
@RequestMapping("/repair")
public class RepairController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private RepairService repairService;
    @Resource
    private RepairCostService repairCostService;

    @Resource
    private OwnerService ownerService;

    @RequestMapping("/queryRepairAll")
    public JsonObject queryRepairAll(Repair repair,
                                     @RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "15") Integer limit){


        PageInfo<Repair> pageInfo=repairService.findRepairAll(page,limit,repair);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());

    }

    /**@RequestMapping("/queryRepairAll2")
    public JsonObject queryRepairAll2(Repair repair, HttpServletRequest request,
                                     @RequestParam(defaultValue = "1") Integer page,
                                      @RequestParam(defaultValue = "15") Integer limit){


        //获取当前得登录用户
        Userinfo userinfo= (Userinfo) request.getSession().getAttribute("user");
        String username=userinfo.getUsername();
        //根据username获取登录账号得业主id
        Owner owner=ownerService.queryOwnerByName(username);
        
        PageInfo<Repair> pageInfo=repairService.findRepairAll(page,limit,repair);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());

    }*/

    @RequestMapping("/queryAll")
    public List<RepairCost> queryAll(){
       return repairCostService.queryList();
    }


    @RequestMapping("/deleteByIds")
    public R deleteByIds(String ids){
       List<String> list= Arrays.asList(ids.split(","));
       for(String id:list){
           repairService.delete(Long.parseLong(id));
       }

       return R.ok();
    }

    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Repair repair,HttpServletRequest request)
    {
        
        //获取当前得登录用户
        Userinfo userinfo= (Userinfo) request.getSession().getAttribute("user");
        String username=userinfo.getUsername();

        //根据username获取登录账号得业主id
        Owner owner=ownerService.queryOwnerByName(username);
        
        repair.setStatus(0);
        repair.setReportTime(new Date());
        
        int num=repairService.add(repair);
        if(num>0){
            return  R.ok();
        }
        return R.fail("新增失败");
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(Integer id){
         Repair repair=new Repair();
         repair.setRepairId(id);
         repair.setStatus(1);
         repair.setHandleTime(new Date());
         int num=repairService.updateData(repair);
         return R.ok();
    }

   



}
