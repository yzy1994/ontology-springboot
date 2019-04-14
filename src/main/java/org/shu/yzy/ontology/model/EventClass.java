package org.shu.yzy.ontology.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "event_class")
public class EventClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    Long oid;

    @Column
    String name;

    @Column
    Long parentId;

    @Column
    Integer x;

    /** 非数据表字段，可以通过parent得到，用于构建层次关系 */
    @Transient
    Integer layer;

    @OneToOne(targetEntity = ActionElement.class)
    @JoinColumn(name = "id", referencedColumnName = "eventClassId", nullable = true)
    ActionElement actionElement;

    @OneToOne(targetEntity = AssertionElement.class)
    @JoinColumn(name = "id", referencedColumnName = "eventClassId", nullable = true)
    AssertionElement assertionElement;

    @OneToOne(targetEntity = LanExpElement.class)
    @JoinColumn(name = "id", referencedColumnName = "eventClassId", nullable = true)
    LanExpElement lanExpElement;

    @OneToOne(targetEntity = TimeElement.class)
    @JoinColumn(name = "id", referencedColumnName = "eventClassId", nullable = true)
    TimeElement timeElement;

    @OneToOne(targetEntity = EnvElement.class)
    @JoinColumn(name = "id", referencedColumnName = "eventClassId", nullable = true)
    EnvElement envElement;

//    @OneToMany(targetEntity = ObjElement.class)
//    @JoinColumn(name = "id", referencedColumnName = "eventClassId", nullable = true)
//    List<ObjElement> objElementList;
}
