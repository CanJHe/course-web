package com.canJ.service;

import com.canJ.pojo.Course;

import java.util.List;

/**
 * 课程service
 */
public interface CourseService {

    /**
     * 通过学号查找课程
     */
    List<Course> findByStuId(Integer stuId);


    /**
     * 查询所有的教师信息
     */
    List<Course> findAllById(Integer integer);

    /**
     * 教师打分
     */
    boolean teaCourse(Course course);
}
