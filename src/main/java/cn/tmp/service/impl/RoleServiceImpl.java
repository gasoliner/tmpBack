package cn.tmp.service.impl;

import cn.tmp.mapper.RoleMapper;
import cn.tmp.po.Role;
import cn.tmp.po.RoleExample;
import cn.tmp.po.Page;
import cn.tmp.service.ConsumerService;
import cn.tmp.service.RoleService;
import cn.tmp.util.TimeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    long total = 0L;

    @Override
    public List<Role> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<Role> list = roleMapper.selectByExample(new RoleExample());
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public Role selectByPrimaryKey(Integer hid) {
        return roleMapper.selectByPrimaryKey(hid);
    }

}
