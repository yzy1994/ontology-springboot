package org.shu.yzy.ontology.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.shu.yzy.ontology.bean.Result;
import org.shu.yzy.ontology.enums.ResultEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@CrossOrigin
public class UserController {

    /**POST登录*/
    @ResponseBody
    @RequestMapping(path = "/token", method = RequestMethod.POST)
    public Result login(@RequestBody JSONObject jsonObject){
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                jsonObject.get("username").toString(), jsonObject.get("password").toString());
        //登录验证
        subject.login(usernamePasswordToken);
        return Result.getResult(ResultEnum.SUCCESS);
    }

    @ResponseBody
    @GetMapping("/unauth")
    public Result unauth(){
        return Result.getResult(ResultEnum.UNAUTH);
    }
}
