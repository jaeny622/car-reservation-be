package com.study.demo.video.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VideoDto {
    private String title;
    private String fileUrl;
    private String thumbUrl;
    private String description;
    private String owner;
    private String tags;

    @Override
    public String toString() {
        return getTitle()+','+getFileUrl()+','+getThumbUrl()+','+getDescription()+','+getOwner()+','+getTags();
    }
}
