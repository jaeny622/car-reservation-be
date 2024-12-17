package com.study.demo.video.controller;

import com.study.demo.video.dto.VideoDto;
import com.study.demo.video.entity.Video;
import com.study.demo.video.service.VideoService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/videos")
    public ResponseEntity<List<Video>> getAllVideos(){
        List<Video> videos = videoService.findVideos();

        System.out.println("videos" + videos);

        return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
    }

    @GetMapping("/video/{videoId}")
    public ResponseEntity<Video> getVideo(@PathVariable(value="videoId") String videoId){
        Optional<Video> video = videoService.findVideoById(videoId);
        if(!video.isPresent()) return new ResponseEntity<>(HttpStatus.OK);
        else return new ResponseEntity<Video>(video.get(), HttpStatus.OK);
    }

    @PostMapping("/upload-video")
    public ResponseEntity<Video> uploadVideo(@RequestBody VideoDto video){
        System.out.println("video"+video.toString());
        videoService.uploadVideo(video);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update-video")
    public ResponseEntity<String> updateVideo( @RequestBody Video video){
        System.out.println("video"+video.toString());
        videoService.updateVideo(video);
        return new ResponseEntity<String>("성공",HttpStatus.OK);
    }

    @PostMapping("/video/{videoId}")
    public ResponseEntity<String> deleteVideo(@PathVariable(value = "videoId") String videoId){
        System.out.println("videoId"+videoId);

        videoService.deleteVideo(videoId);
        return new ResponseEntity<String>("성공",HttpStatus.OK);
    }
}
