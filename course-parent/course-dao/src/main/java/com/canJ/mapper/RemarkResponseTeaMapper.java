package com.canJ.mapper;

import com.canJ.pojo.RemarkResponseTea;
import com.canJ.pojo.RemarkResponseTeaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemarkResponseTeaMapper {
    int countByExample(RemarkResponseTeaExample example);

    int deleteByExample(RemarkResponseTeaExample example);

    int deleteByPrimaryKey(Integer responseId);

    int insert(RemarkResponseTea record);

    int insertSelective(RemarkResponseTea record);

    List<RemarkResponseTea> selectByExample(RemarkResponseTeaExample example);

    RemarkResponseTea selectByPrimaryKey(Integer responseId);

    int updateByExampleSelective(@Param("record") RemarkResponseTea record, @Param("example") RemarkResponseTeaExample example);

    int updateByExample(@Param("record") RemarkResponseTea record, @Param("example") RemarkResponseTeaExample example);

    int updateByPrimaryKeySelective(RemarkResponseTea record);

    int updateByPrimaryKey(RemarkResponseTea record);
}