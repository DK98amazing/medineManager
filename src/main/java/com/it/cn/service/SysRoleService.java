package com.it.cn.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.cn.dao.SysRoleDao;
import com.it.cn.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoleService")
public class SysRoleService{

    @Autowired
    private SysRoleDao roleDao;

    public SysRole get(String id) {
        return roleDao.get(id);
    }

    public SysRole get(SysRole entity) {
        return null;
    }

    public List<SysRole> findList(SysRole entity) {
        return roleDao.findList(entity);
    }

    public PageInfo findPage(int pageNum, int pageSize, SysRole entity) {
        PageHelper.startPage(0,10);
        List<SysRole> list = roleDao.findList(entity);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public void save(SysRole entity) {
        roleDao.insert(entity);
    }

    public void update(SysRole entity) {
        roleDao.update(entity);
    }

    public Boolean delete(SysRole entity) {
        int flag = roleDao.delete(entity);
        return flag>0;
    }
}
