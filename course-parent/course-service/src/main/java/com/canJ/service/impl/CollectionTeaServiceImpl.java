package com.canJ.service.impl;

import com.canJ.mapper.CollectionTeaMapper;
import com.canJ.mapper.ResourceMapper;
import com.canJ.pojo.*;
import com.canJ.service.CollectionTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 学生收藏service
 */
public class CollectionTeaServiceImpl implements CollectionTeaService {

    @Autowired
    private CollectionTeaMapper collectionTeaMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private HttpSession session;

    @Override
    public boolean collectResource(int resourceId) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        Resource resource = resourceMapper.selectByPrimaryKey(resourceId);
        if (resource == null){
            return false;
        }
        CollectionTea collectionTea = new CollectionTea();
        if (teacher != null){
            collectionTea.setCreatetime(new Date());
            collectionTea.setResourceid(resource.getResourceid());
            collectionTea.setTeacherid(teacher.getTeacherid());
            int result = collectionTeaMapper.insertSelective(collectionTea);
            if (result > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cancelCollectResource(int resourceId) {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        CollectionTeaExample example = new CollectionTeaExample();
        example.createCriteria().andResourceidEqualTo(resourceId).andTeacheridEqualTo(teacher.getTeacherid());
        int result = collectionTeaMapper.deleteByExample(example);
        if (result > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<ResponseCollectionBody> selectMyCollection() {
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        CollectionTeaExample example = new CollectionTeaExample();
        example.createCriteria().andTeacheridEqualTo(teacher.getTeacherid());
        List<CollectionTea> collections = collectionTeaMapper.selectByExample(example);
        List<ResponseCollectionBody> collectionBodies = new ArrayList<>();
        collections.forEach(collection ->{
            ResponseCollectionBody collectionBody = new ResponseCollectionBody();
            Resource resource = resourceMapper.selectByPrimaryKey(collection.getResourceid());
            collectionBody.setResource(resource);
            collectionBody.setCollectionid(collection.getCollectionid());
            collectionBody.setCreatetime(collection.getCreatetime());
            collectionBody.setTeacherId(teacher.getTeacherid());
            collectionBodies.add(collectionBody);
        });
        return collectionBodies;
    }
}
