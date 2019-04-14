package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "obj_element")
@Entity
@Data
public class ObjElement {
    @Id
    Long eventClassId;

    @ManyToOne(targetEntity = Concept.class)
    @JoinColumn(name = "concept_id", referencedColumnName = "id", nullable = true)
    Concept concept;

    @Column
    String number;
}
