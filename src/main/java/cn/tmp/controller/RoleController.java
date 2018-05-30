package cn.tmp.controller;

import cn.tmp.po.DataGrid;
import cn.tmp.po.Page;
import cn.tmp.po.Role;
import cn.tmp.service.RoleService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/role",produces = {"application/json;charset=UTF-8"} )
public class RoleController {

    @Autowired
    RoleService roleService;


    @RequestMapping("/ddllist")
    @ResponseBody
    public String ddlList() {
        return JSON.toJSONString(roleService.list(new Page()));
    }
    
    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(roleService.list(page));
        dataGrid.setTotal(roleService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Role role) {
        try {
            roleService.insert(role);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Role role) {
        role.setRid(id);
        try {
            roleService.update(role);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            roleService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }
    
}
