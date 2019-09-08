package com.it.cn.dao;

import com.it.cn.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockDao {
    List<Stock> findList(Stock stock);

    List<Stock> findOverdueList(Stock stock);

    List<Stock> echart();

    List<Integer> echartnum();

    Stock get(String id);

    void update(Stock stock);

    void delete(String id);

    void insert(Stock stock);
}
