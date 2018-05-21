package cn.tmp.service;

import cn.tmp.po.Consumer;
import cn.tmp.po.Page;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface ConsumerService {
    List<Consumer> list(Page page);

    int insert(Consumer record);

    int delete(Integer id);

    int update(Consumer record);

    long count();

    Consumer selectByPrimaryKey(Integer hid);

}
