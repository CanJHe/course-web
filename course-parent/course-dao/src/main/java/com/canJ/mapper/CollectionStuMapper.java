package com.canJ.mapper;

import com.canJ.pojo.CollectionStu;
import com.canJ.pojo.CollectionStuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectionStuMapper {
    int countByExample(CollectionStuExample example);

    int deleteByExample(CollectionStuExample example);

    int deleteByPrimaryKey(Integer collectionid);

    int insert(CollectionStu record);

    int insertSelective(CollectionStu record);

    List<CollectionStu> selectByExample(CollectionStuExample example);

    CollectionStu selectByPrimaryKey(Integer collectionid);

    int updateByExampleSelective(@Param("record") CollectionStu record, @Param("example") CollectionStuExample example);

    int updateByExample(@Param("record") CollectionStu record, @Param("example") CollectionStuExample example);

    int updateByPrimaryKeySelective(CollectionStu record);

    int updateByPrimaryKey(CollectionStu record);
}