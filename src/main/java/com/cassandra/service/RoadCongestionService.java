package com.cassandra.service;

import com.cassandra.domain.Road;
import com.cassandra.repository.RoadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoadCongestionService {

    private final RoadRepository roadRepository;
    private List<Road> roadList;

    @Autowired
    public RoadCongestionService(RoadRepository roadRepository) {
        this.roadRepository = roadRepository;
        fetchTrafficData();
    }

    @Scheduled(cron = "0 1/5 * * * *")
    public void fetchTrafficData() {
        roadList = roadRepository.findAll();
        roadList.forEach(info -> {
            log.info("VDS ID: {}, 도로명: {}, 혼잡도: {}, Date: {}, Time: {}",
                    info.getRoad_id(), info.getRoad_name(), info.getCongestion_level(), info.getStd_date(), info.getStd_hour());
        });
    }

    public List<Road> getAllCongestionLevel() {
        return roadList;
    }
}
