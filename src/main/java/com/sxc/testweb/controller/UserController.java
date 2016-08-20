package com.sxc.testweb.controller;

import com.sxc.testweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: UserController
 *
 * @author: weimengchao
 * @version: 1.0
 * Create: 2016/6/1
 * Copyright: Copyright (c)2016
 * Company: songxiaocai
 * -
 * Modification History:
 * Date              Author      Version     Description
 * —————————————————————————————————
 * 2016/6/1       weimengchao    1.0       1.0 Version
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean rs = userService.login(username, password);
        if (rs) {
            mv.setViewName("../index.jsp");
        } else {
            mv.setViewName("error.jsp");
        }

        return mv;

    }
}
