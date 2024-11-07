package com.ll.sbkafka20240227.domain.post.author.repository;

import com.ll.sbkafka20240227.domain.post.post.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
