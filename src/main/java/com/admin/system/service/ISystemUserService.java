package com.admin.system.service;

import com.admin.system.model.SystemUser;

public interface ISystemUserService {
    /**
     * 根据用户ID查询用户信息
     * 
     * @param id
     * @return
     */
    SystemUser getUser(Long id);

}
