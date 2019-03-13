package com.canJ.service.impl;

import com.canJ.mapper.ResourceMapper;
import com.canJ.mapper.StudentMapper;
import com.canJ.mapper.TeacherMapper;
import com.canJ.pojo.*;
import com.canJ.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 资源service
 */
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private HttpSession session;

    @Override
    public ResponseResult uploadResource(Resource resource) {
        Student student = (Student) session.getAttribute("student");
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        if (student != null){
            resource.setStudentid(student.getStudentid());
            resourceMapper.insertSelective(resource);
            return ResponseResult.ok();
        }else if (teacher != null){
            resource.setTeacherid(teacher.getTeacherid());
            resourceMapper.insertSelective(resource);
            return ResponseResult.ok();
        }
        return ResponseResult.build(403,"糟糕请求");
    }

    @Override
    public Resource downloadResource(int resourceId) {
        Resource resource = resourceMapper.selectByPrimaryKey(resourceId);
        return resource;
    }

    @Override
    public List<Resource> getAllResources() {
        ResourceExample example = new ResourceExample();
        List<Resource> resources = resourceMapper.selectByExample(example);
        return resources;
    }

    @Override
    public List<Resource> getMyResources() {
        Student student = (Student)session.getAttribute("student");
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        if (student != null){
            ResourceExample example = new ResourceExample();
            example.createCriteria().andStudentidEqualTo(student.getStudentid());
            List<Resource> resources = resourceMapper.selectByExample(example);
            if (resources.size() > 0){
                return resources;
            }
        }else if (teacher != null){
            ResourceExample example = new ResourceExample();
            example.createCriteria().andTeacheridEqualTo(teacher.getTeacherid());
            List<Resource> resources = resourceMapper.selectByExample(example);
            if (resources.size() > 0){
                return resources;
            }
        }
        return null;
    }

    @Override
    public List<Resource> getResourcesByName(String name) {
        List<Resource> resources = resourceMapper.selectResourceByLikeName(name);
        return resources;
    }

    @Override
    public ResponseResourceBody getResourceById(int resourceId) {
        Resource resource = downloadResource(resourceId);
        ResponseResourceBody responseResourceBody = new ResponseResourceBody();
        if (resource.getStudentid() != null){
            Student student = studentMapper.selectByPrimaryKey(resource.getStudentid());
            responseResourceBody.setStudentName(student.getName());
        }else if (resource.getTeacherid() != null){
            Teacher teacher = teacherMapper.selectByPrimaryKey(resource.getTeacherid());
            responseResourceBody.setTeaName(teacher.getName());
        }
        responseResourceBody.setCode(resource.getCode());
        responseResourceBody.setDescn(resource.getDescn());
        responseResourceBody.setImage(resource.getImage());
        responseResourceBody.setLevel(resource.getLevel());
        responseResourceBody.setName(resource.getName());
        responseResourceBody.setResourceid(resource.getResourceid());
        responseResourceBody.setUploadTime(resource.getUploadTime());
        return responseResourceBody;
    }

    @Override
    public boolean deleteResourceById(int resourceId) {
        int result = resourceMapper.deleteByPrimaryKey(resourceId);
        if (result > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateResource(Resource resource) {
        ResourceExample example = new ResourceExample();
        example.createCriteria().andResourceidEqualTo(resource.getResourceid());
        int result = resourceMapper.updateByExample(resource, example);
        if (result > 0){
            return true;
        }
        return false;
    }
}
