package org.shu.yzy.ontology.service;

import org.shu.yzy.ontology.dao.OntologyDao;
import org.shu.yzy.ontology.model.Ontology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OntologyService {
    @Autowired
    OntologyDao ontologyDao;

    public List<Ontology> listExistedOntology(){
        return ontologyDao.findAll();
    }

    public Ontology saveOntology(Ontology ontology){
        return ontologyDao.save(ontology);
    }

    public void deleteOntology(Long ontologyId){
        ontologyDao.deleteById(ontologyId);
    }
}
