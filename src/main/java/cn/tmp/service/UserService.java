package cn.tmp.service;

import cn.tmp.po.User;
import cn.tmp.po.Page;
import cn.tmp.vo.VoUser;

import java.util.List;


public interface UserService {
    List<User> list(Page page);
    int insert(User record);

    int delete(Integer id);

    int update(User record);

    long count();

    User selectByPrimaryKey(Integer hid);

    List<VoUser> vo(List<User> list);

}
