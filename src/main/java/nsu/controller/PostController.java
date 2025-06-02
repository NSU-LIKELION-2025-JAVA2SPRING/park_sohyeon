package nsu.controller;

import nsu.domain.Post;
import nsu.service.PostService;

import java.util.List;

// 실제 로직은 service/domian 에서 수행하고 controller는 흐름만 연결

public class PostController {
    private final PostService service = new PostService();

    // 사용자로부터 받은 title를 service에게 전달
    public void createPost(String title){
        service.createPost(title);
    }

    /* 전체 게시글 리스트 가져옴
    실제 데이터는 repository에서 가져옴
     */
    public List<Post> getAllPosts(){
        return service.getAllPosts();
    }

    // 특정 게시글 1개 조회 요청 전달
    public Post getPostById(Long id){
        return service.getPostById(id);
    }

    // 게시글 수정 요청 전달
    public void updatePost(Long id, String newTitle){
        service.updatePost(id, newTitle);
    }

    // 게시글 삭제 요청 전달(서비스에게)
    public void deletePost(Long id){
        service.deletePost(id);
    }

    // 특정 키워드로 검색 요청
    public List<Post> searchPost(String keyword){
        return service.searchPostKeyword(keyword);
    }
}
