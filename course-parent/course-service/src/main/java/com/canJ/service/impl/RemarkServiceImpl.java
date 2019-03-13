package com.canJ.service.impl;

import com.canJ.mapper.RemarkMapper;
import com.canJ.pojo.Remark;
import com.canJ.pojo.RemarkExample;
import com.canJ.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 评论service
 */
public class RemarkServiceImpl implements RemarkService {
    @Autowired
    private RemarkMapper remarkMapper;

    @Autowired
    private HttpSession session;

    @Override
    public List<Remark> findAll(Remark remark) {
        RemarkExample example = new RemarkExample();
        example.createCriteria().andPostidStuEqualTo(remark.getPostidStu());
        List<Remark> remarks = remarkMapper.selectByTime(remark);
        return remarks;
    }

    @Override
    public List<Remark> findTeaAll(Remark remark) {
        RemarkExample example = new RemarkExample();
        example.createCriteria().andPostidStuEqualTo(remark.getPostidTea());
        List<Remark> remarks = remarkMapper.selectTeaByTime(remark);
        return remarks;
    }

    @Override
    public boolean insert(Remark remark) {
        int i = remarkMapper.insertSelective(remark);
        if (i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertTea(Remark remark) {
        int i = remarkMapper.insertSelective(remark);
        if (i > 0){
            return true;
        }
        return false;
    }
}
