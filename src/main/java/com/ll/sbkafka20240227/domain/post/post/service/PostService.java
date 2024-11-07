package com.ll.sbkafka20240227.domain.post.post.service;

import com.ll.sbkafka20240227.domain.member.member.entity.Member;
import com.ll.sbkafka20240227.domain.noti.noti.service.NotiService;
import com.ll.sbkafka20240227.domain.post.post.entity.Author;
import com.ll.sbkafka20240227.domain.post.post.entity.Post;
import com.ll.sbkafka20240227.domain.post.post.repository.PostRepository;
import com.ll.sbkafka20240227.global.event.PostCreatedEvent;
import com.ll.sbkafka20240227.global.rsdata.RsData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    @Lazy
    private NotiService notiService;

    @PersistenceContext
    private EntityManager entityManager;
    private final ApplicationEventPublisher publisher;


    @Transactional
    public RsData<Post> write(Author author, String title) {
        author.increasePostCount();

        Post post = postRepository.save(
                Post.builder()
                        .author(author)
                        .title(title)
                        .build()
        );
        publisher.publishEvent(new PostCreatedEvent(this,post));
        return RsData.of(post);
    }


    //Member -> Author
    public Author of(Member member) {
        return entityManager.getReference(Author.class, member.getId());
    }

    //Author -> Member
    public Member of(Author author) {
        return entityManager.getReference(Member.class, author.getId());
    }

}
