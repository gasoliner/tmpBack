package cn.tmp.service;

import cn.tmp.po.Page;
import cn.tmp.po.Role;

import java.util.List;


public interface RoleService {
    List<Role> list(Page page);
    int insert(Role record);

    int delete(Integer id);

    int update(Role record);

    long count();

    Role selectByPrimaryKey(Integer hid);


}
