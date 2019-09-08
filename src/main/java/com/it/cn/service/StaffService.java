package com.it.cn.service;

import com.it.cn.dao.StaffDao;
import com.it.cn.entity.Staff;
import com.it.cn.entity.SysUser;
import com.it.cn.util.UuidUtil;
import com.it.cn.util.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffDao staffDao;

    public List<Staff> findList(Staff entity) {
        return staffDao.findList(entity);
    }

    public Staff get(String sysid) {
        return staffDao.get(sysid);
    }

    public Staff update(Staff staff) {
        staffDao.update(staff);
        return staff;
    }

    public Staff save(Staff staff) {
        if(staff.getStaffid() == "" || staff.getStaffid() == null){
            String uuid = UuidUtil.uuid();
            staff.setStaffid(uuid);
            staff.setStatus(0);
            insert(staff);
        }else{
            update(staff);
        }
        return staff;
    }

    public void delete(String id) {
        staffDao.delete(id);
    }

    public void insert(Staff staff) {
        staffDao.insert(staff);
    }
    /**
     * 查询分页数据
     *
     * @param page   分页对象
     * @param entity
     * @return
     */
    public Page<Staff> findPage(Page<Staff> page, Staff entity) {
        page.setList(findList(entity));
        return page;
    }


}
