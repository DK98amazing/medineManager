package com.it.cn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
public class Stock {
    private String id;
    private String mid;   //库存表ID
    private String mname;  //药品名称
    private double mprice;  //药品价格
    private int mnum;   //药品数量
    private String spid;  //供应商号

    /*表格显示格式*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /*格式化日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date stime;  //进货时间

    /*表格显示格式*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    /*格式化日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ytime;  //有效期
    private String stype;

    private String overdue; //是否过期
    private int status;

    public Stock(){

    }

    public Stock(String mname, double mprice, int mnum, String spid, Date stime, Date ytime, String stype) {
        this.mname = mname;
        this.mprice = mprice;
        this.mnum = mnum;
        this.spid = spid;
        this.stime = stime;
        this.ytime = ytime;
        this.stype = stype;
    }
}
