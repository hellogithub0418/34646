package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Complaint;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 
 * @author 34646
 *
 */
@Component("complaintDao")
public interface ComplaintMapper extends BaseMapper<Complaint> {

     List<Complaint> queryComplaintAll(Complaint complaint);
}
