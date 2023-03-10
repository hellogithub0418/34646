package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Owner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 
 * @author 34646
 *
 */
@Component("ownerMapper")
public interface OwnerMapper extends BaseMapper<Owner> {

    //查询全部信息
    List<Owner> queryOwnerAll(Owner owner);

    void deleteOwnerByOwnerIds(@Param("OwnerId") Integer OwnerId);

    Owner queryOwnerById(@Param("OwnerId") long parseLong);

    
    /**
     * 通过username查询owner
     */
    Owner queryOwnerByName(@Param("username") String username);
}

