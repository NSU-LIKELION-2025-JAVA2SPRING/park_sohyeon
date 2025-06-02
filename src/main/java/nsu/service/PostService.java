package nsu.service;

import nsu.domain.Post;
import nsu.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

/* 서비스 = 레포지토리와 도메인을 연결
어떻게 처리할지?
데이터 가공/처리, 예외처리, 도메인 객체 메서드 활용 */

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    // 새 게시글 생성 + 제목 중복 방지 코드 추가
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
        Optional<Post> byId = repository.findById(id);
        if(byId.isEmpty()){
            return byId.get();
        }
        throw new IllegalArgumentException("Exception");
    }

    // 수정하기
    public void updatePost(Long id, String newTitle){
        Optional<Post> byId = repository.findById(id);
        if(byId.isPresent()){
            Post post = byId.get();
            post.updateTitle(newTitle);
            repository.save(post);
        }
    }

    // 삭제하기
    public void deletePost(Long id){
        repository.deleteById(id);
    }

//    // 특정 키워드로 게시글 조회
//    public List<Post> searchPostKeyword(String keyword){
//        return repository.findByKeyword(keyword);
//    }
}
