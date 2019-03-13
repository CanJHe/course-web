package com.canJ.service;

import com.canJ.pojo.Remark;
import com.canJ.pojo.ResponseResult;

import java.util.List;

public interface RemarkService {
    /**
     * 查询所有的帖子学生
     */
    List<Remark> findAll(Remark remark);

    /**
     * 查询所有的帖子学生
     */
    List<Remark> findTeaAll(Remark remark);

    /**
     * 评论帖子
     * @param remark
     * @return
     */
    boolean insert(Remark remark);

    boolean insertTea(Remark remark);

    //删除评论
}
