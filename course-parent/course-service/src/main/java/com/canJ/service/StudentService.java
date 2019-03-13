package com.canJ.service;

import com.canJ.pojo.Student;

import java.util.List;

public interface StudentService {
    /**
     * 学生登录
     * @param student
     * @return
     */
    boolean stuLogin(Student student);

    /**
     * 学生忘记密码查找学生
     */
    boolean forget(Student student);

    /**
     * 学生修改密码
     */
    boolean reset(Student student);


    /**
     * 通过id的方式进行学生信息修改
     */
    boolean updateStudent(Student student);

    /**
     * 通过id来查询学生信息
     */
    Student findById(Integer id);

    /**
     * 通过班级或名字查找学生
     * @param name
     * @return
     */
    List<Student> findStudentByNameOrClass(String name);
}
