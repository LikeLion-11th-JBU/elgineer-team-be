package com.elgineer.hackertonelgineer.boards.Controller;

import com.elgineer.hackertonelgineer.boards.Service.CommunityPostService;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPost;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPostComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class CommunityPostController {

    @Autowired
    private CommunityPostService postService;

    @PostMapping
    public ResponseEntity<CommunityPost> createPost(@RequestBody CommunityPost post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @GetMapping
    public ResponseEntity<List<CommunityPost>> getAllPosts() {
        List<CommunityPost> posts = postService.getAllPosts();
        if (posts == null || posts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(posts);
//        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<CommunityPost> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<CommunityPost> updatePost(@PathVariable Long postId, @RequestBody CommunityPost updatedPost) {
        updatedPost.setId(postId);
        return ResponseEntity.ok(postService.updatePost(updatedPost));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommunityPostComment> addCommentToPost(@PathVariable Long postId, @RequestBody CommunityPostComment comment) {
        return ResponseEntity.ok(postService.addComment(postId, comment));
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<CommunityPostComment>> getCommentsForPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getCommentsForPost(postId));
    }
}
