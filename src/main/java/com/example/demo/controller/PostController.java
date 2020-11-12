package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.api.PostServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class PostController {
    @Autowired
    private PostServiceApi postServiceApi;

    @RequestMapping("/")
    public String getAll(Model model){
        model.addAttribute("list",postServiceApi.getAll());
        return "index";
    }
    @RequestMapping("/{id}")
    public String getId(@PathVariable("id")Long id, Model model){
        if(id != null){
            model.addAttribute("list",postServiceApi.get(id));
        }
        return "this page";
    }
    @GetMapping("/post")
    public String post(Model model){
        model.addAttribute("post",new Post());
        return "save";
    }
    @GetMapping("/pucth/{id}")
    public String putch(@PathVariable("id") Long id,Model model){
        model.addAttribute("post",postServiceApi.get(id));
        return "save";
    }

    @PostMapping("/post")
    public String save(Post post, Model model){
        postServiceApi.save(post);
        return "redirect:/";
    }

    @GetMapping("/delete/:{id}")
    public String delete(@PathVariable Long id, Model model){
        postServiceApi.delete(id);
        return "redirect:/";
    }



}
