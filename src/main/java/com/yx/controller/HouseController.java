package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.House;
import com.yx.model.Owner;
import com.yx.service.HouseService;
import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cuijianhui
 * @since 2020-12-08
 */
@Api(tags = {""})
@RestController
@RequestMapping("/house")
public class HouseController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private HouseService houseService;

    @RequestMapping("/houseAll")
    public JsonObject queryHouseAll(String numbers,
                                  @RequestParam(defaultValue = "1")  Integer page,
                                    @RequestParam(defaultValue = "15")  Integer limit){
        PageInfo<House> pageInfo=houseService.findHouseAll(page,limit,numbers);
        return  new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/queryAll")
    public  List<House> queryAll(){
        PageInfo<House> pageInfo=houseService.findHouseAll(1,100,null);
        return pageInfo.getList();
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody House house){
        if(house.getIntoDate()!=null){
            house.setStatus(1);
        }else{
            house.setStatus(0);
        }
        int num= houseService.add(house);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("添加失败");
        }
    }

    @ApiOperation(value = "删除")
    @PostMapping("/deleteByIds")
    public R delete(String  ids){
        List<String> list= Arrays.asList(ids.split(","));
        //遍历遍历进行删除
        for(String id:list){
            houseService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @PostMapping("/update")
    public R update(@RequestBody House house){
    	log.info("++++++++++"+house.toString());
        if(house.getIntoDate()!=null){
            house.setStatus(1);
        }else{
            house.setStatus(0);
        }
        int num= houseService.updateData(house);
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
    public IPage<House> findListByPage(@RequestParam Integer page,
                                       @RequestParam Integer pageCount){
        return houseService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public House findById(@PathVariable Long id){
        return houseService.findById(id);
    }
    
    @ApiOperation(value = "根据buildingId查询houseID")
    @PostMapping("/queryHouseIdByBId")
    public JsonObject queryHouseIdByBId(Integer buildingId){
    	//return  houseService.queryHouseIdByBid(buildingId);
    	JsonObject object = new JsonObject();
    	// pageinfo接受service层传来的结果
    	List<House> pageInfo = houseService.queryHouseIdByBid(buildingId);
    	
    	log.info("是否进来"+pageInfo);
    	object.setCode(0);
    	object.setMsg("ok");
    	object.setData(pageInfo);
    	return object;
}

}
