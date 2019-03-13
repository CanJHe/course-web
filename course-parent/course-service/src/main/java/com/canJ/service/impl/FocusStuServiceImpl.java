package com.canJ.service.impl;

import com.canJ.mapper.FocusStuMapper;
import com.canJ.pojo.FocusStu;
import com.canJ.pojo.FocusStuExample;
import com.canJ.service.FocusStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 学生关注service
 */
public class FocusStuServiceImpl implements FocusStuService {

    @Autowired
    private FocusStuMapper focusStuMapper;

    @Autowired
    private HttpSession session;

    @Override
    public boolean focusStu(FocusStu stu) {
        System.out.println(stu.getStudentid());
        System.out.println(stu.getOtherstudentid());
        FocusStuExample example = new FocusStuExample();
        /**
         * 判断是否已经关注
         */
        example.createCriteria().andStudentidEqualTo(stu.getStudentid()).andOtherstudentidEqualTo(stu.getOtherstudentid());
        List<FocusStu> focusStus = focusStuMapper.selectByExample(example);
        if (focusStus.size() == 0){
            int i = focusStuMapper.insertSelective(stu);
            System.out.println(i);
            if (i > 0){
                return true;
            }
            return false;
        }else {
            return false;
        }
    }

    @Override
    public List<FocusStu> findAll(FocusStu stu) {
        FocusStuExample example = new FocusStuExample();
        example.createCriteria().andStudentidEqualTo(stu.getStudentid());
        List<FocusStu> focusStus = focusStuMapper.selectByExample(example);
        return focusStus;
    }

    @Override
    public boolean deleteById(Integer integer) {
        FocusStuExample example = new FocusStuExample();
        example.createCriteria().andFocusidEqualTo(integer);
        int i = focusStuMapper.deleteByExample(example);
        if (i > 0){
            return true;
        }
        return false;
    }
}
