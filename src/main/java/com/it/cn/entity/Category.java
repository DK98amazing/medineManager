package com.it.cn.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Category {
    private int cid;
    private String cname;
    private int status;
}
