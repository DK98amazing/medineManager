package com.it.cn.dao;

import com.it.cn.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupplierDao {
    List<Supplier> findList(Supplier supplier);

    Supplier get(String id);

    void update(Supplier supplier);

    void delete(String id);

    void insert(Supplier supplier);
}
