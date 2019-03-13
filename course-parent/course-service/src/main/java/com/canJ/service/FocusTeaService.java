package com.canJ.service;

import com.canJ.pojo.FocusTea;

import java.util.List;

public interface FocusTeaService {
    /**
     * 查看某个老师的所有关注信息
     */
    List<FocusTea> findAll(FocusTea tea);

    /**
     * 关注老师
     * @param tea
     * @return
     */
    boolean focusTea(FocusTea tea);

    /**
     * 取消关注(老师)
     * @param integer
     * @return
     */
    boolean deleteById(Integer integer);
}
