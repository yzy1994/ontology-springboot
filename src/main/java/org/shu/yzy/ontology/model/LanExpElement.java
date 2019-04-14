package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "lan_exp_element")
public class LanExpElement {
    @Id
    Long eventClassId;

    @Column
    String triggers;

    @Column
    String collocation;
}
