package com.it.cn.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.util.Date;

/**
 * 123 Entity
 *
 * @author 123
 * @date 2019-08-18 16:32:41
 */
@Data
@Entity
public class Medicine{
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private String mid;

    /**
     *
     */
    private String mname;

    /**
     *
     */
    private String mshortname;

    /**
     *
     */
    private String mnors;

    /**
     *
     */
    private String marea;

    /**
     *
     */
    private String mlot;

    /**
     *
     */
    private double minpri;

    /**
     *
     */
    private double mwpri;

    /**
     *
     */
    private double mpri;


    private int mnum;
    /**
     *
     */
    private String mcon;

    /**
     *
     */
    private String mcate;

    /*表格显示格式*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /*格式化日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jtime;

    /*表格显示格式*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    /*格式化日期*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date musetime;

    /**
     *
     */
    private String memo;

}
