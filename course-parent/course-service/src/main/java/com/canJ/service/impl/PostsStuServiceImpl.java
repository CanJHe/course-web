package com.canJ.service.impl;

import com.canJ.mapper.PostsStuMapper;
import com.canJ.pojo.PostsStu;
import com.canJ.pojo.PostsStuExample;
import com.canJ.pojo.StuPost;
import com.canJ.pojo.Student;
import com.canJ.service.PostsStuService;
import com.canJ.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
/**
 * 学生发帖service
 */
public class PostsStuServiceImpl implements PostsStuService {

    @Autowired
    private PostsStuMapper postsStuMapper;

    @Autowired
    private StudentService studentService;

    @Autowired
    private HttpSession session;

    @Override
    public List<PostsStu> findAll() {
        PostsStuExample example = new PostsStuExample();
        List<PostsStu> postsStus = postsStuMapper.selectByTime(example);
        return postsStus;
    }

    @Override
    public List<StuPost> finaMyPosts() {
        Student student = (Student) session.getAttribute("student");
        if (student != null){
            PostsStuExample example = new PostsStuExample();
            example.createCriteria().andStudentidEqualTo(student.getStudentid());
            List<PostsStu> postsStus = postsStuMapper.selectByExample(example);
            List<StuPost> posts = new ArrayList<>();
            for (PostsStu post: postsStus
            ) {
                StuPost stuPost = new StuPost();
                stuPost.setContent(post.getContent());
                stuPost.setPostId(post.getPostid());
                stuPost.setTime(post.getPostdate());
                stuPost.setStuId(post.getStudentid());
                Student byId = studentService.findById(post.getStudentid());
                stuPost.setStuName(byId.getName());
                posts.add(stuPost);
            }
            return posts;
        }
        return null;
    }

    @Override
    public PostsStu findById(Integer integer) {
        PostsStuExample example = new PostsStuExample();
        example.createCriteria().andPostidEqualTo(integer);
        List<PostsStu> postsStus = postsStuMapper.selectByExample(example);
        if (postsStus.size() == 1){
            return postsStus.get(0);
        }
        return null;
    }

    @Override
    public boolean insert(PostsStu stu) {
        int i = postsStuMapper.insertSelective(stu);
        if (i > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePost(int postId) {
        int result = postsStuMapper.deleteByPrimaryKey(postId);
        if (result > 0){
            return true;
        }
        return false;
    }
}
