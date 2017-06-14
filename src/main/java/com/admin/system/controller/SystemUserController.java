package com.admin.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.admin.base.controller.BaseController;
import com.admin.system.model.SystemUser;
import com.admin.system.service.ISystemUserService;

@Controller
@RequestMapping(value = "/systemUser")
public class SystemUserController extends BaseController {

    @Resource
    private ISystemUserService systemUserService;

    @RequestMapping(value = "/getUser")
    public ModelAndView getUser(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("id"));
        ModelAndView mav = new ModelAndView();
        SystemUser systemUser = systemUserService.getUser(id);
        return mav;
    }

    @RequestMapping(value = "/listUsers")
    public ModelAndView listUsers(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("system/user/user_list2");
        return mav;
    }
}
