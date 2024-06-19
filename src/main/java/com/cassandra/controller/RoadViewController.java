package com.cassandra.controller;

import com.cassandra.domain.Road;
import com.cassandra.service.RoadCongestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class RoadViewController {

    private final RoadCongestionService roadCongestionService;

    @Autowired
    public RoadViewController(RoadCongestionService roadCongestionService) {
        this.roadCongestionService = roadCongestionService;
    }

    @GetMapping
    public String showSearchPage() {
        return "trafficMap";
    }

    @GetMapping("/roads")
    @ResponseBody
    public List<Road> getRoadsByName(@RequestParam("name") String name) {
        log.info("검색 도로명: {}", name);
        if (name.equals("all")) {
            return roadCongestionService.getAllCongestionLevel();
        } else {
            return roadCongestionService.getRoadsByRoadName(name);
        }
    }
}
