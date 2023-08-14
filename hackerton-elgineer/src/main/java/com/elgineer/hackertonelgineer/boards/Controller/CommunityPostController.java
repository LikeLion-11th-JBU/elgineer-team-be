package com.elgineer.hackertonelgineer.boards.Controller;

import com.elgineer.hackertonelgineer.boards.Service.CommunityPostService;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class CommunityPostController {

    @Autowired
    private CommunityPostService postService;

    @Autowired
    private HttpSession session;

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

    @GetMapping("/create")
    public String createPostPage(Model model) {
        boolean loggedIn = session.getAttribute("loggedInUser") != null;
        model.addAttribute("loggedIn", loggedIn);
        return "postCreate";
    }

    @GetMapping("/{postId}")
    public String getPostById(@PathVariable Long postId, Model model) {
        CommunityPost post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "postDetails";
    }

    @PutMapping("/{postId}")
    public String updatePost(@PathVariable Long postId, CommunityPost updatedPost) {
        CommunityPost existingPost = postService.getPostById(postId);
        if (existingPost == null) {
            return "redirect:/board";
        }
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());

        postService.updatePost(existingPost);

        return "redirect:/board/" + postId;
    }


    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return "redirect:/board";
    }

    @PostMapping("/{postId}/like")
    public String addLike(@PathVariable Long postId) {
        postService.addLike(postId);
        return "redirect:/postDetails";
    }

    @DeleteMapping("/{postId}/like")
    public String removeLike(@PathVariable Long postId) {
        postService.removeLike(postId);
        return "redirect:/postDetails";
    }

    @GetMapping("/isAuthenticated")
    @ResponseBody
    public boolean isAuthenticated() {
        return session.getAttribute("loggedInUser") != null;
    }

}
