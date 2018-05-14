package cn.tmp.service.impl;

import cn.tmp.mapper.RouteMapper;
import cn.tmp.po.Page;
import cn.tmp.po.Route;
import cn.tmp.po.RouteExample;
import cn.tmp.service.AttractionService;
import cn.tmp.service.RegionService;
import cn.tmp.service.RouteService;
import cn.tmp.vo.VoRoute;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("routeService")
public class RouteServiceImpl implements RouteService {

    @Autowired
    AttractionService attractionService;

    @Autowired
    RegionService regionService;

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

    @Override
    public List<VoRoute> vo(List<Route> list) {
        List<VoRoute> list1 = new ArrayList<>();
        for (Route route:
                list) {
            VoRoute voRoute = new VoRoute(route);
            StringBuilder builder = new StringBuilder("开始-->");
            for (String aid:
                    voRoute.getAids().split(",")) {
                builder.append(attractionService.selectByPrimaryKey(Integer.parseInt(aid)).getName() + "-->");
            }
            builder.append("结束");
            voRoute.setVoAids(builder.toString());
            voRoute.setVoRid(regionService.selectByPrimaryKey(voRoute.getRid()).getName());
            list1.add(voRoute);
        }
        return list1;
    }
}
