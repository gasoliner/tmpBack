package cn.tmp.service;

import cn.tmp.po.User;
import cn.tmp.po.Page;
import cn.tmp.vo.VoUser;

import java.util.List;

/**
 * Created by Ww on 2018/5/11.
 */
public interface UserService {
    List<User> list(Page page);
    int insert(User record);

    int delete(Integer id);

    int update(User record);

    long count();

    User selectByPrimaryKey(Integer hid);

    List<VoUser> vo(List<User> list);

}
