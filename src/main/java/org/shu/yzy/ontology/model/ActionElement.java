package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "action_element")
public class ActionElement {
    @Id
    private Long eventClassId;

    @Column
    private String degree;

    @Column
    private String tool;

    @Column
    private String method;
}
