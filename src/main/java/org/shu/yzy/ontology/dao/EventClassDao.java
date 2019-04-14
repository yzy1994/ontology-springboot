package org.shu.yzy.ontology.dao;

import org.shu.yzy.ontology.model.EventClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventClassDao extends JpaRepository<EventClass, Long> {
    List<EventClass> findEventClassesByOid(Long ontologyId);

    List<EventClass> findEventClassesByOidOrderById(Long ontologyId);

    EventClass getByIdAndOid(Long eventId, Long ontologyId);
}
