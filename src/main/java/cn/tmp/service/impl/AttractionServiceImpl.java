package cn.tmp.service.impl;

import cn.tmp.mapper.AttractionMapper;
import cn.tmp.po.Page;
import cn.tmp.po.Attraction;
import cn.tmp.po.AttractionExample;
import cn.tmp.service.AttractionService;
import cn.tmp.service.RegionService;
import cn.tmp.vo.VoAttraction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("attractionService")
public class AttractionServiceImpl implements AttractionService {

    @Autowired
    RegionService regionService;

    @Autowired
    AttractionMapper attractionMapper;


    long total = 0L;

    @Override
    public List<Attraction> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Attraction> list = attractionMapper.selectByExample(new AttractionExample());
        PageInfo<Attraction> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Attraction record) {
        return attractionMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return attractionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Attraction record) {
        return attractionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public List<VoAttraction> vo(List<Attraction> list) {
        List<VoAttraction> list1 = new ArrayList<>();
        for (Attraction attraction:
                list) {
            VoAttraction voAttraction = new VoAttraction(attraction);
            voAttraction.setVoRid(regionService.selectByPrimaryKey(voAttraction.getRid()).getName());
            voAttraction.setVoImg("<a href = \"#\" onclick=\"showAttractionPic('" + voAttraction.getAid() + "')\">查看</a>");
            list1.add(voAttraction);
        }
        return list1;
    }

    @Override
    public Attraction selectByPrimaryKey(Integer id) {
        return attractionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Attraction> listByRegion(Integer id) {
        AttractionExample example = new AttractionExample();
        AttractionExample.Criteria criteria = example.createCriteria();
        criteria.andRidEqualTo(id);
        return attractionMapper.selectByExample(example);
    }
}
