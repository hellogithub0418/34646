package com.yx.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Owner;
import com.yx.model.Userinfo;
import com.yx.service.OwnerService;
import com.yx.service.UserinfoService;
import com.yx.util.JsonObject;
import com.yx.util.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 业主信息管理
 * @author 34646
 *
 */

@Api(tags = {""})
@RestController
@RequestMapping("/owner")
public class OwnerController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private OwnerService ownerService;
    
    @Resource
    private UserinfoService userinfoService;


    //查询全部信息
    @RequestMapping("/queryOwnerAll")
    public JsonObject queryOwnerAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer limit,
                                    Owner owner){
    	JsonObject object = new JsonObject();
    	// pageinfo接受service层传来的结果
    	PageInfo<Owner> pageInfo = ownerService.findOwnerAll(page, limit, owner);
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
    public IPage<Owner> findListByPage(@RequestParam Integer page,
                                       @RequestParam Integer pageCount){
        return ownerService.findListByPage(page, pageCount);
    }
    
	@ApiOperation(value = "新增")
    @RequestMapping("/add")
	public R add(@RequestBody Owner owner) {
		log.info("测试添加");
		
		owner.setPassword("123456");//默认密码123456
        int num= ownerService.add(owner);
		
      //同步添加到用户信息
        Userinfo user=new Userinfo();
        user.setPassword("123456");//默认密码
        user.setRemarks(owner.getRemarks());
        user.setType(0);
        user.setUsername(owner.getUsername());
        userinfoService.add(user);
        
        //添加成功
        if(num>0){
            return R.ok();
        }else{
            return R.fail("添加失败");
        }
	}
	
	@ApiOperation(value = "删除")
	@RequestMapping("/deleteByIds")
	public R delete(String ids) {
		//先转成集合对象
		List<String> list= Arrays.asList(ids.split(","));
		
		//遍历删除
		for(String id:list) {
			//先在owner表通过id查询出相应的username
			//再通过username删除username表里用户
			Owner owner = ownerService.queryOwnerById(Long.parseLong(id));
			userinfoService.deleteUserByUsername(owner.getUsername());
			//string类型转换成Long
			//ownerService.deleteOwnerByOwnerIds(Integer.valueOf(id));
			ownerService.delete(Long.parseLong(id));
		}
		return R.ok();
		
	}
	
	
	
//    @ApiOperation(value = "修改")
//    @RequestMapping("/update")
//    public R update(@RequestBody Owner owner){
//    	ownerService.add(owner);
//        return R.ok();
//    }
//    
    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Owner owner){
        int num= ownerService.updateData(owner);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("修改失败");
        }
    }
	
    @RequestMapping("/queryAll")
    @Transactional
    public List queryAll(){
        PageInfo<Owner> pageInfo= ownerService.findOwnerAll(1,100,null);
        return pageInfo.getList();
    }
    
    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Owner findById(@PathVariable Long id){
        return ownerService.findById(id);
    }
  
}

