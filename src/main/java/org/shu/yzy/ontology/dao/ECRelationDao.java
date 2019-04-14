package org.shu.yzy.ontology.dao;

import org.shu.yzy.ontology.model.ECRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ECRelationDao extends JpaRepository<ECRelation, Long> {
    List<ECRelation> findECRelationsByOntologyId(Long OntologyId);
}
