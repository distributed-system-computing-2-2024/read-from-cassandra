package com.cassandra.service;

import com.cassandra.domain.Road;
import com.cassandra.repository.RoadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class RoadCongestionService {

    private RoadRepository roadRepository;

    @Autowired
    public RoadCongestionService(RoadRepository roadRepository) {
        this.roadRepository = roadRepository;
    }

    public Optional<String> getCongestionLevelByRoadName(String roadName) {
        log.info("Requested roadname = {}", roadName);
        return roadRepository.findByRoadName(roadName)
                .map(Road::getCongestionLevel);
    }
}
