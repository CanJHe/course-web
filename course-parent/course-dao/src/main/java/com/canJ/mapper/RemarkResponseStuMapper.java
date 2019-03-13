package com.canJ.mapper;

import com.canJ.pojo.RemarkResponseStu;
import com.canJ.pojo.RemarkResponseStuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemarkResponseStuMapper {
    int countByExample(RemarkResponseStuExample example);

    int deleteByExample(RemarkResponseStuExample example);

    int deleteByPrimaryKey(Integer responseId);

    int insert(RemarkResponseStu record);

    int insertSelective(RemarkResponseStu record);

    List<RemarkResponseStu> selectByExample(RemarkResponseStuExample example);

    RemarkResponseStu selectByPrimaryKey(Integer responseId);

    int updateByExampleSelective(@Param("record") RemarkResponseStu record, @Param("example") RemarkResponseStuExample example);

    int updateByExample(@Param("record") RemarkResponseStu record, @Param("example") RemarkResponseStuExample example);

    int updateByPrimaryKeySelective(RemarkResponseStu record);

    int updateByPrimaryKey(RemarkResponseStu record);
}