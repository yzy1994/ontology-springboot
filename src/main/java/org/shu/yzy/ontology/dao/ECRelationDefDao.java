package org.shu.yzy.ontology.dao;

import org.shu.yzy.ontology.model.RelationDef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ECRelationDefDao extends JpaRepository<RelationDef, Long> {
}
