package com.admin.system.service;

import java.util.List;

import com.admin.base.dao.Page;
import com.admin.system.model.SystemUser;
import com.admin.system.model.SystemUserQuery;


public interface ISystemUserService {
    /**
     * 根据用户ID查询用户信息
     * 
     * @param id
     * @return
     */
    SystemUser getSystemUser(Long id);
    
    
    List<SystemUser> listUsers(SystemUserQuery systemUserQuery);
    
    Page<SystemUser> listPage(SystemUserQuery systemUserQuery);
    
    void save(SystemUser systemUser);
}
