package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ontology_researcher")
public class OntologyResearcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 32)
    String name;

    @Column(columnDefinition = "TEXT")
    String resume;

    @Column
    String picpath;
}
