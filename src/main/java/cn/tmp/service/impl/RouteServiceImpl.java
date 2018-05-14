package cn.tmp.service.impl;

import cn.tmp.mapper.RouteMapper;
import cn.tmp.po.Page;
import cn.tmp.po.Route;
import cn.tmp.po.RouteExample;
import cn.tmp.service.RouteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("routeService")
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteMapper routeMapper;

    long total = 0L;

    @Override
    public List<Route> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Route> list = routeMapper.selectByExample(new RouteExample());
        PageInfo<Route> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Route record) {
        return routeMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return routeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Route record) {
        return routeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }
}
