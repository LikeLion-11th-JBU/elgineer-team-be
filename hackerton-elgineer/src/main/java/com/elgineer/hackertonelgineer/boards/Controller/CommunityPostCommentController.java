package com.elgineer.hackertonelgineer.boards.Controller;

import com.elgineer.hackertonelgineer.boards.Service.CommunityPostCommentService;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPostComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments")
public class CommunityPostCommentController {

    static class UpdateCommentRequest {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    @Autowired
    private CommunityPostCommentService communityPostCommentService;

    @PostMapping("/{postId}")
    public String createComment(@ModelAttribute CommunityPostComment comment, @PathVariable Long postId, Model model) {
        CommunityPostComment savedComment = communityPostCommentService.createComment(comment, postId);
        model.addAttribute("comment", savedComment);
        return "redirect:/postDetails";
    }

    @GetMapping("/{commentId}")
    public String getCommentById(@PathVariable Long commentId, Model model) {
        CommunityPostComment comment = communityPostCommentService.getCommentById(commentId);
        model.addAttribute("comment", comment);
        return "redirect:/postDetails";
    }

    @PutMapping("/{commentId}")
    public String updateComment(@PathVariable Long commentId, @ModelAttribute UpdateCommentRequest content, Model model) {
        CommunityPostComment updatedComment = communityPostCommentService.updateComment(commentId, content.getContent());
        model.addAttribute("comment", updatedComment);
        return "redirect:/postDetails";
    }

    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        communityPostCommentService.deleteComment(commentId);
        return "redirect:/postDetails";
    }
}
