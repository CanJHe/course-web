package com.canJ.service;

import com.canJ.pojo.Teacher;

public interface TeacherService {
    /**
     * 教师用户登录
     */
    boolean teaLogin(Teacher teacher);
    /**
     * 教师用户注册
     */
    boolean teaRegister(Teacher teacher);

    /**
     * 修改教师密码
     */
    boolean updateForget(Teacher teacher);
    /**
     * 查找是否存在改号码的教师
     */
    boolean findByPhone(Teacher teacher);
    /**
     * 通过id查询教师信息
     */
    Teacher findById(Integer id);

    /**
     * 更改教师信息
     */
    boolean update(Teacher teacher);
}
