package com.canJ.service;

import com.canJ.pojo.PostsTea;
import com.canJ.pojo.Remark;

import java.util.List;

public interface PostsTeaService {
    /**
     * 读取所有的帖子信息
     */
    List<PostsTea> findAll();

    /**
     * 发帖子
     * @param tea
     * @return
     */
    boolean insert(PostsTea tea);

    /**
     * 读取单个帖子，通过帖子id
     */
    PostsTea findById(Integer integer);
    //删除帖子
}
