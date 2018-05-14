package cn.tmp.service.impl;

import cn.tmp.mapper.RegionMapper;
import cn.tmp.po.Region;
import cn.tmp.po.RegionExample;
import cn.tmp.po.Page;
import cn.tmp.service.RegionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("regionService")
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionMapper regionMapper;

    long total = 0L;

    @Override
    public List<Region> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Region> list = regionMapper.selectByExample(new RegionExample());
        PageInfo<Region> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Region record) {
        return regionMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return regionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Region record) {
        return regionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public Region selectByPrimaryKey(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }
}
