package cn.tmp.controller;

import cn.tmp.po.User;
import cn.tmp.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"} )
public class LoginController {

    @Autowired
    UserService userService;
    

    @RequestMapping("/login")
    @ResponseBody
    public void login(String name, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(
                name,
                password
        );
        try {
            currentUser.login(token);
            User user = userService.selectByPrimaryKey(Integer.parseInt(name));
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/login_ui");
        }
        return;
    }

    @RequestMapping("/logout")
    public void logout(HttpServletResponse response) throws IOException {
        SecurityUtils.getSubject().logout();
        response.sendRedirect("/");
        return;
    }

}
