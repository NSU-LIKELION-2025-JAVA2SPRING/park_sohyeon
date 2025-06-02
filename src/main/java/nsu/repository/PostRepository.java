package nsu.repository;

import nsu.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

/* Post 객체를 저장,찾기,삭제*/

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    List<Post> findAllBytitle(String title);
}


