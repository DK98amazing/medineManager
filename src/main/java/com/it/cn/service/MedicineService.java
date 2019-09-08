package com.it.cn.service;
  

import com.it.cn.dao.MedicineDao;
import com.it.cn.dao.MedicineDao;
import com.it.cn.entity.Medicine;
import com.it.cn.entity.Medicine;
import com.it.cn.util.UuidUtil;
import com.it.cn.util.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 123 Service
 *
 * @author 123
 * @date 2019-08-18 16:32:41
 */
@Service
public class MedicineService {
    @Autowired
    private MedicineDao medicineDao;

    public List<Medicine> findList(Medicine entity) {
        return medicineDao.findList(entity);
    }

    public Medicine get(String sysid) {
        return medicineDao.get(sysid);
    }

    public Medicine update(Medicine medicine) {
        medicineDao.update(medicine);
        return medicine;
    }

    public void delete(String id) {
        medicineDao.delete(id);
    }

    public void insert(Medicine medicine) {
        medicineDao.insert(medicine);
    }
    /**
     * 查询分页数据
     *
     * @param page   分页对象
     * @param entity
     * @return
     */
    public Page<Medicine> findPage(Page<Medicine> page, Medicine entity) {
        page.setList(findList(entity));
        return page;
    }

}  