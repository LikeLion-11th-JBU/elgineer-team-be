package com.elgineer.hackertonelgineer.boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CommunityPostServiceImpl implements CommunityPostService{
    private final CommunityBoardRepository communityBoardRepository;
    private final CommunityPostRepository communityPostRepository;
    private final CommunityPostCommentRepository communityPostCommentRepository;

    @Autowired
    public CommunityPostServiceImpl(CommunityBoardRepository communityBoardRepository,
                                         CommunityPostRepository communityBoardPostRepository,
                                         CommunityPostCommentRepository communityPostCommentRepository) {
        this.communityBoardRepository = communityBoardRepository;
        this.communityPostRepository = communityBoardPostRepository;
        this.communityPostCommentRepository = communityPostCommentRepository;
    }

    // 작성 시간을 현재 시간으로 설정 후, 게시글 생성하고 저장함
    // 카테고리 설정 기능 추가



    @Override
    public CommunityPost createPost(CommunityPost post, String boardName) {
        CommunityBoard board = communityBoardRepository.findByName(boardName);
        if (board == null) {
            throw new IllegalArgumentException("Board not found with name: " + boardName);
        }

        post.setBoard(board); // 게시글 객체에 카테고리 설정
        return communityPostRepository.save(post);
    }




    // 전체 게시글 조회 기능
    @Override
    public List<CommunityPost> getAllPosts() {
        return communityPostRepository.findAll();
    }


    // postId 로 게시글 조회하고, 없으면 null 반환
    @Override
    public CommunityPost getPostById(Long postId) {
        return communityPostRepository.findById(postId).orElse(null);
    }

    // 업데이트 게시글 객체의 정보를 기존 게시글에 복사하여 업데이트 후 저장
    // 제목, 내용, 수정시간 등이 변경되어 저장됨
    @Override
    public CommunityPost updatePost(CommunityPost updatedPost) {
        CommunityPost existingPost = communityPostRepository.findById(updatedPost.getId())
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setUpdatedAt(LocalDateTime.now());

        return communityPostRepository.save(existingPost);
    }

    // postId 로 게시글 삭제
    @Override
    public void deletePost(Long postId) {
        communityPostRepository.deleteById(postId);
    }

    // 특정 게시판에 댓글을 추가하는 기능
    // postId 를 사용하여 게시글을 조회하고, 댓글 생성 후 게시글과 연결함
    @Override
    @Transactional
    // 트랜잭션 기능을 활성화하기 위해 사용되는 어노테이션.
    // 트랜잭션 : 여러 개의 작업을 하나의 논리적인 작업 단위로 묶어서 DB를 처리함
    public CommunityPostComment addComment(Long postId, CommunityPostComment comment) {
        CommunityPost post = communityPostRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found : " + postId));

        comment.setCreatedAt(LocalDateTime.now());
        comment.setCommunityPost(post);

        return communityPostCommentRepository.save(comment);
    }

    // 게시판에 달린 모든 댓글을 조회하여 리스트로 반환
    //
    @Override
    public List<CommunityPostComment> getCommentsForPost(Long postId) {
        return communityPostCommentRepository.findByCommunityPostId(postId);
    }

    // commentId 에 해당하는 댓글을 삭제
    //
    @Override
    public void deleteComment(Long commentId) {
        CommunityPostComment comment = communityPostCommentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        communityPostCommentRepository.delete(comment);
    }

    // 특정 커뮤니티 게시글에 좋아요 추가.
    // postId를 사용하여 해당 게시글 조회 후, 좋아요 카운트 증가하고 저장
    // 게시글마다 사용자는 단 한 번씩만 좋아요가 가능하도록 하기! (해야할 것)
    @Override
    public CommunityPost addLike(Long postId) {
        CommunityPost post = communityPostRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        post.setLikeCount(post.getLikeCount() + 1);

        return communityPostRepository.save(post);
    }

    // postId를 사용하여 특정 커뮤니티 게시글의 좋아요 카운트 감소시키고 저장
    // 
    @Override
    public CommunityPost removeLike(Long postId) {
        CommunityPost post = communityPostRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        if (post.getLikeCount() > 0) {
            post.setLikeCount(post.getLikeCount() - 1);
        }

        return communityPostRepository.save(post);
    }
}
