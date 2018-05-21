package cn.tmp.controller;

import cn.tmp.po.DataGrid;
import cn.tmp.po.User;
import cn.tmp.po.Page;
import cn.tmp.service.UserService;
import cn.tmp.util.StringUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ww on 2018/5/12.
 */
@Controller
@RequestMapping(value = "/user",produces = {"application/json;charset=UTF-8"} )
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/password")
    @ResponseBody
    public String password(Integer uid,String oldpassword,String newpassword1,String newpassword2){
        try {
            if (
                    StringUtil.isNotEmpty(oldpassword) &&
                            StringUtil.isNotEmpty(newpassword1) &&
                            StringUtil.isNotEmpty(newpassword2) &&
                            newpassword1.equals(newpassword2)
                    ) {
                User user = userService.selectByPrimaryKey(uid);
                if (user == null) {
                    throw new Exception();
                }
                if (!user.getPassword().equals(oldpassword)) {
                    throw new Exception();
                }
                user.setPassword(newpassword1);
                userService.update(user);
                return JSON.toJSONString("修改成功，下次登录生效");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            return JSON.toJSONString("系统出错，请稍后再试");
        }
    }

    @RequestMapping("/resetPassword/{id}")
    @ResponseBody
    public String resetPassword(@PathVariable Integer id) {
        User user = new User();
        user.setUid(id);
        user.setPassword("000000");
        try {
            userService.update(user);
            return JSON.toJSONString("重置密码为000000，下次登录生效");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(userService.vo(userService.list(page)));
        dataGrid.setTotal(userService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(User user) {
        if (!StringUtil.isNotEmpty(user.getPassword())) {
            user.setPassword("000000");
        }
        try {
            userService.insert(user);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, User user) {
        user.setUid(id);
        try {
            userService.update(user);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            userService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }
    
}
