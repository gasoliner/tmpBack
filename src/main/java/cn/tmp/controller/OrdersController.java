package cn.tmp.controller;

import cn.tmp.po.DataGrid;
import cn.tmp.po.Page;
import cn.tmp.po.Orders;
import cn.tmp.service.OrdersService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/orders",produces = {"application/json;charset=UTF-8"} )
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping("/confirm/{id}")
    @ResponseBody
    public String confirm(@PathVariable Integer id) {
        Orders orders = new Orders();
        orders.setOid(id);
        orders.setState("已确认");
        try {
            ordersService.update(orders);
            return JSON.toJSONString("确认成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/not_list")
    @ResponseBody
    public String not_list(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(ordersService.vo(ordersService.list_no(page)));
        dataGrid.setTotal(ordersService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/list")
    @ResponseBody
    public String getList(Page page){
        DataGrid dataGrid = new DataGrid();
        dataGrid.setRows(ordersService.vo(ordersService.list(page)));
        dataGrid.setTotal(ordersService.count());
        return JSON.toJSONString(dataGrid);
    }

    @RequestMapping("/addition")
    @ResponseBody
    public String add(Orders Orders) {
        try {
            ordersService.insert(Orders);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/updates/{id}")
    @ResponseBody
    public String update(@PathVariable Integer id, Orders orders) {
        orders.setOid(id);
        try {
            ordersService.update(orders);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }

    @RequestMapping("/deletion/{id}")
    @ResponseBody
    public String deletion(@PathVariable Integer id) {
        try {
            ordersService.delete(id);
            return JSON.toJSONString("操作成功");
        } catch (Exception e) {
            return JSON.toJSONString("操作失败");
        }
    }
    
}
