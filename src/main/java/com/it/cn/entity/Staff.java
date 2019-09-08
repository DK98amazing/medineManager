package com.it.cn.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Staff {
    private String staffid;
    private String staffname;
    private String staffsex;
    private String stafftel;
    private String staffadd;
    private String staffcard;
    private String staffzip;
    private int status;
}
