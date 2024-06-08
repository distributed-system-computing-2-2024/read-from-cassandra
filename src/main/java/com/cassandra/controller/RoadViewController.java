package com.cassandra.controller;

import com.cassandra.domain.Road;
import com.cassandra.service.RoadCongestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/roadview")
public class RoadViewController {

    private final RoadCongestionService roadCongestionService;

    @Autowired
    public RoadViewController(RoadCongestionService roadCongestionService) {
        this.roadCongestionService = roadCongestionService;
    }

    @GetMapping
    public List<Road> getAllCongestionLevel() {
        return roadCongestionService.getAllCongestionLevel();
    }
}
