package org.shu.yzy.ontology.controller;

import org.shu.yzy.ontology.bean.Result;
import org.shu.yzy.ontology.enums.ResultEnum;
import org.shu.yzy.ontology.model.Concept;
import org.shu.yzy.ontology.model.ECRelation;
import org.shu.yzy.ontology.model.EventClass;
import org.shu.yzy.ontology.service.VCTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**VCT 可视化构建工具*/
@RestController
@RequestMapping("/api/ontology")
public class VCTController {
    Logger logger = LoggerFactory.getLogger(VCTController.class);

    @Autowired
    VCTService vctService;

    /**
     * 查询概念列表
     */
    @GetMapping("/{ontologyId}/concept")
    public Result listExistedConcept() {
        List<Concept> conceptList = vctService.listConcept();
        return Result.getResult(ResultEnum.SUCCESS, conceptList);
    }

    /***/
    @PostMapping("/{ontologyId}/concept")
    public Result addConcept(@RequestBody Concept concept) {
        return null;
    }

    /**
     * 查询事件关系列表
     */
    @GetMapping("/{ontologyId}/relation")
    public Result listEventClassRelation() {
        //TODO
        return Result.getResult(ResultEnum.SUCCESS);
    }

    /** 新建事件类关系 */
    @PostMapping("/{ontologyId}/relation")
    public Result postEventClassRelation(@PathVariable(name = "ontologyId") Long ontologyId, @RequestBody ECRelation ecRelation) {
        ECRelation ecRelation1 = vctService.postECRelation(ecRelation);
        return Result.getResult(ResultEnum.SUCCESS, ecRelation1);
    }

    /**
     * 查询事件本体下的事件类列表
     */
    @GetMapping("/{ontologyId}/eventclass")
    public Result listExistedEventClass(@PathVariable(name = "ontologyId") Long ontologyId) {
        List<EventClass> eventClassList = vctService.listEventClassByOntologyId(ontologyId);
        return Result.getResult(ResultEnum.SUCCESS, eventClassList);
    }

    /**
     * 查询事件类详情
     */
    @GetMapping("/{ontologyId}/eventclass/{eventId}")
    public Result getEventClassDetail(@PathVariable(name = "ontologyId") Long ontologyId, @PathVariable(name = "eventId") Long eventId) {
        EventClass eventClass = vctService.getEventClassDetail(ontologyId, eventId);
        return Result.getResult(ResultEnum.SUCCESS, eventClass);
    }

    /**
     * 删除事件类
     */
    @DeleteMapping("/{ontologyId}/eventclass/{eventId}")
    public Result deleteEventClass(@PathVariable(name = "ontologyId") Long ontologyId, @PathVariable(name = "eventId") Long eventId) {
        vctService.deleteEventClass(ontologyId, eventId);
        return Result.getResult(ResultEnum.SUCCESS);
    }

    /**
     * 编辑事件类
     */
    @PutMapping("/{ontologyId}/eventclass/{eventId}")
    public Result putEventClass(@PathVariable(name = "ontologyId") Long ontologyId, @PathVariable(name = "eventId") Long eventId,
                                @RequestBody EventClass eventClass) {
        logger.info(eventClass.toString());
        System.out.println(eventClass);
        vctService.putEventClass(eventClass);
        return Result.getResult(ResultEnum.SUCCESS);
    }

    /** 新建事件类 */
    @PostMapping("/{ontologyId}/eventclass")
    public Result postEventClass(@PathVariable(name = "ontologyId") Long ontologyId, @RequestBody EventClass eventClass) {
        eventClass.setOid(ontologyId);
        eventClass.setX(200);
        vctService.postEventClass(eventClass);
        return Result.getResult(ResultEnum.SUCCESS);
    }
}
