package com.yx.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Carcharge;
import com.yx.model.ComplaintType;
import com.yx.model.Owner;
import com.yx.model.Parking;
import com.yx.model.Userinfo;
import com.yx.service.CarchargeService;
import com.yx.service.OwnerService;
import com.yx.service.ParkingService;
import com.yx.util.JsonObject;
import com.yx.util.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {""})
@RestController
@RequestMapping("/carcharge")
public class CarchargeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private CarchargeService carchargeService;

    @Resource
    private ParkingService parkingService;

    @Resource
    private OwnerService ownerService;


    @RequestMapping("/queryCarchargeAll")
    public JsonObject queryCarchargeAll(Carcharge carcharge, String numbers,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "15") Integer limit){
        if(numbers!=null){
           Parking parking=new Parking();
           parking.setNumbers(numbers);
           carcharge.setParking(parking);
        }

        PageInfo<Carcharge> pageInfo=carchargeService.findCarchargeAll(page,limit,carcharge);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());

    }

    @RequestMapping("/queryCarchargeAll2")
    public JsonObject queryCarchargeAll2(Carcharge carcharge, HttpServletRequest request,
                                        @RequestParam(defaultValue = "1") Integer page,
                                         @RequestParam(defaultValue = "15") Integer limit){

        Userinfo userinfo= (Userinfo) request.getSession().getAttribute("user");
        String username=userinfo.getUsername();
        //??????username???????????????????????????id
        Owner owner=ownerService.queryOwnerByName(username);
        carcharge.setOwnerId(owner.getOwnerId());
       
        
        PageInfo<Carcharge> pageInfo=carchargeService.findCarchargeAll(page,limit,carcharge);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());

    }
    



    @ApiOperation(value = "??????")
    @RequestMapping("/initData")
    public R InitData(@RequestBody Carcharge carcharge){
        /**
         * ??????????????????????????????????????????
         */
        List<Parking> parkingList=parkingService.queryParkingByStatus();
        //for(Parking park:parkingList){
            carcharge.setStatus(0);
            //carcharge.setParkId(park.getParkingId());
           // carcharge.setOwnerId(park.getOwnerId());
            
            
            carchargeService.add(carcharge);
       // }
       return R.ok();

    }

    @ApiOperation(value = "??????")
    @RequestMapping("/deleteByIds")
    public R delete(String ids){
        List<String> list= Arrays.asList(ids.split(","));
        for(String id:list){
           Long idLong=new Long(id);
           carchargeService.delete(idLong);
        }
        return R.ok();
    }

    @ApiOperation(value = "??????")
    @RequestMapping("/update")
    public R update(Integer id){
        Carcharge carcharge =new Carcharge();
        carcharge.setId(id);
        carcharge.setStatus(1);
        int num=carchargeService.updateData(carcharge);
        if(num>0){
            return R.ok();
        }
        return R.fail("??????");
    }

    @ApiOperation(value = "??????????????????")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "??????"),
        @ApiImplicitParam(name = "pageCount", value = "????????????")
    })
    @GetMapping()
    public IPage<Carcharge> findListByPage(@RequestParam Integer page,
                                           @RequestParam Integer pageCount){
        return carchargeService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id??????")
    @GetMapping("{id}")
    public Carcharge findById(@PathVariable Long id){
        return carchargeService.findById(id);
    }
    @RequestMapping("/queryCarcharge")
    public List<Carcharge> queryCarcharge(){
       return  carchargeService.queryCarcharge();
    }

}