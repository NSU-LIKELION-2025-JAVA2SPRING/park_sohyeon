package nsu.repository;

import nsu.domain.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Post 객체를 저장,찾기,삭제*/

public class PostRepository {
    // 메모리 저장 ID, 게시글
    private final Map<Long, Post> storage = new HashMap<>();

    // Map에 Post 저장
    public Post save(Post post) {
        storage.put(post.getId(), post);
        return post;
    }

    // 저장된 모든 게시글 리스트로 반환하기
    public List<Post> findAll(){
        return new ArrayList<>(storage.values());
    }

    // id로 게시글 찾아 반환
    public Post findById(Long id){
        return storage.get(id);
    }

    // id로 게시글 삭제
    public void delete(Long id){
        storage.remove(id);
    }

    // 추가과제 1. 중복된 제목의 게시글 작성 금지
    public boolean existTitle(String title){
        for (Post post : storage.values()){ // Map에 저장된 모든 post 객체들을 꺼내 제목 출력
            if(post.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }
}


