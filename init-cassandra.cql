-- init-cassandra.cql
CREATE KEYSPACE IF NOT EXISTS dsc2024 WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE dsc2024;

CREATE TABLE IF NOT EXISTS road (
    road_id text primary key,
    road_name text,
    congestion_level text,
    std_date text,
    std_hour text
);
