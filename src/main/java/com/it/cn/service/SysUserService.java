package com.it.cn.service;

import com.it.cn.dao.SysUserDao;
import com.it.cn.entity.SysUser;
import com.it.cn.util.UuidUtil;
import com.it.cn.util.page.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

//@CacheConfig(cacheNames="sysUser")  //抽取缓存的公共配置
@Service  //注入dao
public class SysUserService{

    /*
    * 记录器
    * */
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysUserDao userDao;

    public SysUser findLogin(String login,String passwd) {
        return userDao.findLogin(login,passwd);
    }

    public SysUser checkLogin(String login) {
        return userDao.checkLogin(login);
    }

    public SysUser checkPsd(String psd) {
        return userDao.checkLogin(psd);
    }

    public List<SysUser> findList(SysUser entity) {
        return userDao.findList(entity);
    }

//    @Cacheable(key="#sysid"/*,keyGenerator = "wiselyKeyGenerator"*/)  //将方法的返回值放在哪个缓存中
    public SysUser get(String sysid) {
        System.out.println("查询"+sysid+"号会员");
        return userDao.get(sysid);
    }
//    @CachePut(key = "#user.sysid")
    public SysUser update(SysUser user) {
        System.out.println("更新了"+user.getSysid()+"号会员");
        userDao.update(user);
        return user;
    }

//    @CachePut(key = "#user.sysid")
    public SysUser save(SysUser user) {
        if(user.getSysid() == "" || user.getSysid() == null){
            String uuid = UuidUtil.uuid();
            user.setSysid(uuid);
            user.setStatus("0");
            user.setSysFile("/uploadFile/意大利马纳罗拉+悬崖上的小镇+五渔村4k高清风景壁纸_彼岸图网.jpg");
            InsertBefore(user);  //注册时间为当前时间
            insert(user);
        }else{
            update(user);
        }
        return user;
    }

//    @CacheEvict(beforeInvocation = true,key = "#id"/*,allEntries=true*/)
    public void delete(String id) {
        System.out.println("删除了"+id+"号会员");
        userDao.delete(id);
    }

//    @CachePut(key = "#user.sysid")
    public void insert(SysUser user) {
        System.out.println("插入"+user.getSysid()+"号会员");
        userDao.insert(user);
    }


    /**
     * 查询分页数据
     *
     * @param page   分页对象
     * @param entity
     * @return
     */
    public Page<SysUser> findPage(Page<SysUser> page, SysUser entity) {
        page.setList(findList(entity));
        return page;
    }

    /**
     *  在添加之前生成注册日期
     */
    public void InsertBefore(SysUser sysUser){
        Date data = new Date();
        sysUser.setSyscreateTime(data);
    }
}
