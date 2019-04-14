package org.shu.yzy.ontology.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "concept")
public class Concept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column
    Long parentId;

    @Column
    Integer x;

    /** 非数据表字段，可以通过parent得到，用于构建层次关系 */
    @Transient
    Integer layer;
}
