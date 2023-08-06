package com.elgineer.hackertonelgineer.boards;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
// 일단 '게시판' 생성, 삭제 기능은 넣지 않음 (수정이 필요해 보여서)
public class CommunityBoardController {
    private final CommunityBoardService communityBoardService;
    private final CommunityPostService communityPostService;

    public CommunityBoardController(CommunityBoardService communityBoardService,
                                    CommunityPostService communityPostService) {
        this.communityBoardService = communityBoardService;
        this.communityPostService = communityPostService;
    }

    @GetMapping("/board")
    public String showBoard(Model model) {
        List<CommunityBoard> categories = communityBoardService.getAllCommunityBoards();
        List<CommunityPost> posts = communityPostService.getAllPosts();

        model.addAttribute("categories", categories);
        model.addAttribute("posts", posts);
        model.addAttribute("newPost", new CommunityPost());
        // 빈 객체를 생성해서 전달

        return "board"; // board.html과 매핑
    }

    // 게시글을 생성할 때, 클라이언트가 선택한 카테고리 이름을 받아와서
    // 해당 카테고리를 찾아 사용함
    @PostMapping
    public ResponseEntity<CommunityPost> createPost(@RequestBody CommunityPost post,
                                                    // 선택하지 않으면 자유게시판이 되므로 false로 따로 옵션을 줌
                                                    @RequestParam(required = false) String categoryName) {
        CommunityPost createdPost = communityPostService.createPost(post, categoryName);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @GetMapping("getall")
    public ResponseEntity<List<CommunityPost>> getAllPosts() {
        List<CommunityPost> posts = communityPostService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<CommunityPost> getPostById(@PathVariable Long postId) {
        CommunityPost post = communityPostService.getPostById(postId);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<CommunityPost> updatePost(@PathVariable Long postId, @RequestBody CommunityPost updatedPost) {
        updatedPost.setId(postId);
        CommunityPost post = communityPostService.updatePost(updatedPost);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        communityPostService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommunityBoardComment> addComment(@PathVariable Long postId, @RequestBody CommunityBoardComment comment) {
        CommunityBoardComment addedComment = communityPostService.addComment(postId, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedComment);
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<CommunityBoardComment>> getCommentsForPost(@PathVariable Long postId) {
        List<CommunityBoardComment> comments = communityPostService.getCommentsForPost(postId);
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        communityPostService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<CommunityPost> addLike(@PathVariable Long postId) {
        CommunityPost post = communityPostService.addLike(postId);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{postId}/like")
    public ResponseEntity<CommunityPost> removeLike(@PathVariable Long postId) {
        CommunityPost post = communityPostService.removeLike(postId);
        return ResponseEntity.ok(post);
    }


}
