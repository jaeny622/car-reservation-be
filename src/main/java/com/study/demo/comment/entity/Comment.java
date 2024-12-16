package com.study.demo.comment.entity;

import com.study.demo.user.entity.User;
import com.study.demo.video.entity.Video;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "\"Comment\"")
public class Comment {
    @Id
    @Column(name = "comment_id", nullable = false, length = 36)
    private String commentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "owner", nullable = false)
    private User owner;

    @Column(name = "contents", nullable = false, length = 2000)
    private String contents;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

}