package cn.tmp.service;

import cn.tmp.po.Orders;
import cn.tmp.po.Page;
import cn.tmp.vo.VoOrders;

import java.util.List;


public interface OrdersService {
    List<Orders> list(Page page);
    int insert(Orders record);

    int delete(Integer id);

    int update(Orders record);

    long count();

    Orders selectByPrimaryKey(Integer hid);

    List<VoOrders> vo(List<Orders> list);

    List<Orders> listByCid(int i);

    List<Orders> list_no(Page page);
}
