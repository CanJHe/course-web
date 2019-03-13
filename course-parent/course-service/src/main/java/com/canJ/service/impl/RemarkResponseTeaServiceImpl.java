package com.canJ.service.impl;

import com.canJ.mapper.RemarkResponseTeaMapper;
import com.canJ.service.RemarkResponseTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 教师回复评论service
 */
public class RemarkResponseTeaServiceImpl implements RemarkResponseTeaService {

    @Autowired
    private RemarkResponseTeaMapper remarkResponseTeaMapper;

    @Autowired
    private HttpSession session;
}
