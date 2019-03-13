package com.canJ.service.impl;

import com.canJ.mapper.CourseMapper;
import com.canJ.pojo.Course;
import com.canJ.pojo.CourseExample;
import com.canJ.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 课程service
 */
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private HttpSession session;

    @Override
    public List<Course> findAllById(Integer integer) {
        CourseExample example = new CourseExample();
        example.createCriteria().andTeacheridEqualTo(integer);
        List<Course> courses = courseMapper.selectByExample(example);
        return courses;
    }

    @Override
    public boolean teaCourse(Course course) {
        CourseExample example = new CourseExample();
        example.createCriteria().andCouridEqualTo(course.getCourid());
        int i = courseMapper.updateByExampleSelective(course,example);
        if (i > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Course> findByStuId(Integer stuId) {
        CourseExample example = new CourseExample();
        example.createCriteria().andStudentidEqualTo(stuId);
        List<Course> courses = courseMapper.selectByExample(example);
        return courses;
    }
}
