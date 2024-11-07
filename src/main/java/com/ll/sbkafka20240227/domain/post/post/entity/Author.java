package com.ll.sbkafka20240227.domain.post.post.entity;


import com.ll.sbkafka20240227.global.jpa.entity.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@Getter
@Setter
@Table(name="MEMBER")
public class Author extends BaseTime {
    @Column(name="nickname")
    private String writer;

    @Column(columnDefinition = "BIGINT default 0 ")
    private long postCount;

    public void increasePostCount() {
        postCount++;
    }
}