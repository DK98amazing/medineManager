package com.it.cn.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Salesorder {
    private String soid;
    private String mid;
    private String mname;
    private int snum;
    private double price;
    private String person;
    private int status;

    public Salesorder(String mid, String mname, int snum, double price,String person) {
        this.mid = mid;
        this.mname = mname;
        this.snum = snum;
        this.price = price;
        this.person = person;
    }

    public Salesorder(){

    }

}
