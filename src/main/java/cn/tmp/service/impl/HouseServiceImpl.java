package cn.tmp.service.impl;

import cn.tmp.mapper.HouseMapper;
import cn.tmp.po.House;
import cn.tmp.po.HouseExample;
import cn.tmp.po.Page;
import cn.tmp.service.HotelService;
import cn.tmp.service.HouseService;
import cn.tmp.vo.VoHouse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("houseService")
public class HouseServiceImpl implements HouseService {

    @Autowired
    HotelService hotelService;

    @Autowired
    HouseMapper houseMapper;

    long total = 0L;

    @Override
    public List<House> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<House> list = houseMapper.selectByExample(new HouseExample());
        PageInfo<House> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(House record) {
        return houseMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return houseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(House record) {
        return houseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public List<VoHouse> vo(List<House> list) {
        List<VoHouse> list1 = new ArrayList<>();
        for (House house:
                list) {
            VoHouse voHouse = new VoHouse(house);
            voHouse.setVoHid(hotelService.selectByPrimaryKey(voHouse.getHid()).getName());
            voHouse.setVoImg("<a href = \"#\" onclick=\"showHousePic('" + voHouse.getHoid() + "')\">查看图片</a>");
            list1.add(voHouse);
        }
        return list1;
    }

    @Override
    public House selectByPrimaryKey(Integer id) {
        return houseMapper.selectByPrimaryKey(id);
    }

}
