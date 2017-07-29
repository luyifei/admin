package com.admin.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.base.dao.Page;
import com.admin.system.dao.SystemUserDao;
import com.admin.system.entity.SystemUser;
import com.admin.system.entity.SystemUserQuery;
import com.admin.system.service.ISystemUserService;
import com.os.jutils.MD5Utils;

@Service
public class SystemUserServiceImpl implements ISystemUserService {
    @Autowired
    SystemUserDao systemUserDao;

    public SystemUser getSystemUser(Long id) {
        return (SystemUser) systemUserDao.getById(id);
    }

    @Override
    public List<SystemUser> listSystemUser(SystemUserQuery systemUserQuery) {
        return systemUserDao.listSystemUser(systemUserQuery);
    }

    @Override
    public Page<SystemUser> listPage(SystemUserQuery systemUserQuery) {
        return systemUserDao.listPage(systemUserQuery);
    }

    @Override
    public void save(SystemUser systemUser) {
        systemUser.setPassword(MD5Utils.encrypt(systemUser.getUserName(), systemUser.getPassword()));
        systemUserDao.save(systemUser);
    }

    @Override
    public void update(SystemUser systemUser) {
        systemUser.setPassword(MD5Utils.encrypt(systemUser.getUserName(), systemUser.getPassword()));
        systemUserDao.update(systemUser);
    }

    @Override
    public void removeById(Long id) {
        systemUserDao.removeById(id);
    }
}
