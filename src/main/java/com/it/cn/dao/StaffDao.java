package com.it.cn.dao;

import com.it.cn.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffDao  {
    List<Staff> findList(Staff staff);

    Staff get(String id);

    void update(Staff staff);

    void delete(String id);

    void insert(Staff staff);
}
