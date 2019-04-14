package org.shu.yzy.ontology.controller;

import org.shu.yzy.ontology.bean.Result;
import org.shu.yzy.ontology.dao.OntologyResearcherDao;
import org.shu.yzy.ontology.enums.ResultEnum;
import org.shu.yzy.ontology.model.OntologyPaper;
import org.shu.yzy.ontology.model.OntologyResearcher;
import org.shu.yzy.ontology.service.AboutusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class AboutusController {
    @Autowired
    AboutusService aboutusService;

    @ResponseBody
    @RequestMapping("/researcher")
    public Result listResearchers(){
        List<OntologyResearcher> ontologyResearcherList = aboutusService.listResearcher();
        return Result.getResult(ResultEnum.SUCCESS, ontologyResearcherList);
    }

    @ResponseBody
    @RequestMapping("/paper")
    public Result listPapers(){
        List<OntologyPaper> ontologyPaperList = aboutusService.listPaper();
        return Result.getResult(ResultEnum.SUCCESS, ontologyPaperList);
    }
}
