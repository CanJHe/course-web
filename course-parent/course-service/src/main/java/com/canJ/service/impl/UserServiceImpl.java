package com.canJ.service.impl;

import com.canJ.mapper.StudentMapper;
import com.canJ.mapper.TeacherMapper;
import com.canJ.mapper.UserMapper;
import com.canJ.pojo.*;
import com.canJ.service.UserService;
import com.canJ.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private HttpSession session;

    @Override
    public boolean addUser(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo(user.getName());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0){
            user.setPassword(MD5.generateMD5(user.getPassword()));
            int insert = userMapper.insertSelective(user);
            if (insert > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public User loginUser(User user) {
        if (user.getName() == null || "".equals(user.getName())){
            return null;
        }
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(user.getName()).andPasswordEqualTo(MD5.generateMD5(user.getPassword()));
        List<User> users = userMapper.selectByExample(example);
       if (users.size() > 0){
           return users.get(0);
       }
       return null;
    }

    @Override
    public List<Student> selectStudents() {
        StudentExample example = new StudentExample();
        return studentMapper.selectByExample(example);
    }

    @Override
    public Student findStudentById(int studentid) {
        return studentMapper.selectByPrimaryKey(studentid);
    }

    @Override
    public boolean addStudent(Student student) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andNameEqualTo(student.getName());
        List<Student> students = studentMapper.selectByExample(studentExample);
        if (students.size() > 0){
            return false;
        }
        student.setPassword(MD5.generateMD5(student.getPassword()));
        int result = studentMapper.insertSelective(student);
        if (result > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addStudents(List<Student> students) {
       if (students != null){
           for (Student student:
                students){
               StudentExample example = new StudentExample();
               example.createCriteria().andNameEqualTo(student.getName());
               List<Student> studentList = studentMapper.selectByExample(example);
               if (studentList.size() > 0){
                   return false;
               }
               int result = studentMapper.insertSelective(student);
               if (result < 0){
                   return false;
               }
           }
          return true;
       }
        return false;
    }

    @Override
    public boolean deleteStudent(int studentid) {
        Student student = studentMapper.selectByPrimaryKey(studentid);
        if (student != null){
            int result = studentMapper.deleteByPrimaryKey(student.getStudentid());
            if (result > 0){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        StudentExample example = new StudentExample();
        example.createCriteria().andNameEqualTo(student.getName());
        List<Student> students = studentMapper.selectByExample(example);
        if (students.size() > 0){
            int result = studentMapper.updateByExampleSelective(student, example);
            if (result > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andNameEqualTo(teacher.getName());
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        if (teachers.size() > 0){
            return false;
        }
        int result = teacherMapper.insertSelective(teacher);
        if (result > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addTeachers(List<Teacher> teachers) {
        if (teachers != null){
            for (Teacher teacher:
                    teachers){
                TeacherExample teacherExample = new TeacherExample();
                teacherExample.createCriteria().andNameEqualTo(teacher.getName());
                List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
                if (teacherList.size() > 0){
                    return false;
                }
                int result = teacherMapper.insertSelective(teacher);
                if (result < 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTeacher(int teacherid) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(teacherid);
        if (teacher != null){
            int result = teacherMapper.deleteByPrimaryKey(teacher.getTeacherid());
            if (result > 0){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andNameEqualTo(teacher.getName());
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        if (teachers.size() > 0){
            int result = teacherMapper.updateByExampleSelective(teacher, teacherExample);
            if (result > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean findByPhone(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUserPhoneEqualTo(user.getUserPhone());
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserByPhone(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUserPhoneEqualTo(user.getUserPhone());
        user.setPassword(MD5.generateMD5(user.getPassword()));
        int result = userMapper.updateByExampleSelective(user, example);
        if (result > 0) {
            User user1 = userMapper.selectByPrimaryKey(user.getUserid());
            session.removeAttribute("user");
            session.setAttribute("user",user1);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserById(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUseridEqualTo(user.getUserid());
        int result = userMapper.updateByExampleSelective(user, example);
        if (result > 0) {
            User user1 = userMapper.selectByPrimaryKey(user.getUserid());
            session.removeAttribute("user");
            session.setAttribute("user",user1);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUserPhoneEqualTo(user.getUserPhone());
        int i = userMapper.updateByExampleSelective(user, example);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean forbitStudent(int studentid) {
        Student student = studentMapper.selectByPrimaryKey(studentid);
        if (student.getStuState() != 0){
            student.setStuState((short)0);
            int result = studentMapper.updateByPrimaryKey(student);
            if (result > 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cancelForbitStudent(int studentid) {
        Student student = studentMapper.selectByPrimaryKey(studentid);
        if (student.getStuState() == 0){
            student.setStuState((short)1);
            int result = studentMapper.updateByPrimaryKey(student);
            if (result > 0){
                return true;
            }
        }
        return false;
    }
}
