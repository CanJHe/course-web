package com.canJ.service;

import com.canJ.pojo.PostsStu;
import com.canJ.pojo.StuPost;

import java.util.List;

public interface PostsStuService {
    /**
     * 读取所有的帖子信息
     */
    List<PostsStu> findAll();

    /**
     * 查看我的帖子
     * @return
     */
    List<StuPost> finaMyPosts();

    /**
     *根据id查询帖子信息
     * @param integer
     * @return
     */
    PostsStu findById(Integer integer);

    /**
     * 发帖子
     * @param stu
     * @return
     */
    boolean insert(PostsStu stu);
    /**
     * 删除帖子
     */
    boolean deletePost(int postId);
}
