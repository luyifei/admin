package com.admin.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.base.dao.Page;
import com.admin.system.dao.SystemUserDao;
import com.admin.system.model.SystemUser;
import com.admin.system.model.SystemUserQuery;
import com.admin.system.service.ISystemUserService;


@Service
public class SystemUserServiceImpl implements ISystemUserService {
   /* @Autowired
    SystemUserMapper systemUserMapper;*/
    @Autowired
    SystemUserDao systemUserDao;
    
    public SystemUser getSystemUser(Long id) {
       return (SystemUser) systemUserDao.getById(id);
    }

    @Override
    public List<SystemUser> listUsers(SystemUserQuery systemUserQuery) {
//        systemUserMapper.listUsers(systemUserQuery);
        return null;
    }

    @Override
    public Page<SystemUser> listPage(SystemUserQuery systemUserQuery) {
        return systemUserDao.listPage(systemUserQuery);
    }
    
    @Override
    public void save(SystemUser systemUser){
        systemUserDao.save(systemUser);
    }
}
