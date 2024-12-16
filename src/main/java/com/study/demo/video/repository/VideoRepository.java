package com.study.demo.video.repository;

import com.study.demo.video.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// DAO 와 같은 역할
public interface VideoRepository extends JpaRepository<Video, String> {
    List<Video> findByTitle(String title);
}
