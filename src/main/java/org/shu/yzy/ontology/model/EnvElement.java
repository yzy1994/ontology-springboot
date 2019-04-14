package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "env_element")
public class EnvElement {
    @Id
    Long eventClassId;

    @ManyToOne(targetEntity = Concept.class)
    @JoinColumn(name = "concept_id", referencedColumnName = "id", nullable = true)
    Concept concept;
}
