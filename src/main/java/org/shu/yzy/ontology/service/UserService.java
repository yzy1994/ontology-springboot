package org.shu.yzy.ontology.service;

import org.shu.yzy.ontology.dao.RoleDao;
import org.shu.yzy.ontology.dao.UserDao;
import org.shu.yzy.ontology.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    public User loginService(String username, String password){
        User user = userDao.findByUsername(username);


        if(user==null){
            return null;
        }

        if(!password.equals(user.getPassword())){
            return null;
        }

        return user;
    }

    public User findByUserName(String username){
        User user = userDao.findByUsername(username);
        if(user==null){
            return user;
        }
        return user;
    }
}
