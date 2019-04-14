package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "time_element")
public class TimeElement {
    @Id
    Long EventClassId;

    @Column
    String startTime;

    @Column
    String duration;
}
