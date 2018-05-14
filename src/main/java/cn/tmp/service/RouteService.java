package cn.tmp.service;

import cn.tmp.po.Page;
import cn.tmp.po.Route;
import cn.tmp.vo.VoRoute;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface RouteService {
    List<Route> list(Page page);

    int insert(Route record);

    int delete(Integer id);

    int update(Route record);

    long count();

    List<VoRoute> vo(List<Route> list);
}
