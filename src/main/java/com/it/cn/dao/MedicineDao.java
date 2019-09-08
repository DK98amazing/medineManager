package com.it.cn.dao;
  

import com.it.cn.entity.Medicine;
import com.it.cn.entity.Medicine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 123 Dao
 *
 * @author 123
 * @date 2019-08-18 16:32:41
 */
@Mapper
public interface MedicineDao{
    List<Medicine> findList(Medicine medicine);

    Medicine get(String id);

    void update(Medicine medicine);

    void delete(String id);

    void insert(Medicine medicine);
}