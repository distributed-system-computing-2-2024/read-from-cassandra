package com.cassandra.service;

import com.cassandra.domain.Road;
import com.cassandra.repository.RoadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class RoadCongestionService {

    private final RoadRepository roadRepository;
    private List<Road> roadList;
    private int updatedRows;

    @Autowired
    public RoadCongestionService(RoadRepository roadRepository) {
        this.roadRepository = roadRepository;
        updatedRows = 0;
        fetchTrafficData();
        setFindTrue();
    }

    @Scheduled(cron = "0-10 0/5 * * * *")
    public void fetchTrafficData() {
        roadList = roadRepository.findAll();
        AtomicInteger count = new AtomicInteger();
        LocalTime now = LocalTime.now(ZoneId.of("Asia/Seoul"));
        roadList.forEach(road -> {
            if (now.getHour() - Integer.parseInt(road.getStd_hour()) / 100 == 1) {
                if ((now.getHour() * 100 + now.getMinute() - 40) - Integer.parseInt(road.getStd_hour()) < 5)
                    count.addAndGet(1);
            } else {
                if ((now.getHour() * 100 + now.getMinute()) - Integer.parseInt(road.getStd_hour()) < 5)
                    count.addAndGet(1);
            }
            switch (road.getCongestion_level()) {
                case "high":
                    road.setCongestion_level("혼잡");
                    break;
                case "middle":
                    road.setCongestion_level("서행");
                    break;
                case "low":
                    road.setCongestion_level("원활");
                    break;
            }
        });
        if (count.intValue() > updatedRows) {
            printTrafficData();
            log.info("\n종료 시간: {}, updated rows: {}", LocalTime.now(ZoneId.of("Asia/Seoul")), count);
            updatedRows = count.intValue();
        }
    }

    public void printTrafficData() {
        roadList.forEach(road -> {
            log.info("\nVDS ID: {}, 도로명: {}, 혼잡도: {}, Date: {}, Time: {}",
                    road.getRoad_id(), road.getRoad_name(), road.getCongestion_level(), road.getStd_date(), road.getStd_hour());
        });
    }

    @Scheduled(cron = "0 1/5 * * * *")
    public void setFindTrue() {
        updatedRows = 0;
    }

    public List<Road> getAllCongestionLevel() {
        return roadList;
    }

    public List<Road> getRoadsByRoadName(String roadName) {
        List<Road> findRoads = new ArrayList<>();
        roadList.forEach(road -> {
            if (road.getRoad_name().contains(roadName)) {
                findRoads.add(road);
            }
        });
        return findRoads;
    }
}
