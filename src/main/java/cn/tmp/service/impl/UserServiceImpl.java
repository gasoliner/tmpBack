package cn.tmp.service.impl;

import cn.tmp.mapper.UserMapper;
import cn.tmp.po.User;
import cn.tmp.po.UserExample;
import cn.tmp.po.Page;
import cn.tmp.service.ConsumerService;
import cn.tmp.service.RoleService;
import cn.tmp.service.UserService;
import cn.tmp.util.TimeUtils;
import cn.tmp.vo.VoUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    RoleService roleService;

    @Autowired
    UserMapper userMapper;

    long total = 0L;

    @Override
    public List<User> list(Page page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        List<User> list = userMapper.selectByExample(new UserExample());
        PageInfo<User> pageInfo = new PageInfo<>(list);
        this.total = pageInfo.getTotal();
        return list;
    }

    @Override
    public int insert(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public long count() {
        return total;
    }

    @Override
    public User selectByPrimaryKey(Integer hid) {
        return userMapper.selectByPrimaryKey(hid);
    }

    @Override
    public List<VoUser> vo(List<User> list) {
        List<VoUser> list1 = new ArrayList<>();
        for (User user:
                list) {
            VoUser voUser = new VoUser(user);
            voUser.setVoPassword("<a href = \"#\" onclick=\"resetUserPassword('" + voUser.getUid() + "')\">重置用户密码</a>");
            voUser.setVoRole(roleService.selectByPrimaryKey(voUser.getRid()).getRole());
            list1.add(voUser);
        }
        return list1;
    }

}
