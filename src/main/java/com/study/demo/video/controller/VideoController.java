package com.study.demo.video.controller;

import com.study.demo.video.dto.VideoDto;
import com.study.demo.video.entity.Video;
import com.study.demo.video.service.VideoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/videos")
    public ResponseEntity<List<Video>> getAllVideos(){
        System.out.println("videoService"+videoService);
        List<Video> videos = videoService.findVideos();

        System.out.println("videos" + videos);

        return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
    }

    @PostMapping("/upload-video")
    public ResponseEntity<Video> uploadVideo(@RequestBody VideoDto video){
        System.out.println("video"+video.toString());
        videoService.uploadVideo(video);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
