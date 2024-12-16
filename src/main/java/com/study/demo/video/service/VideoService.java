package com.study.demo.video.service;

import com.study.demo.video.dto.VideoDto;
import com.study.demo.video.entity.Video;
import com.study.demo.video.repository.VideoRepository;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;

    public List<Video> findVideos(){
        return videoRepository.findAll();
    }

    public Optional<Video> findVideoById(String videoId){
        return videoRepository.findById(videoId);
    }

    public void uploadVideo(VideoDto video){
        Video videoEntity = new Video(video.getTitle(),video.getFileUrl(),video.getThumbUrl(),video.getDescription(),video.getTags(),video.getOwner());
        System.out.println("videoEntity" + videoEntity.toString());
        videoRepository.save(videoEntity);
    }

    public void updateVideo(Video video){
        Optional<Video> videoTmp = videoRepository.findById(video.getVideoId());
        if(videoTmp.isPresent()){
            videoRepository.save(video);
        }
    }

    public void deleteVideo(String videoId){
        videoRepository.deleteById(videoId);
    }

    public List<Video> findVideosByTitle(String title){
        return videoRepository.findByTitle(title);
    }
}
