package org.shu.yzy.ontology.dao;

import org.shu.yzy.ontology.model.OntologyResearcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OntologyResearcherDao extends JpaRepository<OntologyResearcher, Long> {

}
