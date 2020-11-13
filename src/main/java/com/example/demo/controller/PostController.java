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
        return "index.html";
    }

    @GetMapping("/show/{id}")
    public String getId(@PathVariable("id")Long id, Model model){
        if(id != null){
            model.addAttribute("list",postServiceApi.get(id));
        }
        return "show";
    }

    @GetMapping("/save/{id}")
    public String showSave(@PathVariable(value="id")  Long id, Model model){
        if(id != null &&id !=0){
            model.addAttribute("post",postServiceApi.get(id));
        }else {
            model.addAttribute("post",new Post());
        }
        return "save";
    }

    @PostMapping("/save")
    public String save(Post post,Model model){
        postServiceApi.save(post);
        return "redirect:index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value="id") Long id, Model model){
        postServiceApi.delete(id);
        return "redirect:index";
    }


//
}
