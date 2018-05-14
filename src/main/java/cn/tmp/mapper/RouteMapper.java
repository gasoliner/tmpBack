package cn.tmp.mapper;

import cn.tmp.po.Route;
import cn.tmp.po.RouteExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RouteMapper {
    long countByExample(RouteExample example);

    int deleteByExample(RouteExample example);

    int deleteByPrimaryKey(Integer rtid);

    int insert(Route record);

    int insertSelective(Route record);

    List<Route> selectByExample(RouteExample example);

    Route selectByPrimaryKey(Integer rtid);

    int updateByExampleSelective(@Param("record") Route record, @Param("example") RouteExample example);

    int updateByExample(@Param("record") Route record, @Param("example") RouteExample example);

    int updateByPrimaryKeySelective(Route record);

    int updateByPrimaryKey(Route record);
}