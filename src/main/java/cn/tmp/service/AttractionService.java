package cn.tmp.service;

import cn.tmp.po.Page;
import cn.tmp.po.Attraction;
import cn.tmp.vo.VoAttraction;

import java.util.List;


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
