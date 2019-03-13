package com.canJ.mapper;

import com.canJ.pojo.FocusStu;
import com.canJ.pojo.FocusStuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FocusStuMapper {
    int countByExample(FocusStuExample example);

    int deleteByExample(FocusStuExample example);

    int deleteByPrimaryKey(Integer focusid);

    int insert(FocusStu record);

    int insertSelective(FocusStu record);

    List<FocusStu> selectByExample(FocusStuExample example);

    FocusStu selectByPrimaryKey(Integer focusid);

    int updateByExampleSelective(@Param("record") FocusStu record, @Param("example") FocusStuExample example);

    int updateByExample(@Param("record") FocusStu record, @Param("example") FocusStuExample example);

    int updateByPrimaryKeySelective(FocusStu record);

    int updateByPrimaryKey(FocusStu record);
}