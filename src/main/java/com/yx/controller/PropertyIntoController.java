package com.yx.controller;


import com.yx.util.JsonObject;
import com.yx.util.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.math.BigDecimal;
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
import com.yx.model.House;
import com.yx.model.Owner;
import com.yx.model.PropertyInfo;
import com.yx.model.PropertyInto;
import com.yx.model.PropertyType;
import com.yx.service.HouseService;
import com.yx.service.PropertyIntoService;
import com.yx.service.PropertyService;

@RestController
@RequestMapping("/propertyinto")
public class PropertyIntoController{
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	//@Autowired
	private PropertyIntoService propertyIntoService;
	
	@Resource
	//@Autowired
	private HouseService houseService;
	
	@Resource
	//@Autowired
	private PropertyService propertyInfoService;
    
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
	
    /**
     *  录入数据
     */
	@ApiOperation(value = "录入数据")
    @RequestMapping("/add")
    //@Transactional(rollbackFor = {RuntimeException.class,Error.class})
    public R add(@RequestBody PropertyInto propertyInto){
		log.info("进来这个方法了");
		//把插入记录放进数据库
		propertyIntoService.add(propertyInto);
        /*
         *      
           1、获取选中楼宇号，计算该楼宇所有房间数量
           2、获取前端传来的金额
         */
		Integer buildingId=propertyInto.getBuildingId();
		//获取propertyInfo基本信息
		
		if(buildingId!=1) {
			double prices = propertyInto.getPrice();
			Integer count = houseService.queryCountH(buildingId);
			log.info("前端传来的金额"+prices);
			log.info("房间数量"+count);
			BigDecimal pricesBig = new BigDecimal(prices);
			BigDecimal countBig = new BigDecimal(count);

			log.info(""+count);
			//获取楼宇下的所房间号
			List<House> listHouse = houseService.queryHouseIdByBid(buildingId);
			
			
			//
			Double averPrices = pricesBig.divide(countBig).doubleValue();
			log.info(listHouse.size()+" === 平均数"+averPrices);
			//获取的houseId先转成集合对象
			//List<String> listHouse= Arrays.asList(houseID.toString().split(","));
			if(count!=0) {
				//3、金额除房间数得到平均数
//				Double averPrices = pricesBig.divide(countBig).doubleValue();
				log.info("平均数"+averPrices);
				//遍历添加
				for(House house:listHouse) {
					//添加到物业费总表
					PropertyInfo info=new PropertyInfo();
					info.setType(propertyInto.getType());
					info.setPrice(averPrices);
					info.setTime(propertyInto.getTime());
					info.setStatus(0);//默认未缴费
					info.setHouseId(house.getHouseId());
					info.setRemarks(propertyInto.getRemarks());
					
					log.info("房间数量"+propertyInto.getType());
					log.info("房间数量"+propertyInto.getTime());
					log.info("房间数量"+house.getHouseId());
					log.info("备注"+propertyInto.getRemarks());
					//log.info("房间数量"+propertyInto.getTime());
					//添加到物业总表里
					propertyInfoService.add(info);

				}
			}
			else {
				return R.fail("该楼宇没有住户！");
			}
		}
		//buildingId=1 代表全小区
		
		else {
			Double prices = propertyInto.getPrice();
			//获取全小区所有房间数量
			List<House> HouseCount = houseService.findList();
			log.info("前端传来的金额"+prices);
			log.info("房间数量"+HouseCount);
			BigDecimal pricesBig = new BigDecimal(prices);
			BigDecimal countBig = new BigDecimal(HouseCount.size());

			log.info("f"+countBig);
			//获取楼宇下的所房间号
			
			
			//
			Double averPrices = pricesBig.divide(countBig,4,BigDecimal.ROUND_UP).doubleValue();
			//Double averPrices = pricesBig.divide(countBig).doubleValue();
			log.info(HouseCount.size()+" === 平均数"+averPrices);
			//获取的houseId先转成集合对象
			//List<String> listHouse= Arrays.asList(houseID.toString().split(","));
				//3、金额除房间数得到平均数
//				Double averPrices = pricesBig.divide(countBig).doubleValue();
				log.info("平均数"+averPrices);
				//遍历添加
		    for(House house:HouseCount) {
					//添加到物业费总表
			PropertyInfo info=new PropertyInfo();
			info.setType(propertyInto.getType());
			info.setPrice(averPrices);
			info.setTime(propertyInto.getTime());
			info.setStatus(0);//默认未缴费
			info.setHouseId(house.getHouseId());
			info.setRemarks(propertyInto.getRemarks());
			//测试
			log.info("房间数量"+propertyInto.getType());
			log.info("房间数量"+propertyInto.getTime());
			log.info("房间数量"+house.getHouseId());
			log.info("备注"+propertyInto.getRemarks());
					//log.info("房间数量"+propertyInto.getTime());
					//添加到物业总表里
			propertyInfoService.add(info);

			}			
			
		}
		return R.ok();
		
      }
	
    @RequestMapping("/deleteByIds")
    @Transactional(rollbackFor = {RuntimeException.class,Error.class})
    public R deleteByIds(String ids){
         //把字符串转list集合
         List<String> list=Arrays.asList(ids.split(","));
         for(String id : list){
        	 Long idLong=Long.parseLong(id);
        	 propertyIntoService.delete(idLong);

         }
        return R.ok();
    }
	
	
	
}

