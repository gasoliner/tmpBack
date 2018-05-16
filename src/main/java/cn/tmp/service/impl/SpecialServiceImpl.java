package cn.tmp.service.impl;

import cn.tmp.mapper.SpecialMapper;
import cn.tmp.po.Special;
import cn.tmp.po.SpecialExample;
import cn.tmp.po.Page;
import cn.tmp.service.AttractionService;
import cn.tmp.service.HotelService;
import cn.tmp.service.RegionService;
import cn.tmp.service.SpecialService;
import cn.tmp.vo.VoSpecial;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("specialService")
public class SpecialServiceImpl implements SpecialService {

    @Autowired
    RegionService regionService;

    @Autowired
    AttractionService attractionService;

    @Autowired
    SpecialMapper specialMapper;

    long total = 0L;

    @Override
    public List<Special> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Special> list = specialMapper.selectByExample(new SpecialExample());
        PageInfo<Special> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Special record) {
        return specialMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return specialMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Special record) {
        return specialMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public List<VoSpecial> vo(List<Special> list) {
        List<VoSpecial> list1 = new ArrayList<>();
        for (Special special:
                list) {
            VoSpecial voSpecial = new VoSpecial(special);
            voSpecial.setVoAid(attractionService.selectByPrimaryKey(voSpecial.getAid()).getName());
            voSpecial.setVoImg("<a href = \"#\" onclick=\"showSpecialPic('" + voSpecial.getSid() + "')\">查看图片</a>");
            list1.add(voSpecial);
        }
        return list1;
    }

    @Override
    public Special selectByPrimaryKey(Integer id) {
        return specialMapper.selectByPrimaryKey(id);
    }

}
