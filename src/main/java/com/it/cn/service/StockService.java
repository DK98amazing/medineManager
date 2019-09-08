package com.it.cn.service;

import com.it.cn.dao.MedicineDao;
import com.it.cn.dao.StockDao;
import com.it.cn.entity.Stock;
import com.it.cn.util.UuidUtil;
import com.it.cn.util.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockDao stockDao;
    @Autowired
    private MedicineDao medicineDao;

    public List<Stock> findList(Stock entity) {
        return stockDao.findList(entity);
    }

    public List<Stock> findOverdueList(Stock entity) {
        return stockDao.findOverdueList(entity);
    }

    public List<Stock> echart(){
        return stockDao.echart();
    }

    public List<Integer> echartnum(){
        return stockDao.echartnum();
    }

    public Stock get(String sysid) {
        return stockDao.get(sysid);
    }

    public Stock update(Stock stock) {
        stockDao.update(stock);
        return stock;
    }

    public Stock save(Stock stock) {
        if(stock.getId() == "" || stock.getId() == null){
            String uuid = UuidUtil.uuid();
            stock.setId(uuid);
            stock.setStatus(0);
            insert(stock);
            medicineDao.delete(stock.getMid());
        }else{
            update(stock);
        }
        return stock;
    }

    public void delete(String id) {
        stockDao.delete(id);
    }

    public void insert(Stock stock) {
        stockDao.insert(stock);
    }
    /**
     * 查询分页数据
     *
     * @param page   分页对象
     * @param entity
     * @return
     */
    public Page<Stock> findPage(Page<Stock> page, Stock entity) {
        page.setList(findList(entity));
        return page;
    }
    /**
     * 查询分页数据
     *
     * @param page   分页对象
     * @param entity
     * @return
     */
    public Page<Stock> findOverduePage(Page<Stock> page, Stock entity) {
        page.setList(findOverdueList(entity));
        return page;
    }

}
