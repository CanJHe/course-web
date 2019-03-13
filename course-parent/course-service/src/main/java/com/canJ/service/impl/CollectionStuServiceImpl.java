package com.canJ.service.impl;

import com.canJ.mapper.CollectionStuMapper;
import com.canJ.mapper.CollectionTeaMapper;
import com.canJ.mapper.ResourceMapper;
import com.canJ.pojo.*;
import com.canJ.service.CollectionStuService;
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
public class CollectionStuServiceImpl implements CollectionStuService {

    @Autowired
    private CollectionStuMapper collectionStuMapper;

    @Autowired
    private CollectionTeaMapper collectionTeaMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private HttpSession session;

    @Override
    public boolean collectResource(int resourceId) {
        Student student = (Student) session.getAttribute("student");
        Resource resource = resourceMapper.selectByPrimaryKey(resourceId);
        if (resource == null){
            return false;
        }
        CollectionStu collectionStu = new CollectionStu();
        if (student != null){
            collectionStu.setCreatetime(new Date());
            collectionStu.setResourceid(resource.getResourceid());
            collectionStu.setStudentid(student.getStudentid());
            int result = collectionStuMapper.insertSelective(collectionStu);
            if (result > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cancelCollectResource(int resourceId) {
        Student student = (Student) session.getAttribute("student");
        CollectionStuExample example = new CollectionStuExample();
        example.createCriteria().andResourceidEqualTo(resourceId).andStudentidEqualTo(student.getStudentid());
        int result = collectionStuMapper.deleteByExample(example);
        if (result > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<ResponseCollectionBody> selectMyCollection() {
        Student student = (Student) session.getAttribute("student");
        CollectionStuExample example = new CollectionStuExample();
        example.createCriteria().andStudentidEqualTo(student.getStudentid());
        List<CollectionStu> collections = collectionStuMapper.selectByExample(example);
        List<ResponseCollectionBody> collectionBodies = new ArrayList<>();
        collections.forEach(collection ->{
            ResponseCollectionBody collectionBody = new ResponseCollectionBody();
            Resource resource = resourceMapper.selectByPrimaryKey(collection.getResourceid());
            collectionBody.setResource(resource);
            collectionBody.setCollectionid(collection.getCollectionid());
            collectionBody.setCreatetime(collection.getCreatetime());
            collectionBody.setStudentid(student.getStudentid());
            collectionBodies.add(collectionBody);
        });
        return collectionBodies;
    }

    @Override
    public boolean isCollection(int resourceId) {
        Student student = (Student) session.getAttribute("student");
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        if (student != null){
            CollectionStuExample example = new CollectionStuExample();
            example.createCriteria().andResourceidEqualTo(resourceId).andStudentidEqualTo(student.getStudentid());
            List<CollectionStu> collectionStuList = collectionStuMapper.selectByExample(example);
            if (collectionStuList.size() > 0){
                return true;
            }
        }else if (teacher != null){
            CollectionTeaExample example = new CollectionTeaExample();
            example.createCriteria().andTeacheridEqualTo(teacher.getTeacherid()).andResourceidEqualTo(resourceId);
            List<CollectionTea> collectionTeas = collectionTeaMapper.selectByExample(example);
            if (collectionTeas.size() > 0){
                return true;
            }
        }
        return false;
    }
}
