package com.canJ.service;

import com.canJ.pojo.ResponseCollectionBody;

import java.util.List;

public interface CollectionTeaService {

    /**
     * 收藏资源
     * @param resourceId
     * @return
     */
    boolean collectResource(int resourceId);

    /**
     * 取消收藏
     * @param resourceId
     * @return
     */
    boolean cancelCollectResource(int resourceId);

    /**
     * 查看我的收藏
     * @return
     */
    List<ResponseCollectionBody> selectMyCollection();
}
