package com.canJ.mapper;

import com.canJ.pojo.PostsStu;
import com.canJ.pojo.PostsStuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostsStuMapper {
    int countByExample(PostsStuExample example);

    int deleteByExample(PostsStuExample example);

    int deleteByPrimaryKey(Integer postid);

    int insert(PostsStu record);

    int insertSelective(PostsStu record);

    List<PostsStu> selectByExample(PostsStuExample example);

    PostsStu selectByPrimaryKey(Integer postid);

    int updateByExampleSelective(@Param("record") PostsStu record, @Param("example") PostsStuExample example);

    int updateByExample(@Param("record") PostsStu record, @Param("example") PostsStuExample example);

    int updateByPrimaryKeySelective(PostsStu record);

    int updateByPrimaryKey(PostsStu record);

    List<PostsStu> selectByTime(PostsStuExample example);
}