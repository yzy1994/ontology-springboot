package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ec_relation")
public class ECRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rid")
    RelationDef relationDef;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
    EventClass eventClassSource;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id")
    EventClass eventClassTarget;

    @Column(name = "ontology_id")
    Long ontologyId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ontology_id")
//    Ontology ontology;
}
