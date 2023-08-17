package com.elgineer.hackertonelgineer.boards.Controller;

import com.elgineer.hackertonelgineer.boards.Service.CommunityPostService;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPost;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPostComment;
import com.elgineer.hackertonelgineer.boards.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping("/board")
public class CommunityPostController {


    private static final Logger logger = LoggerFactory.getLogger(CommunityPostController.class);

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
    public String createPost(@RequestBody CommunityPost post) {
        post.setCategory(CommunityPost.Category.valueOf(post.getCategory().toString().toUpperCase()));

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
        List<CommunityPostComment> comments = postService.getCommentsForPost(postId);

        // 세션에서 User 객체를 가져오기
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        // 로그인된 사용자의 닉네임을 초기화
        String loggedInUserNickname = null;

        // loggedInUser가 null이 아닌 경우에만 닉네임을 가져오기
        if(loggedInUser != null) {
            loggedInUserNickname = loggedInUser.getNickname();
        }

        model.addAttribute("post", post);
        model.addAttribute("loggedInUserNickname", loggedInUserNickname);
        model.addAttribute("comments", comments);

        return "postDetails";
    }



    @PutMapping("/update/{postId}")
    public String updatePost(@PathVariable Long postId,
                             @RequestBody CommunityPost updatedPost) {
        CommunityPost existingPost = postService.getPostById(postId);
        if (existingPost == null) {
            return "board";
        }
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());

        postService.updatePost(existingPost);

        return "redirect:/board/" + postId;
    }

    @GetMapping("/update/{postId}") // 게시글 업데이트 url변경
    public String showUpdatePost(@PathVariable Long postId, Model model) {
        CommunityPost post = postService.getPostById(postId);
        if (post == null) {
            return "error";
        }
        model.addAttribute("post", post);
        return "postUpdate";
    }

    @DeleteMapping("/{postId}/delete")
    public String deletePost(@PathVariable Long postId, Model model) {
        try {
            postService.deletePost(postId);
        } catch (Exception e) {
            logger.error("Error deleting post with ID: " + postId, e);
            model.addAttribute("errorMessage", "Error deleting post with ID: " + postId);
        }
        return "redirect:/board";
    }

    @GetMapping("/isAuthenticated")
    @ResponseBody
    public boolean isAuthenticated() {
        return session.getAttribute("loggedInUser") != null;
    }


}
