package com.canJ.service;

import com.canJ.pojo.ResponseResult;
import com.canJ.pojo.Student;
import com.canJ.pojo.Teacher;
import com.canJ.pojo.User;

import java.util.List;

public interface UserService {
    /**
     * 添加管理员
     * @param user 用户信息实体
     */
    boolean addUser(User user);

    /**
     * 管理员登录
     * @param user 用户实体信息
     * @return
     */
    User loginUser(User user);

    /**
     * 查询所有学生
     * @return
     */
    List<Student> selectStudents();

    /**
     * 通过学生id查找学生
     * @param studentid
     * @return
     */
    Student findStudentById(int studentid);

    /**
     * 添加学生
     * @param student 学生实体信息
     * @return
     */
    boolean addStudent(Student student);

    /**
     * 批量添加学生
     * @param students 学生的list集合
     * @return
     */
    boolean addStudents(List<Student> students);

    /**
     * 删除学生
     * @return
     */
    boolean deleteStudent(int studentid);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    boolean updateStudent(Student student);

    /**
     *忘记密码通过手机号查找
     */
    boolean findByPhone(User user);

    /**
     * 修改管理员密码
     */
    boolean updateUser(User user);


    /**
     * 添加学生
     * @param teacher 学生实体信息
     * @return
     */
    boolean addTeacher(Teacher teacher);

    /**
     * 批量添加学生
     * @param teachers 学生的list集合
     * @return
     */
    boolean addTeachers(List<Teacher> teachers);

    /**
     * 删除学生
     * @return
     */
    boolean deleteTeacher(int teacherid);

    /**
     * 修改学生信息
     * @param teacher
     * @return
     */
    boolean updateTeacher(Teacher teacher);

    /**
     * 修改管理员密码
     */
    boolean updateUserByPhone(User user);

    /**
     * 修改管理员信息
     */
    boolean updateUserById(User user);

    /**
     * 禁言学生
     * @param studentid
     * @return
     */
    boolean forbitStudent(int studentid);

    /**
     * 取消学生禁言
     * @param studentid
     * @return
     */
    boolean cancelForbitStudent(int studentid);

}
