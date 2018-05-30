package cn.tmp.service;

import cn.tmp.po.Special;
import cn.tmp.po.Page;
import cn.tmp.vo.VoSpecial;

import java.util.List;


public interface SpecialService {
    List<Special> list(Page page);

    int insert(Special record);

    int delete(Integer id);

    int update(Special record);

    long count();

    List<VoSpecial> vo(List<Special> list);

    Special selectByPrimaryKey(Integer id);
}
