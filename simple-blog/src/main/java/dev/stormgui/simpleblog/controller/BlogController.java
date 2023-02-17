package dev.stormgui.simpleblog.controller;

import dev.stormgui.simpleblog.service.BlogService;
import dev.stormgui.simpleblog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private final PostService postService;
    private final BlogService blogService;

    public BlogController(PostService postService, BlogService blogService) {
        this.postService = postService;
        this.blogService = blogService;
    }

    @GetMapping
    public String blog(Model model) {
        model.addAttribute("title", "My Awesome Blog");
        model.addAttribute("author", "stormgui");
        model.addAttribute("posts", blogService.getPosts());

        return "index";
    }
}
