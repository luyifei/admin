package com.admin.system.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.admin.base.dao.BaseIbatis3Dao;
import com.admin.base.dao.Page;
import com.admin.system.entity.SystemUser;
import com.admin.system.entity.SystemUserQuery;


@Repository
public class SystemUserDao extends BaseIbatis3Dao<SystemUser, java.lang.Long>{
    @Override
    public String getIbatisMapperNamesapce() {
        return "SystemUser";
    }
    public Page<SystemUser> listPage(SystemUserQuery systemUserQuery){
        return pageQuery("list", systemUserQuery);
    }
    public List<SystemUser> listSystemUser(SystemUserQuery systemUserQuery){
        return getSqlSessionTemplate().selectList("list", systemUserQuery);
    }

}