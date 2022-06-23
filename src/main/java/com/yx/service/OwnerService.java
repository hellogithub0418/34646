package com.yx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yx.model.Owner;

/**
 * 
 * @author 34646
 *
 */
public interface OwnerService extends IService<Owner> {

    PageInfo<Owner> findOwnerAll(int page, int pagesize, Owner owner);
    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Owner>
     */
    IPage<Owner> findListByPage(Integer page, Integer pageCount);


    /**
     * 添加
     *
     * @param owner 
     * @return int
     */
    int add(Owner owner);

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
     * @param owner 
     * @return int
     */
    int updateData(Owner owner);

    /**
     * id查询数据
     *
     * @param id id
     * @return Owner
     */
    Owner findById(Long id);
    
  //先在owner表通过id查询出相应的username
	//再通过username删除username表里用户
    Owner queryOwnerById(long parseLong);
    
    void deleteOwnerByOwnerIds(Integer id);

    Owner queryOwnerByName(String username);
}
