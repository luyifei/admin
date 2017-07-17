package com.admin.system.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.BaseTest;
import com.admin.system.model.SystemUser;
import com.admin.system.model.SystemUserQuery;
import com.admin.system.service.ISystemUserService;
import com.sobet.bms.admin.service.AccountLogManager;
import com.sobet.bms.admin.vo.query.AccountLogQuery;

@Service
public class SystemUserServiceTest extends BaseTest {
    @Autowired
    ISystemUserService systemUserService;
    @Autowired
    AccountLogManager accountLogManager;

    @Test
    public void testGetUser() {
        System.out.println(systemUserService.getSystemUser(1L));
    }

    @Test
    public void testListUsers() {
        SystemUserQuery systemUserQuery = new SystemUserQuery();
        systemUserService.listUsers(systemUserQuery);
    }

    @Test
    public void testListPageUsers() {
        SystemUserQuery systemUserQuery = new SystemUserQuery();
//        systemUserQuery.setPageNumber(2);
        systemUserQuery.setPageSize(20);
        /*Page page = systemUserService.listPageUsers(systemUserQuery);
        List<SystemUser> userList = page.getResult();
        for (SystemUser systemUser : userList) {
            System.out.println(systemUser.toString());
        }*/
    }

    @Test
    public void testSaveSystemUser() {
        for (int i = 10; i < 20; i++) {
            SystemUser systemUser = new SystemUser();
            systemUser.setUserName("user_name" + i);
            systemUser.setPassword("password" + i);
            systemUser.setName("name" + i);
            systemUser.setStatus((byte) 0);
            systemUser.setRemark("remark" + i);
            systemUser.setSkin("skin" + i);
            systemUser.setEmail("email" + i);
            systemUser.setNumber("number" + i);
            systemUser.setPhone("phone" + i);
            systemUser.setGoogleAuth("google_auth" + i);
            systemUser.setGoogleAuthStatus(false);
            systemUserService.save(systemUser);
        }
    }

    @Test
    public void testAccountLogManager() {
        AccountLogQuery query = new AccountLogQuery();
        accountLogManager.findPage(query);
    }
}
