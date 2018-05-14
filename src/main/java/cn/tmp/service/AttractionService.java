package cn.tmp.service;

import cn.tmp.po.Page;
import cn.tmp.po.Attraction;
import cn.tmp.vo.VoAttraction;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface AttractionService {
    List<Attraction> list(Page page);

    int insert(Attraction record);

    int delete(Integer id);

    int update(Attraction record);

    long count();

    List<VoAttraction> vo(List<Attraction> list);

    Attraction selectByPrimaryKey(Integer id);

    List<Attraction> listByRegion(Integer id);
}
