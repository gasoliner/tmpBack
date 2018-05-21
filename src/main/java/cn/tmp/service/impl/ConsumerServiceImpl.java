package cn.tmp.service.impl;

import cn.tmp.mapper.ConsumerMapper;
import cn.tmp.po.Consumer;
import cn.tmp.po.ConsumerExample;
import cn.tmp.po.Page;
import cn.tmp.service.ConsumerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    ConsumerMapper consumerMapper;

    long total = 0L;

    @Override
    public List<Consumer> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Consumer> list = consumerMapper.selectByExample(new ConsumerExample());
        PageInfo<Consumer> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Consumer record) {
        return consumerMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return consumerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Consumer record) {
        return consumerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public Consumer selectByPrimaryKey(Integer hid) {
        return consumerMapper.selectByPrimaryKey(hid);
    }

}
