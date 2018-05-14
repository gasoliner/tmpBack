package cn.tmp.service;

import cn.tmp.po.Region;
import cn.tmp.po.Page;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface RegionService {
    List<Region> list(Page page);

    int insert(Region record);

    int delete(Integer id);

    int update(Region record);

    long count();

    Region selectByPrimaryKey(Integer id);
}
