package com.cassandra.domain;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("road")
public class Road {
    @PrimaryKey
    @Column("road_name")
    private String roadName;

    @Column("congestion_level")
    private String congestionLevel;
}
