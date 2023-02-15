package dev.stormgui.simpleblog.controller;

import dev.stormgui.simpleblog.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

    private final PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String blog(Model model) {
        model.addAttribute("title", "My Awesome Blog");
        model.addAttribute("author", "stormgui");
        model.addAttribute("posts", postService.getPosts());
        model.addAttribute("albums", postService.getAlbums());

        return "index";
    }
}
