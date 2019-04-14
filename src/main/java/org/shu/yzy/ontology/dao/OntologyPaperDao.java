package org.shu.yzy.ontology.dao;

import org.shu.yzy.ontology.model.OntologyPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OntologyPaperDao extends JpaRepository<OntologyPaper, Long> {

}
