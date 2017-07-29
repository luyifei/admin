package com.admin.system.service;

import java.util.List;

import com.admin.base.dao.Page;
import com.admin.system.entity.SystemUser;
import com.admin.system.entity.SystemUserQuery;

public interface ISystemUserService {
    /**
     * 根据主键查询
     * 
     * @param id
     * @return
     */
    SystemUser getSystemUser(Long id);

    /**
     * 条件查询
     * 
     * @param systemUserQuery
     * @return
     */
    List<SystemUser> listSystemUser(SystemUserQuery systemUserQuery);

    /**
     * 分页查询
     * 
     * @param systemUserQuery
     * @return
     */
    Page<SystemUser> listPage(SystemUserQuery systemUserQuery);

    /**
     * 保存
     * 
     * @param systemUser
     */
    void save(SystemUser systemUser);

    /**
     * 更新
     * 
     * @param systemUser
     */
    void update(SystemUser systemUser);

    /**
     * 根据主键删除
     * 
     * @param id
     */
    void removeById(Long id);
}
