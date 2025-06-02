package nsu.service;

import nsu.domain.Post;
import nsu.repository.PostRepository;

import java.awt.*;
import java.util.List;

/* 서비스 = 레포지토리와 도메인을 연결
어떻게 처리할지?
데이터 가공/처리, 예외처리, 도메인 객체 메서드 활용 */

public class PostService {
    private final PostRepository repository = new PostRepository();

    // 새 게시글 생성
    public Post createPost(String title){
        Post post = new Post(title);
        return repository.save(post); // 저장 후 반환
    }

    // 저장된 전체 게시글 가져오기
    public List<Post> getAllPosts(){
        return repository.findAll();
    }

    // id로 게시글 조회
    public Post getPostById(Long id){
        return repository.findById(id);
    }

    // 수정하기
    public void updatePost(Long id, String newTitle){
        Post post = repository.findById(id);
        if(post != null){
            post.updateTitle(newTitle);
        }
    }

    // 삭제하기
    public void deletePost(Long id){
        repository.delete(id);
    }
}
