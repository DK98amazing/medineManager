package com.it.cn.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class SysUser  implements Serializable {

    /*主键*/
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)  //定义主键的生成策略
    private String sysid;
    private String sysuserLogin;
    private String sysuserPassWord;
    private String sysuserName;
    private Integer sysuserAge;
    private String sysFile;
    private String roleId;
    private SysRole role;
    private String status;
    private String code;

    /*表格显示格式*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /*格式化日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date syscreateTime;
//    private String isRememberMe;

}
