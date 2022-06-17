package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 数据库进行数据持久化操作，方法语句是直接针对数据库操作
 * @author 34646
 *
 */
@Component("userinfoDao")
public interface UserinfoMapper extends BaseMapper<Userinfo> {

    List<Userinfo> queryUserinfoAll(Userinfo userinfo);
  //根据username，password查找用户 sql语句在xml里
    Userinfo queryUserByNameAndPwd(Userinfo userinfo);

    void deleteUserByUsername(@Param("username2") String username);
}
