package com.elgineer.hackertonelgineer.boards.Controller;

import com.elgineer.hackertonelgineer.boards.Service.CommunityPostCommentService;
import com.elgineer.hackertonelgineer.boards.Service.CommunityPostService;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPostComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
    public ResponseEntity<CommunityPostComment> createComment(@RequestBody CommunityPostComment comment, @PathVariable Long postId) {
        return ResponseEntity.ok(communityPostCommentService.createComment(comment, postId));
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommunityPostComment> getCommentById(@PathVariable Long commentId) {
        return ResponseEntity.ok(communityPostCommentService.getCommentById(commentId));
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommunityPostComment> updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest content) {
        CommunityPostComment updatedComment = communityPostCommentService.updateComment(commentId, content.getContent());
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        communityPostCommentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }
}
