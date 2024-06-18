package com.cassandra.controller;

import com.cassandra.domain.Road;
import com.cassandra.service.RoadCongestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class RoadViewController {

    private final RoadCongestionService roadCongestionService;

    @Value("${google.maps.api.key}")
    private String apiKey;

    @Autowired
    public RoadViewController(RoadCongestionService roadCongestionService) {
        this.roadCongestionService = roadCongestionService;
    }

    @GetMapping
    public String getAllCongestionLevel(Model model) {
        log.info("Client called");
        List<Road> roads = roadCongestionService.getAllCongestionLevel();
        model.addAttribute("roads", roads);
        model.addAttribute("apiKey", apiKey);
        return "trafficMap";
    }
}
