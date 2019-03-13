package com.canJ.service.impl;

import com.canJ.mapper.StudentMapper;
import com.canJ.pojo.Student;
import com.canJ.pojo.StudentExample;
import com.canJ.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 学生service
 */
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Autowired
    private HttpSession session;

    @Override
    public boolean stuLogin(Student student) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andNameEqualTo(student.getName()).andPasswordEqualTo(student.getPassword());
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students.size() > 0){
            //将用户信息保存到session会话中
            session.invalidate();
            session.setAttribute("student",students.get(0));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean forget(Student student) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStuPhoneEqualTo(student.getStuPhone());
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students.size() != 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean reset(Student student) {
        StudentExample studentExample = new StudentExample();
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        StudentExample example = new StudentExample();
        example.createCriteria().andStudentidEqualTo(student.getStudentid());
        int i = studentMapper.updateByExampleSelective(student, example);
        if (i == 1){
            return true;
        }
        return false;
    }

    @Override
    public Student findById(Integer id) {
        StudentExample example = new StudentExample();
        example.createCriteria().andStudentidEqualTo(id);
        List<Student> students = studentMapper.selectByExample(example);
        if (students.size() == 1){
            return students.get(0);
        }
        return null;
    }

    @Override
    public List<Student> findStudentByNameOrClass(String name) {
        List<Student> students = studentMapper.selectStudentByNameOrClass(name);
        return students;
    }
}
