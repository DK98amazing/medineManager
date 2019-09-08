package com.it.cn.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class SysPermission  implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;         // 名称
    private String url;         // 资源路径
    private String permission;     // 权限字符串 如：employees:create,employees:update,employees:delete
    private Boolean available = Boolean.FALSE; // 默认不可用
    @ManyToMany
    private List<SysRole> roles;
}
