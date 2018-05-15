package cn.tmp.service;

import cn.tmp.po.Page;
import cn.tmp.po.Hotel;
import cn.tmp.vo.VoHotel;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface HotelService {
    List<Hotel> list(Page page);

    int insert(Hotel record);

    int delete(Integer id);

    int update(Hotel record);

    long count();

    Hotel selectByPrimaryKey(Integer hid);

    List<VoHotel> vo(List<Hotel> list);
}
