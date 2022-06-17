package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Userinfo;

/**
 * 服务类
 * 存放业务逻辑处理，也是一些关于数据库处理的操作，但不是直接和数据库打交道，他有接口还有接口的实现方法
 * 在接口的实现方法中需要导入mapper层，mapper层是直接跟数据库打交道的
 * mapper也是个接口，只有方法名字，具体实现在mapper.xml文件里
 * service是供我们使用的方法
 * @author 34646
 *
 */
public interface UserinfoService extends IService<Userinfo> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Userinfo>
     */
    IPage<Userinfo> findListByPage(Integer page, Integer pageCount);

    PageInfo<Userinfo> findUserinfoAll(int page, int pageSize, Userinfo userinfo);

    /**
     * 添加
     *
     * @param userinfo 
     * @return int
     */
    int add(Userinfo userinfo);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param userinfo 
     * @return int
     */
    int updateData(Userinfo userinfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return Userinfo
     */
    Userinfo findById(Long id);

    Userinfo queryUserByNameAndPwd(Userinfo userinfo);

    void deleteUserByUsername(String username);
}
