package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.api.PostServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class PostRestController {
    @Autowired
    private PostServiceApi postServiceApi;

    @GetMapping(value = "/all")
    private List<Post> getAll(){
        return postServiceApi.getAll();
    }

    private ResponseEntity<Post> post(@RequestBody Post post){
        Post obj = postServiceApi.save(post);
        return new ResponseEntity<Post>(obj, HttpStatus.OK);
    }
}
