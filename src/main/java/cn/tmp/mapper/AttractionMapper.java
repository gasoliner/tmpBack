package cn.tmp.mapper;

import cn.tmp.po.Attraction;
import cn.tmp.po.AttractionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttractionMapper {
    long countByExample(AttractionExample example);

    int deleteByExample(AttractionExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Attraction record);

    int insertSelective(Attraction record);

    List<Attraction> selectByExample(AttractionExample example);

    Attraction selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Attraction record, @Param("example") AttractionExample example);

    int updateByExample(@Param("record") Attraction record, @Param("example") AttractionExample example);

    int updateByPrimaryKeySelective(Attraction record);

    int updateByPrimaryKey(Attraction record);
}