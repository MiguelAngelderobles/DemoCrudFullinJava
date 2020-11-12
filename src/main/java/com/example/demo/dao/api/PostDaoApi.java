package com.example.demo.dao.api;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Post;

public interface PostDaoApi extends CrudRepository<Post,Long>{

}
