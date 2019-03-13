package com.canJ.service;

import com.canJ.pojo.FocusStu;

import java.util.List;

public interface FocusStuService {
    /**
     * 关注学生
     * @param stu
     * @return
     */
    boolean focusStu(FocusStu stu);

    /**
     * 查找所有的关注情况
     */
    List<FocusStu> findAll(FocusStu stu);

    /**
     * 取消关注(学生)
     * @param integer
     * @return
     */
    boolean deleteById(Integer integer);
}
