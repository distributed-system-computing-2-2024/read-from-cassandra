package com.cassandra.domain;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@Table("road")
public class Road {
    @PrimaryKey
    @Column("road_id")
    private String road_id;

    @Column("road_name")
    private String road_name;

    @Column("congestion_level")
    private String congestion_level;

    @Column("std_date")
    private String std_date;

    @Column("std_hour")
    private String std_hour;
}
