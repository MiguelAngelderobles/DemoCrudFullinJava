package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.api.PostServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value= "/find/{id}")
    private Post find(@PathVariable Long id){
        return postServiceApi.get(id);
    }
    @GetMapping(value = "/save")
    private ResponseEntity<Post> save(@RequestBody Post post){
        Post obj = postServiceApi.save(post);
        return new ResponseEntity<Post>(obj, HttpStatus.OK);
    }
    @GetMapping(value = "delete")
    private ResponseEntity<Post> delete(@PathVariable Long id){
        Post post = postServiceApi.get(id);
        if(post != null){
            postServiceApi.delete(id);
        }else{
            return new ResponseEntity<Post>(post,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }
}
