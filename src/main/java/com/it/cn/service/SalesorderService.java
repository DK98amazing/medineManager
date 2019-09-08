package com.it.cn.service;

import com.it.cn.dao.SalesorderDao;
import com.it.cn.entity.Salesorder;
import com.it.cn.util.UuidUtil;
import com.it.cn.util.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesorderService {
    @Autowired
    private SalesorderDao salesorderDao;

    public List<Salesorder> findList(Salesorder entity) {
        return salesorderDao.findList(entity);
    }

    public Salesorder get(String sysid) {
        return salesorderDao.get(sysid);
    }

    public Salesorder update(Salesorder salesorder) {
        salesorderDao.update(salesorder);
        return salesorder;
    }

    public Salesorder save(Salesorder salesorder) {
        if(salesorder.getSoid() == "" || salesorder.getSoid() == null){
            String uuid = UuidUtil.uuid();
            salesorder.setSoid(uuid);
            salesorder.setStatus(0);
            insert(salesorder);
        }else{
            update(salesorder);
        }
        return salesorder;
    }

    public void delete(String id) {
        salesorderDao.delete(id);
    }

    public void insert(Salesorder salesorder) {
        salesorderDao.insert(salesorder);
    }
    /**
     * 查询分页数据
     *
     * @param page   分页对象
     * @param entity
     * @return
     */
    public Page<Salesorder> findPage(Page<Salesorder> page, Salesorder entity) {
        page.setList(findList(entity));
        return page;
    }

}
