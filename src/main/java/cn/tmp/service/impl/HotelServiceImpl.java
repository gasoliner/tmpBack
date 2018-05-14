package cn.tmp.service.impl;

import cn.tmp.mapper.HotelMapper;
import cn.tmp.po.Page;
import cn.tmp.po.Hotel;
import cn.tmp.po.HotelExample;
import cn.tmp.service.HotelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("hotelService")
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelMapper hotelMapper;

    long total = 0L;

    @Override
    public List<Hotel> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Hotel> list = hotelMapper.selectByExample(new HotelExample());
        PageInfo<Hotel> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Hotel record) {
        return hotelMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return hotelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Hotel record) {
        return hotelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }
    
}
