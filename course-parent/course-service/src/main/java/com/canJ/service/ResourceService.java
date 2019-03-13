package com.canJ.service;

import com.canJ.pojo.Resource;
import com.canJ.pojo.ResponseResult;
import com.canJ.pojo.ResponseResourceBody;

import java.util.List;

public interface ResourceService {
    /**
     * 上传资源
     */
    ResponseResult uploadResource(Resource resource);

    /**
     * 下载资源
     * @return
     */
    Resource downloadResource(int resourceId);

    /**
     * 获取所有资源
     * @return
     */
    List<Resource> getAllResources();

    /**
     * 获取自己的上传资源(包含教师学生)
     * @return
     */
    List<Resource> getMyResources();

    /**
     * 通过资源名查找资源(模糊查询)
     * @param name
     * @return
     */
    List<Resource> getResourcesByName(String name);

    /**
     * 通过资源id查找资源
     * @param resourceId
     * @return
     */
    ResponseResourceBody getResourceById(int resourceId);

    /**
     * 通过资源id删除资源
     * @param resourceId
     * @return
     */
    boolean deleteResourceById(int resourceId);

    /**
     * 更新资源信息
     * @param resource
     * @return
     */
    boolean updateResource(Resource resource);
}
