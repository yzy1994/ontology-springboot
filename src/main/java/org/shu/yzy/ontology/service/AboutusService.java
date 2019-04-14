package org.shu.yzy.ontology.service;

import org.shu.yzy.ontology.dao.OntologyPaperDao;
import org.shu.yzy.ontology.dao.OntologyResearcherDao;
import org.shu.yzy.ontology.model.OntologyPaper;
import org.shu.yzy.ontology.model.OntologyResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutusService {
    @Autowired
    OntologyPaperDao ontologyPaperDao;

    @Autowired
    OntologyResearcherDao ontologyResearcherDao;

    public List<OntologyPaper> listPaper(){
        return ontologyPaperDao.findAll();
    }

    public List<OntologyResearcher> listResearcher(){
        return ontologyResearcherDao.findAll();
    }
}
