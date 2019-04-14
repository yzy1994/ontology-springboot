package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ontology_paper")
public class OntologyPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "TEXT")
    String paperName;

    @Column
    String path;
}
