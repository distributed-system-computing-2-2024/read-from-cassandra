package com.cassandra.controller;

import com.cassandra.service.RoadCongestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/search")
public class RoadViewController {

    private RoadCongestionService roadCongestionService;

    @Autowired
    public RoadViewController(RoadCongestionService roadCongestionService) {
        this.roadCongestionService = roadCongestionService;
    }

    @GetMapping
    public String getCongestionLevel(@RequestParam String roadName) {
        Optional<String> roadCongestion = roadCongestionService.getCongestionLevelByRoadName(roadName);
        return roadCongestion.orElse(null);  // 도로명이 없을 경우 null 반환
    }
}
