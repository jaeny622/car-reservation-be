package com.study.demo.video.entity;

import com.study.demo.util.BaseTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
// 성능 이슈 발생 가능성 있음
// @DynamicUpdate
@Table(name = "VIDEO")
public class Video extends BaseTime {
    @Id
    @Column(name = "video_id", nullable = false, length = 36)
    @GeneratedValue(strategy=GenerationType.UUID)
    private String videoId;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "file_url", nullable = false, length = 1000)
    private String fileUrl;

    @Column(name = "thumb_url", length = 1000)
    private String thumbUrl;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "hashtags", length = 2000)
    private String hashtags;

    @Column(name = "views", nullable = false)
    private Long views;

    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "owner", nullable = false)
    private String owner;

    public Video(String title, String fileUrl, String thumbUrl, String description, String tags, String owner) {
        this.title = title;
        this.fileUrl = fileUrl;
        this.thumbUrl = thumbUrl;
        this.description = description;
        this.hashtags = tags;
        this.owner = owner;
        this.views = 0L;
    }

    @Override
    public String toString() {
        return getVideoId() + ',' + getTitle()+','+getFileUrl()+','+getThumbUrl()+','+getDescription()+','+getOwner()+','+getHashtags() + ','+getViews();
    }
}