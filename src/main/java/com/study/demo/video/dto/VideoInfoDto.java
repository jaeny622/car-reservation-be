package com.study.demo.video.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VideoInfoDto {
    private String id;
    private String title;
    private String fileUrl;
    private String thumbUrl;
    private String description;
    private String owner;
    private String tags;
    private String updatedAt;

    @Override
    public String toString() {
        return getId() + ',' + getTitle() + ',' + getFileUrl() + ',' + getThumbUrl() + ',' + getDescription() + ',' + getOwner() + ',' + getTags() + ',' + getUpdatedAt();
    }
}
