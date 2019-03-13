package com.canJ.service.impl;

import com.canJ.mapper.FocusTeaMapper;
import com.canJ.pojo.FocusTea;
import com.canJ.pojo.FocusTeaExample;
import com.canJ.service.FocusTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 教师关注service
 */
public class FocusTeaServiceImpl implements FocusTeaService {

    @Autowired
    private FocusTeaMapper focusTeaMapper;

    @Autowired
    private HttpSession session;

    @Override
    public List<FocusTea> findAll(FocusTea tea) {
        FocusTeaExample example = new FocusTeaExample();
        example.createCriteria().andTeacheridEqualTo(tea.getTeacherid());
        List<FocusTea> focusTeas = focusTeaMapper.selectByExample(example);
        return focusTeas;
    }

    @Override
    public boolean focusTea(FocusTea tea) {
        FocusTeaExample example = new FocusTeaExample();
        example.createCriteria().andTeacheridEqualTo(tea.getTeacherid()).andOtherteacheridEqualTo(tea.getOtherteacherid());
        List<FocusTea> focusTeas = focusTeaMapper.selectByExample(example);
        if (focusTeas.size() == 0){
            int i = focusTeaMapper.insertSelective(tea);
            if (i > 0){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer integer) {
        FocusTeaExample example = new FocusTeaExample();
        example.createCriteria().andFocusidEqualTo(integer);
        int i = focusTeaMapper.deleteByExample(example);
        if (i > 0){
            return true;
        }
        return false;
    }
}
