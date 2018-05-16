package cn.tmp.mapper;

import cn.tmp.po.Special;
import cn.tmp.po.SpecialExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialMapper {
    long countByExample(SpecialExample example);

    int deleteByExample(SpecialExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Special record);

    int insertSelective(Special record);

    List<Special> selectByExample(SpecialExample example);

    Special selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Special record, @Param("example") SpecialExample example);

    int updateByExample(@Param("record") Special record, @Param("example") SpecialExample example);

    int updateByPrimaryKeySelective(Special record);

    int updateByPrimaryKey(Special record);
}