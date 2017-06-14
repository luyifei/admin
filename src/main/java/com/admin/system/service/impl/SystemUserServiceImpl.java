package com.admin.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.system.dao.SystemUserMapper;
import com.admin.system.model.SystemUser;
import com.admin.system.service.ISystemUserService;

@Service
public class SystemUserServiceImpl implements ISystemUserService {
    @Autowired
    SystemUserMapper systemUserMapper;

    public SystemUser getUser(Long id) {
        return systemUserMapper.selectByPrimaryKey(id);

    }
}
