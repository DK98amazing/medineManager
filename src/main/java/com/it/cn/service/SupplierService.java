package com.it.cn.service;

import com.it.cn.dao.SupplierDao;
import com.it.cn.entity.Stock;
import com.it.cn.entity.Supplier;
import com.it.cn.util.UuidUtil;
import com.it.cn.util.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierDao supplierDao;

    public List<Supplier> findList(Supplier entity) {
        return supplierDao.findList(entity);
    }

    public Supplier get(String sysid) {
        return supplierDao.get(sysid);
    }

    public Supplier update(Supplier supplier) {
        supplierDao.update(supplier);
        return supplier;
    }

    public void delete(String id) {
        supplierDao.delete(id);
    }

    public void insert(Supplier supplier) {
        supplierDao.insert(supplier);
    }

    public Supplier save(Supplier supplier) {
        if(supplier.getId() == "" || supplier.getId() == null){
            String uuid = UuidUtil.uuid();
            supplier.setId(uuid);
            supplier.setStatus(0);
            insert(supplier);
        }else{
            update(supplier);
        }
        return supplier;
    }
    
    /**
     * 查询分页数据
     *
     * @param page   分页对象
     * @param entity
     * @return
     */
    public Page<Supplier> findPage(Page<Supplier> page, Supplier entity) {
        page.setList(findList(entity));
        return page;
    }

}
