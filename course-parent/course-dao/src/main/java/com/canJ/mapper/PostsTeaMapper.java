package com.canJ.mapper;

import com.canJ.pojo.PostsTea;
import com.canJ.pojo.PostsTeaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostsTeaMapper {
    int countByExample(PostsTeaExample example);

    int deleteByExample(PostsTeaExample example);

    int deleteByPrimaryKey(Integer postid);

    int insert(PostsTea record);

    int insertSelective(PostsTea record);

    List<PostsTea> selectByExample(PostsTeaExample example);

    PostsTea selectByPrimaryKey(Integer postid);

    int updateByExampleSelective(@Param("record") PostsTea record, @Param("example") PostsTeaExample example);

    int updateByExample(@Param("record") PostsTea record, @Param("example") PostsTeaExample example);

    int updateByPrimaryKeySelective(PostsTea record);

    int updateByPrimaryKey(PostsTea record);

    List<PostsTea> selectByTime(PostsTeaExample example);
}