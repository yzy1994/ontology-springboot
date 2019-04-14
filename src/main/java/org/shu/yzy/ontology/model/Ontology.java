package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ontology_info")
public class Ontology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String field;

    public Ontology(){}
}
