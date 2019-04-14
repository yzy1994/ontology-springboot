package org.shu.yzy.ontology.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shu.yzy.ontology.model.Ontology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OntologyServiceTest {
    @Autowired
    OntologyService ontologyService;

    @Test
    public void listExistedOntology() {
        List<Ontology> ontologyList = ontologyService.listExistedOntology();
        for(Ontology ontology: ontologyList) {
            System.out.println(ontology);
        }
    }
}