package com.study.demo.video.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class VideoDto {
    private String title;
    private String fileUrl;
    private String thumbUrl;
    private String description;
    private String owner;
    private String tags;

    @Builder
    public VideoDto(String title, String fileUrl, String thumbUrl, String description, String owner, String tags) {
        this.title = title;
        this.fileUrl = fileUrl;
        this.thumbUrl = thumbUrl;
        this.description = description;
        this.owner = owner;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return getTitle()+','+getFileUrl()+','+getThumbUrl()+','+getDescription()+','+getOwner()+','+getTags();
    }
}
