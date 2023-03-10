package com.yx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.yx.model.Complaint;
import com.yx.service.ComplaintService;
import com.yx.service.OwnerService;
import com.yx.util.JsonObject;
import com.yx.util.R;
import com.yx.model.Owner;
import com.yx.model.Userinfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
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
@RequestMapping("/complaint")
public class ComplaintController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ComplaintService complaintService;
    @Resource
    private OwnerService ownerService;

    @RequestMapping("/queryComplaintAll")
    public JsonObject queryComplaintAll(Complaint complaint, String numbers,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "15") Integer limit){


        PageInfo<Complaint> pageInfo=complaintService.findComplaintAll(page,limit,complaint);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());

    }

    @RequestMapping("/queryComplaintAll2")
    public JsonObject queryComplaintAll2(Complaint complaint, HttpServletRequest request,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "15") Integer limit){
        //获取当前得登录用户
        Userinfo userinfo= (Userinfo) request.getSession().getAttribute("user");
        String username=userinfo.getUsername();
        //根据username获取登录账号得业主id
        Owner owner=ownerService.queryOwnerByName(username);
        complaint.setOwnerId(owner.getOwnerId());
        PageInfo<Complaint> pageInfo=complaintService.findComplaintAll(page,limit,complaint);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());
    }



    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Complaint complaint,HttpServletRequest request)
    {
        //获取当前得登录用户
        Userinfo userinfo= (Userinfo) request.getSession().getAttribute("user");
        String username=userinfo.getUsername();
        //根据username获取登录账号得业主id
        Owner owner=ownerService.queryOwnerByName(username);
        complaint.setOwnerId(owner.getOwnerId());
        complaint.setStatus(0);
        complaint.setComDate(new Date());
        int num=complaintService.add(complaint);
        if(num>0){
            return  R.ok();
        }
        return R.fail("失败啦");
    }

    @ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R deleteByIds(String ids){
       List<String> list=Arrays.asList(ids.split(","));
       for(String id:list){
           complaintService.delete(Long.parseLong(id));
       }
       return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(Integer id,HttpServletRequest request){
         Complaint complaint=new Complaint();
         complaint.setId(id);
         complaint.setStatus(1);
         Userinfo userinfo= (Userinfo) request.getSession().getAttribute("user");
         String username=userinfo.getUsername();
        complaint.setHandler(username);
        
        int num= complaintService.updateData(complaint);
        if(num>0){
            return R.ok();
        }else{
            return R.fail("处理失败");
        }
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Complaint> findListByPage(@RequestParam Integer page,
                                           @RequestParam Integer pageCount){
        return complaintService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Complaint findById(@PathVariable Long id){
        return complaintService.findById(id);
    }

}
