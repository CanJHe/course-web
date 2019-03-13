package com.canJ.service.impl;

import com.canJ.mapper.RemarkResponseStuMapper;
import com.canJ.service.RemarkResponseStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 学生回复评论service
 */
public class RemarkResponseStuServiceImpl implements RemarkResponseStuService {

    @Autowired
    private RemarkResponseStuMapper remarkResponseStuMapper;

    @Autowired
    private HttpSession session;

}
