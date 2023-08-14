package com.elgineer.hackertonelgineer.boards.Controller;

import com.elgineer.hackertonelgineer.boards.Service.CommunityPostService;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class CommunityPostController {

    @Autowired
    private CommunityPostService postService;

    @GetMapping
    public String displayBoard(Model model) {
        List<CommunityPost> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "board";
    }

    @PostMapping
    public String createPost(CommunityPost post) {
        postService.createPost(post);
        return "redirect:/board";
    }

    @GetMapping("/{postId}")
    public String getPostById(@PathVariable Long postId, Model model) {
        CommunityPost post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "redirect:/postDetails";
    }

    @PutMapping("/{postId}")
    public String updatePost(@PathVariable Long postId, CommunityPost updatedPost) {
        updatedPost.setId(postId);
        postService.updatePost(updatedPost);
        return "redirect:/board";
    }

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return "redirect:/board";
    }

    @PostMapping("/{postId}/like")
    public String addLike(@PathVariable Long postId) {
        postService.addLike(postId);
        return "redirect:/board";
    }

    @DeleteMapping("/{postId}/like")
    public String removeLike(@PathVariable Long postId) {
        postService.removeLike(postId);
        return "redirect:/board";
    }
}
