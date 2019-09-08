package com.it.cn.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.cn.entity.SysRole;
import com.it.cn.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleDao {
     SysRole get(String id);
     void insert(SysRole sysRole);
     SysRole get(SysRole entity);
     List<SysRole> findList(SysRole entity);
     void save(SysRole entity);
     void update(SysRole entity);
     int delete(SysRole entity);

}
