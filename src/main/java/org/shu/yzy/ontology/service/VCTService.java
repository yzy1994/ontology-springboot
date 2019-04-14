package org.shu.yzy.ontology.service;

import org.shu.yzy.ontology.dao.ConceptDao;
import org.shu.yzy.ontology.dao.ECRelationDao;
import org.shu.yzy.ontology.dao.ECRelationDefDao;
import org.shu.yzy.ontology.dao.EventClassDao;
import org.shu.yzy.ontology.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VCTService {
    @Autowired
    EventClassDao eventClassDao;

    @Autowired
    ConceptDao conceptDao;

    @Autowired
    ECRelationDao ecRelationDao;

    @Autowired
    ECRelationDefDao ecRelationDefDao;

    public List<EventClass> listEventClassByOntologyId(Long ontologyId) {
        List<EventClass> eventClassList = eventClassDao.findEventClassesByOidOrderById(ontologyId);
        addLayer(eventClassList);
        return eventClassList;
    }

    private void addLayer(List<EventClass> eventClassList) {
        int todo = eventClassList.size();
        Map<Long, Integer> layerMap = new HashMap();
        while (todo > 0) {
            for (EventClass eventClass : eventClassList) {
                if (eventClass.getLayer() == null) {
                    if (eventClass.getParentId() == 0) {
                        eventClass.setLayer(0);
                        layerMap.put(eventClass.getId(), 0);
                        todo--;
                    } else {
                        if (layerMap.containsKey(eventClass.getParentId())) {
                            Integer layer = layerMap.get(eventClass.getParentId()) + 1;
                            eventClass.setLayer(layer);
                            layerMap.put(eventClass.getId(), layer);
                            todo--;
                        }
                    }
                }
            }
        }
    }

    public List<Concept> listConcept() {
        List<Concept> conceptList =  conceptDao.findAll();
        addLayerForConcept(conceptList);
        return conceptList;
    }

    private void addLayerForConcept(List<Concept> conceptList) {
        int todo = conceptList.size();
        Map<Long, Integer> layerMap = new HashMap();
        while (todo > 0) {
            for (Concept concept : conceptList) {
                if (concept.getLayer() == null) {
                    if (concept.getParentId() == 0) {
                        concept.setLayer(0);
                        layerMap.put(concept.getId(), 0);
                        todo--;
                    } else {
                        if (layerMap.containsKey(concept.getParentId())) {
                            Integer layer = layerMap.get(concept.getParentId()) + 1;
                            concept.setLayer(layer);
                            layerMap.put(concept.getId(), layer);
                            todo--;
                        }
                    }
                }
            }
        }
    }

    public EventClass getEventClassDetail(Long ontologyId, Long eventId) {
        EventClass eventClass = eventClassDao.getByIdAndOid(eventId, ontologyId);
        return eventClass;
    }

    public int deleteEventClass(Long ontologyId, Long eventId) {
        eventClassDao.deleteById(eventId);
        return 0;
    }

    public EventClass postEventClass(EventClass eventClass) {
        System.out.println(eventClass);
        EventClass result = eventClassDao.save(eventClass);
        return result;
    }

    public int putEventClass(EventClass eventClass) {
        System.out.println(eventClass);
        EventClass result = eventClassDao.save(eventClass);
        if (result != null) {
            return 1;
        } else {
            return 0;
        }
    }

    public EchartsData getEchartsDataByOntologyId(Long ontologyId){
        EchartsData echartsData = new EchartsData();
        List<ECRelation> ecRelationList= ecRelationDao.findECRelationsByOntologyId(ontologyId);
        List<RelationDef> relationDefList = ecRelationDefDao.findAll();

        List<EchartsNode> echartsNodeList = new ArrayList<>();
        for(ECRelation ecRelation: ecRelationList) {
            EchartsNode echartsNode = new EchartsNode(ecRelation.getEventClassSource().getName());
            if(!echartsNodeList.contains(echartsNode)){
                echartsNodeList.add(echartsNode);
            }
            echartsNode = new EchartsNode(ecRelation.getEventClassTarget().getName());
            if(!echartsNodeList.contains(echartsNode)){
                echartsNodeList.add(echartsNode);
            }
        }

        List<EchartsLink> echartsLinkList = new ArrayList<>();
        for(ECRelation ecRelation: ecRelationList) {

        }

        echartsData.setEchartsNodeList(echartsNodeList);
        return echartsData;
    }

    public ECRelation postECRelation(ECRelation ecRelation){
        return ecRelationDao.save(ecRelation);
    }

    public Concept postConcept(Concept concept){
        return conceptDao.save(concept);
    }
}
