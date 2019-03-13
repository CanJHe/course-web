package com.canJ.service.impl;

import com.canJ.mapper.PostsTeaMapper;
import com.canJ.pojo.PostsTea;
import com.canJ.pojo.PostsTeaExample;
import com.canJ.service.PostsTeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 教师发帖service
 */
public class PostsTeaServiceImpl implements PostsTeaService {

    @Autowired
    private PostsTeaMapper postsTeaMapper;

    @Autowired
    private HttpSession session;

    @Override
    public List<PostsTea> findAll() {
        PostsTeaExample example = new PostsTeaExample();
        List<PostsTea> postsTeas = postsTeaMapper.selectByTime(example);
        return postsTeas;
    }

    @Override
    public boolean insert(PostsTea tea) {
        int i = postsTeaMapper.insertSelective(tea);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public PostsTea findById(Integer integer) {
        PostsTeaExample example = new PostsTeaExample();
        example.createCriteria().andPostidEqualTo(integer);
        List<PostsTea> postsTeas = postsTeaMapper.selectByExample(example);
        if (postsTeas.size() == 1){
            return postsTeas.get(0);
        }
        return null;
    }
}
