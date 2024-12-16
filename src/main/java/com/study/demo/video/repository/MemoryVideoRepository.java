package com.study.demo.video.repository;

import com.study.demo.video.entity.Video;

import java.util.List;
import java.util.Optional;

public class MemoryVideoRepository{
    VideoRepository videoRepository;

    public List<Video> findVideos(){
        return videoRepository.findAll();
    }

    public Optional<Video> findVideoById(String videoId){
        return videoRepository.findById(videoId);
    }

    public void uploadVideo(Video video){
        videoRepository.save(video);
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
