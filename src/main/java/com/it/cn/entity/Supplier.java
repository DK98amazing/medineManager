package com.it.cn.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Supplier {
    private String id;
    private String spid;
    private String spname;
    private String sparea;
    private String spmeno;
    private int status;
}
