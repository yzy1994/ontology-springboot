package org.shu.yzy.ontology.bean;

import lombok.Data;
import org.shu.yzy.ontology.model.Ontology;

import java.util.List;

@Data
public class OntoEditVO {
    private String role;

    private List<Ontology> ontologyList;

    public OntoEditVO(){

    }

    public OntoEditVO(String role, List<Ontology> ontologyList) {
        this.role = role;
        this.ontologyList = ontologyList;
    }
}
