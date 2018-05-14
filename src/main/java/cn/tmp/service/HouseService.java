package cn.tmp.service;

import cn.tmp.po.House;
import cn.tmp.po.Page;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface HouseService {
    List<House> list(Page page);

    int insert(House record);

    int delete(Integer id);

    int update(House record);

    long count();

}
