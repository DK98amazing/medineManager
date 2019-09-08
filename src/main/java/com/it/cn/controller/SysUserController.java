package com.it.cn.controller;


import com.it.cn.entity.SysRole;
import com.it.cn.entity.SysUser;
import com.it.cn.service.SysRoleService;
import com.it.cn.service.SysUserService;
import com.it.cn.util.constants.ReturnStatusConstant;
import com.it.cn.util.page.Page;
import com.it.cn.util.page.converter.restful.ResponseCode;
import com.it.cn.util.page.converter.restful.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/sysuser")
public class SysUserController {
    private final static String PREVIX = "/sys_user/";

    @Autowired
    private SysUserService userService;
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("")
    public String index() {
       return PREVIX + "sys_userList.html";
    }

    @RequestMapping("/list")
    @ResponseWrapper(ResponseCode.SUCCESS)
    public Page List(SysUser user, HttpServletRequest request) {
        Page<SysUser> page = userService.findPage(new Page(request), user);
        return page;
    }

    @RequestMapping("/form")
    public String Form(SysUser user,Model model,HttpServletRequest request) {
        String op = request.getParameter("op");
        if(user.getSysid() != null){
            user = userService.get(user.getSysid());
        }
        SysRole role = new SysRole();
        List<SysRole> roles = sysRoleService.findList(role);
        model.addAttribute("roles",roles);
        model.addAttribute("user",user);
        model.addAttribute("op",op);
        return PREVIX + "sys_userForm.html";
    }

    @RequestMapping("/save")
    @ResponseWrapper(ResponseCode.SUCCESS_SAVE)
    public SysUser save(SysUser user){
        userService.save(user);
        return user;
    }

    @RequestMapping("/delete")
    @ResponseWrapper
    public ReturnStatusConstant delete(SysUser user){
        ReturnStatusConstant returnStatusConstant =  new ReturnStatusConstant();
        try{
            userService.delete(user.getSysid());
            returnStatusConstant.setCode(ReturnStatusConstant.SUCCESS);
            returnStatusConstant.setMessage(ReturnStatusConstant.SUCCESS_MESSAGE);
        }catch (Exception e){
            log.error("删除信息出错：",e);
            returnStatusConstant.setCode(ReturnStatusConstant.FAIL);
            returnStatusConstant.setMessage(ReturnStatusConstant.SUCCESS_FAIL);
        }
        return returnStatusConstant;
    }

    /*public void delete(@RequestParam("sysid") String id){
        userService.delete(id);
    }*/

    @RequestMapping("/view")
    public String view(SysUser user,Model model){
        SysRole role = new SysRole();
        List<SysRole> roles = sysRoleService.findList(role);
        model.addAttribute("roles",roles);
        user = userService.get(user.getSysid());
        model.addAttribute("user",user);
        model.addAttribute("op","view");
        return PREVIX + "sys_userForm.html";
    }

    @RequestMapping("/personMessage")
    public String personMessage(SysUser user,SysRole role, Model model, HttpSession session){
        String loginName = (String) session.getAttribute("sysuser");
        user = userService.checkLogin(loginName);
        role = sysRoleService.get(user.getRoleId());
        model.addAttribute("sysuser",user);
        model.addAttribute("sysrole",role);
        return PREVIX + "personMessage.html";
    }

    @RequiresRoles(value={"admin"})
    @RequestMapping("/updatePsdHtml")
    public String updatePsdHtml(){
        return PREVIX + "updatePsd.html";
    }

    @RequestMapping("/updatePsd")
    @ResponseBody
    public int updatePsd(HttpServletRequest request,SysUser user,HttpSession session){
        String psd = request.getParameter("sysuserPassWord");
        String login = (String) session.getAttribute("sysuser");
        user = userService.checkLogin(login);
        String mysqlPsd = user.getSysuserPassWord();
        int result = 0;
        if(psd.equals(mysqlPsd)){
            result = 1;    //存在
        }else{
            result = 0;    //不存在
        }
        return result;
    }

    @RequestMapping("/updatemysqlPsd")
    @ResponseBody
    public int updatemysqlPsd(HttpServletRequest request,SysUser user,HttpSession session){
        String psd = request.getParameter("onNewPassWord");
        String login = (String) session.getAttribute("sysuser");
        user = userService.checkLogin(login);
        user.setSysuserPassWord(psd);
        int result = 0;
        try {
            userService.update(user);
            result = 1;
        }catch (Exception e){
            result = 0;
            e.getMessage();
        }
        return result;
    }
}
