package cn.tmp.service.impl;

import cn.tmp.mapper.OrdersMapper;
import cn.tmp.po.Orders;
import cn.tmp.po.OrdersExample;
import cn.tmp.po.Page;
import cn.tmp.service.ConsumerService;
import cn.tmp.service.OrdersService;
import cn.tmp.util.TimeUtils;
import cn.tmp.vo.VoOrders;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    OrdersMapper ordersMapper;

    long total = 0L;

    @Override
    public List<Orders> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Orders> list = ordersMapper.selectByExample(new OrdersExample());
        PageInfo<Orders> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Orders record) {
        return ordersMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return ordersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Orders record) {
        return ordersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public Orders selectByPrimaryKey(Integer hid) {
        return ordersMapper.selectByPrimaryKey(hid);
    }

    @Override
    public List<VoOrders> vo(List<Orders> list) {
        List<VoOrders> list1 = new ArrayList<>();
        for (Orders orders:
                list) {
            VoOrders voOrders = new VoOrders(orders);
            voOrders.setVoCid(consumerService.selectByPrimaryKey(voOrders.getCid()).getName());
            voOrders.setVoPublish(TimeUtils.dateToString(voOrders.getTime()));
            if ("已支付".equals(voOrders.getState())) {
                voOrders.setVoAction("<a href = \"#\" onclick=\"confirmOrder('" + voOrders.getOid() + "')\">确认订单</a>");
            }
            list1.add(voOrders);
        }
        return list1;
    }

    @Override
    public List<Orders> listByCid(int i) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(i);
        List<Orders> list = ordersMapper.selectByExample(example);
        this.total = list.size();
        return list;
    }

    @Override
    public List<Orders> list_no(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo("已支付");
        List<Orders> list = ordersMapper.selectByExample(example);
        PageInfo<Orders> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

}
