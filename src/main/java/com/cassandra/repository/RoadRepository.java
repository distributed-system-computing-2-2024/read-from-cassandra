package com.cassandra.repository;

import com.cassandra.domain.Road;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadRepository extends CassandraRepository<Road, String> {
}
