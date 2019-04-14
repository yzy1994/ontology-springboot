package org.shu.yzy.ontology.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shu.yzy.ontology.dao.OntologyResearcherDao;
import org.shu.yzy.ontology.model.OntologyResearcher;
import org.shu.yzy.ontology.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    OntologyResearcherDao dao;

    @Test
    public void loginService() {

    }

    @Test
    public void findByUserName() {
        User user = userService.findByUserName("admin");
        System.out.println(user);
    }

    @Test
    public void testDao(){
        List<OntologyResearcher> ontologyResearchers = dao.findAll();
        for(OntologyResearcher ontologyResearcher: ontologyResearchers){
            System.out.println(ontologyResearcher);
        }
        OntologyResearcher ontologyResearcher = new OntologyResearcher();
        ontologyResearcher.setName("刘炜");
        ontologyResearcher.setPicpath("resources/images/researcherpic/lw.png");
        ontologyResearcher.setResume("刘炜，博士，上海大学计算机工程与科学学院副研究员，CCF会员，CCF服务计算专委会委员，主要研究领域为知识表示与推理，语义网与本体技术、事件推理、语义大数据等。美国Kno.e.sis研究中心访问研究员，发表学术论文50 余篇，主持和参与国家自然科学基金项目6项，主持上海市自然科学基金项目1 项、军口863子课题及多项省部级科研项目。");
        dao.save(ontologyResearcher);
    }
}