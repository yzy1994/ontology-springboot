package org.shu.yzy.ontology.dao;

import org.shu.yzy.ontology.model.Concept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptDao extends JpaRepository<Concept, Long> {

}
