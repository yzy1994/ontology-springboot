package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "assertion_element")
public class AssertionElement {
    @Id
    Long eventClassId;

    @Column
    String preState;

    @Column
    String proState;

    @Column
    String postState;
}
