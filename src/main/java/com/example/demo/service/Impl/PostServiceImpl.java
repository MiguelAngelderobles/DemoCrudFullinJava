package com.example.demo.service.Impl;

import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.dao.api.PostDaoApi;
import com.example.demo.model.Post;
import com.example.demo.service.api.PostServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends GenericServiceImpl<Post,Long> implements PostServiceApi{

    @Autowired
    private PostDaoApi postDaoApi;

    @Override
    public CrudRepository<Post, Long> getDao() {
        return postDaoApi;
    }
}
