package com.canJ.mapper;

import com.canJ.pojo.CollectionTea;
import com.canJ.pojo.CollectionTeaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectionTeaMapper {
    int countByExample(CollectionTeaExample example);

    int deleteByExample(CollectionTeaExample example);

    int deleteByPrimaryKey(Integer collectionid);

    int insert(CollectionTea record);

    int insertSelective(CollectionTea record);

    List<CollectionTea> selectByExample(CollectionTeaExample example);

    CollectionTea selectByPrimaryKey(Integer collectionid);

    int updateByExampleSelective(@Param("record") CollectionTea record, @Param("example") CollectionTeaExample example);

    int updateByExample(@Param("record") CollectionTea record, @Param("example") CollectionTeaExample example);

    int updateByPrimaryKeySelective(CollectionTea record);

    int updateByPrimaryKey(CollectionTea record);
}