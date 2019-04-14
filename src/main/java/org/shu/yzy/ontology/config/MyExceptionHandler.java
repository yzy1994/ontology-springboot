package org.shu.yzy.ontology.config;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.shu.yzy.ontology.bean.Result;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
@ResponseBody
public class MyExceptionHandler implements HandlerExceptionResolver {

    /** Controller方法抛出异常时自动调用 */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("code", 500);
        attributes.put("msg", "inner error");
        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }

}

