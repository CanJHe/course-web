package com.canJ.mapper;

import com.canJ.pojo.FocusTea;
import com.canJ.pojo.FocusTeaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FocusTeaMapper {
    int countByExample(FocusTeaExample example);

    int deleteByExample(FocusTeaExample example);

    int deleteByPrimaryKey(Integer focusid);

    int insert(FocusTea record);

    int insertSelective(FocusTea record);

    List<FocusTea> selectByExample(FocusTeaExample example);

    FocusTea selectByPrimaryKey(Integer focusid);

    int updateByExampleSelective(@Param("record") FocusTea record, @Param("example") FocusTeaExample example);

    int updateByExample(@Param("record") FocusTea record, @Param("example") FocusTeaExample example);

    int updateByPrimaryKeySelective(FocusTea record);

    int updateByPrimaryKey(FocusTea record);
}