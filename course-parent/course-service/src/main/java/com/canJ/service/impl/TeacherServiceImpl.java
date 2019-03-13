package com.canJ.service.impl;

import com.canJ.mapper.TeacherMapper;
import com.canJ.pojo.Teacher;
import com.canJ.pojo.TeacherExample;
import com.canJ.service.TeacherService;
import com.canJ.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 教师service
 */
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private HttpSession session;

    @Override
    public boolean teaLogin(Teacher teacher) {
        TeacherExample example = new TeacherExample();
        example.createCriteria().andNameEqualTo(teacher.getName()).andPasswordEqualTo(MD5.generateMD5(teacher.getPassword()));
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        if (teachers.size() > 0){
            session.invalidate();
            session.setAttribute("teacher",teachers.get(0));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean teaRegister(Teacher teacher) {
        TeacherExample example = new TeacherExample();
        example.createCriteria().andNameEqualTo(teacher.getName()).andPasswordEqualTo(teacher.getPassword());
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        if (teachers.size() == 0){
            teacher.setPassword(MD5.generateMD5(teacher.getPassword()));
            int insert = teacherMapper.insert(teacher);
            if (insert == 1){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public boolean updateForget(Teacher teacher) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTeaPhoneEqualTo(teacher.getTeaPhone());
        int i = teacherMapper.updateByExampleSelective(teacher, teacherExample);
        if (i == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean findByPhone(Teacher teacher) {
        TeacherExample example = new TeacherExample();
        example.createCriteria().andTeaPhoneEqualTo(teacher.getTeaPhone());
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        if (teachers.size() == 1){
            return true;
        }
        return false;
    }

    @Override
    public Teacher findById(Integer id) {
        TeacherExample example = new TeacherExample();
        example.createCriteria().andTeacheridEqualTo(id);
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        if (teachers.size() == 1){
            return teachers.get(0);
        }
        return null;
    }

    @Override
    public boolean update(Teacher teacher) {
        TeacherExample example = new TeacherExample();
        example.createCriteria().andTeacheridEqualTo(teacher.getTeacherid());
        int i = teacherMapper.updateByExampleSelective(teacher, example);
        if (i > 0){
            return true;
        }
        return false;
    }
}
