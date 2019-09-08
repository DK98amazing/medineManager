package com.it.cn.dao;

import com.it.cn.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysUserDao{
    SysUser findLogin(@Param("sysuserLogin")String login,@Param("sysuserPassWord")String passwd);

    SysUser checkLogin(String login);

    SysUser checkPsd(String psd);

    List<SysUser> findList(SysUser user);

    SysUser get(String id);

    void update(SysUser user);

    void delete(String id);

    void insert(SysUser user);
}
