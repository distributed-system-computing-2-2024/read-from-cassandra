package com.cassandra.repository;

import com.cassandra.domain.Road;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoadRepository extends CassandraRepository<Road, String> {
    @Query("SELECT * FROM road WHERE road_name = ?0")
    Optional<Road> findByRoadName(String name);
}
