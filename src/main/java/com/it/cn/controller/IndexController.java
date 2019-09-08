package com.it.cn.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.it.cn.entity.SysUser;
import com.it.cn.service.SysUserService;
import com.it.cn.util.UuidUtil;
import com.it.cn.util.page.converter.restful.ResponseCode;
import com.it.cn.util.page.converter.restful.ResponseWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import javax.xml.ws.RequestWrapper;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/")
@Controller
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    /*登陆页面*/
    @RequestMapping("")
    public String index(Model model){
      model.addAttribute("error","* * *     أنا أعيش من دون أيام     * * *");
      return "/index/login/login0.html";
    }

    /*登录失败*/
    @RequestMapping("/500")
    public String aa(){
        return "/public/error/500.html";
    }

    /*用户退出*/
    @RequestMapping("/exitLogin")
    public RedirectView loginOut(){
        //springboott页面重定向
        RedirectView redirectTarget = new RedirectView();
        redirectTarget.setContextRelative(true);
        //退出
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        redirectTarget.setUrl("");
        return redirectTarget;
    }

    /*跳转注册页面*/
    @RequestMapping("/toResign")
    public String toResign(){
        return "/index/login/resign0.html";
    }

    /*跳转登录页面*/
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/index/login/login0.html";
    }

    /*登陆*/
    @RequestMapping("/loginGet")
    public String loginGet(SysUser sysUser, HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        session.setAttribute("sysuser",sysUser.getSysuserLogin());
        String sessionCode = (String) session.getAttribute("code");
        if(sessionCode == null || session.equals("") || sysUser.getSysuserLogin() == null || sysUser.getSysuserLogin() == ""){
            return "redirect:/";
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(sysUser.getSysuserLogin(),sysUser.getSysuserPassWord());
        //获取用户登录信息
        Subject subject= SecurityUtils.getSubject();
        if (StringUtils.equalsIgnoreCase(sysUser.getCode(),sessionCode)) {
            try {
                //登录
                subject.login(usernamePasswordToken);
                SysUser user1 = (SysUser) subject.getPrincipal();
                model.addAttribute("username",user1.getSysuserLogin());
                model.addAttribute("userFile",user1.getSysFile());
                //查找用户所对应的功能
//                List<RoleFunction> roleFunctions = roleFunctionService.findFunctionByUser(user1.getId());
//                model.addAttribute("roleFunctions", JSON.toJSONString(roleFunctions));
            }catch (IncorrectCredentialsException ice){
                model.addAttribute("error","******password  error******");
                return "/index/login/login0.html";
            }catch (UnknownAccountException uae) {
                model.addAttribute("error","******userName  error******");
                return "/index/login/login0.html";
            }catch (ExcessiveAttemptsException eae) {
                model.addAttribute("error","********time  error********");
                return "/index/login/login0.html";
            }
            return "/index.html";
        }else {
            model.addAttribute("error","*******验证码错误********");
            return "/index/login/login0.html";
        }
    }

    /*查看用户名是否存在*/
    @RequestMapping("/checkUser")
    @ResponseBody
    public int checkUser(HttpServletRequest request,SysUser user){
        String checkLogin = request.getParameter("sysuserLogin");
        SysUser sysUser = sysUserService.checkLogin(checkLogin);
        int result = 0;
        if(sysUser == null){
        }else{
            result = 1;    //存在
        }
        return result;
    }

    /*房间页面*/
    @RequestMapping("/indexMain")
    public String indexMain(){
        return "index/main.html";
    }
}
