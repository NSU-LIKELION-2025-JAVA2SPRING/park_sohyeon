package nsu.controller;

import nsu.domain.Post;
import nsu.service.PostService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 실제 로직은 service/domian 에서 수행하고 controller는 흐름만 연결

@RestController
public class PostController {

    public PostController(PostService service) {
        this.service = service;
    }

    private final PostService service;

    @PostMapping("/posts")
    // 사용자로부터 받은 title를 service에게 전달
    public ResponseEntity<Void> createPost(@RequestBody String title){
        service.createPost(title);

        return ResponseEntity.ok().build();
    }

    /* 전체 게시글 리스트 가져옴
    실제 데이터는 repository에서 가져옴
     */

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(){
        return ResponseEntity.ok(service.getAllPosts());
    }

    @GetMapping("/posts/{id}")
    // 특정 게시글 1개 조회 요청 전달
    public ResponseEntity<String> getPostById(@PathVariable Long id){

        return ResponseEntity.ok(id.toString());
//        return ResponseEntity.ok(service.getPostById(id));
    }

    @PutMapping("/posts/{id}")
    // 게시글 수정 요청 전달
    public ResponseEntity<Void> updatePost(@PathVariable Long id,@RequestBody String newTitle){
        service.updatePost(id, newTitle);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/posts/{id}")
    // 게시글 삭제 요청 전달(서비스에게)
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        service.deletePost(id);

        return ResponseEntity.ok().build();
    }

//    // 특정 키워드로 검색 요청
//    public List<Post> searchPost(String keyword){
//        return service.searchPostKeyword(keyword);
//    }
}
