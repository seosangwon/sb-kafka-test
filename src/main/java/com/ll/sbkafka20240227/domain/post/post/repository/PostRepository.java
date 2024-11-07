package com.ll.sbkafka20240227.domain.post.post.repository;

import com.ll.sbkafka20240227.domain.post.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
