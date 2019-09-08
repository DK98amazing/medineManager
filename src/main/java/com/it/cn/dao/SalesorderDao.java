package com.it.cn.dao;

import com.it.cn.entity.Salesorder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesorderDao {
    List<Salesorder> findList(Salesorder salesorder);

    Salesorder get(String id);

    void update(Salesorder salesorder);

    void delete(String id);

    void insert(Salesorder salesorder);
}
