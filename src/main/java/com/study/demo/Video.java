package com.study.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "\"Video\"")
public class Video {
    @Id
    @Column(name = "video_id", nullable = false, length = 36)
    private String videoId;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "file_url", nullable = false, length = 1000)
    private String fileUrl;

    @Column(name = "thumb_url", length = 1000)
    private String thumbUrl;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @Column(name = "hashtags", length = 2000)
    private String hashtags;

    @Column(name = "\"views\"", nullable = false)
    private Long views;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "owner", nullable = false)
    private User owner;

}