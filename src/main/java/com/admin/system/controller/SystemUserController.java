package com.admin.system.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.admin.base.controller.BaseController;
import com.admin.base.dao.Page;
import com.admin.system.entity.SystemUser;
import com.admin.system.entity.SystemUserQuery;
import com.admin.system.service.ISystemUserService;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/systemUser")
public class SystemUserController extends BaseController {
    private final String LIST_ACTION = "redirect:/systemUser/list.do";
    @Autowired
    private ISystemUserService systemUserService;

    @RequestMapping(value = "/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response,
            SystemUserQuery systemUserQuery) {
        ModelAndView mav = new ModelAndView();
        Page<SystemUser> page = systemUserService.listPage(systemUserQuery);
        mav.addObject("page", page);
        mav.addObject("query", systemUserQuery);
        mav.setViewName("systemUser/list");
        return mav;
    }

    /**
     * 查看对象
     **/
    @RequestMapping(value = "/show")
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response, Long id) throws Exception {
        SystemUser systemUser = systemUserService.getSystemUser(id);
        return new ModelAndView("systemUser/show", "systemUser", systemUser);
    }

    /**
     * 进入新增页面
     **/
    @RequestMapping(value = "/create")
    public ModelAndView create(HttpServletRequest request, HttpServletResponse response, SystemUser systemUser)
            throws Exception {
        return new ModelAndView("systemUser/create", "systemUser", systemUser);
    }

    /**
     * 保存新增对象
     */
    @ResponseBody
    @RequestMapping(value = "/save")
    public void save(HttpServletRequest request, HttpServletResponse response, SystemUser systemUser) {
        //System.out.println(systemUser.toString());
        systemUserService.save(systemUser);
        outJson(response, "保存成功");
    }

    /**
     * 进入更新页面
     **/
    @RequestMapping(value = "/edit")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, Long id) throws Exception {
        SystemUser systemUser = systemUserService.getSystemUser(id);
        return new ModelAndView("systemUser/edit", "systemUser", systemUser);
    }

    /**
     * 保存更新对象
     **/
    @RequestMapping(value = "/update")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response, SystemUser systemUser)
            throws Exception {
        systemUserService.update(systemUser);
        return new ModelAndView(LIST_ACTION);
    }

    /**
     * 批量删除对象
     **/
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
        // String[] items = request.getParameterValues("items");
        /*
         * for (int i = 0; i < items.length; i++) { Hashtable params =
         * HttpUtils.parseQueryString(items[i]);
         * 
         * java.lang.Long id = new java.lang.Long((String) params.get("id"));
         * 
         * preAdminActivityBatchManager.removeById(id); }
         * Flash.current().success(DELETE_SUCCESS);
         */
        return new ModelAndView(LIST_ACTION);
    }

    public void outJson(HttpServletResponse response, Object obj) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(obj.toString());
            response.setContentType("text/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.write(json);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
