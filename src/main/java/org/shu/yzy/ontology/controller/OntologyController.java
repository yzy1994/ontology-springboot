package org.shu.yzy.ontology.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.shu.yzy.ontology.bean.OntoEditVO;
import org.shu.yzy.ontology.bean.Result;
import org.shu.yzy.ontology.enums.ResultEnum;
import org.shu.yzy.ontology.model.Ontology;
import org.shu.yzy.ontology.service.OntologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/ontology")
public class OntologyController {
    @Autowired
    OntologyService ontologyService;

    /**获取当前存在的本体列表*/
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Result listExistedOntologyList(){
        Subject currentUser = SecurityUtils.getSubject();

        List<Ontology> ontologyList = ontologyService.listExistedOntology();
        String role = "admin";
        //TODO
        OntoEditVO ontoEditVO = new OntoEditVO(role, ontologyList);
        return Result.getResult(ResultEnum.SUCCESS, ontoEditVO);
    }

    /** 创建事件类 */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    @RequiresRoles({"admin", "builder"})
    public Result createOntology(Ontology ontology){
        ontologyService.saveOntology(ontology);
        return Result.getResult(ResultEnum.SUCCESS);

    }

    @ResponseBody
    @RequestMapping(value = "/{ontologyId}", method = RequestMethod.PUT)
    @RequiresRoles({"admin", "builder"})
    public Result editOntology(Ontology ontology){
        ontologyService.saveOntology(ontology);
        return Result.getResult(ResultEnum.SUCCESS);
    }

    @ResponseBody
    @RequestMapping(value = "/{ontologyId}", method = RequestMethod.DELETE)
    @RequiresRoles({"admin", "builder"})
    public Result editOntology(@PathVariable("ontologyId") Long ontologyId){
        ontologyService.deleteOntology(ontologyId);
        return Result.getResult(ResultEnum.SUCCESS);

    }
}
