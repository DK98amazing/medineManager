package com.it.cn.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class SysRole  implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String rolename;
    private String description; // 角色描述
    private Boolean available = Boolean.FALSE; // 默认不可用
    //角色 -- 权限关系：多对多关系; 取出这条数据时，把它关联的数据也同时取出放入内存中
    @ManyToMany(fetch= FetchType.EAGER)
    private List<SysPermission> permissions;
    // 用户 - 角色关系：多对多关系;
    @ManyToMany
    private List<SysUser> users;
    private String delflag;
}
