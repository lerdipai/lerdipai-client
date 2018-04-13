package com.lerdipai.client.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.lerdipai.client.pojo.UserInfo;
import com.lerdipai.client.service.UserInfoService;
import com.lerdipai.client.test.BaseTest;

@Transactional(transactionManager = "lerdipaiTransactionManager")
@Rollback(value=false)
public class UserInfoServiceTest extends BaseTest {
    @Autowired
    private UserInfoService userInfoService;
    
    @Test
    public void test1(){
        UserInfo userInfo = new UserInfo();
        userInfo.setMobile("18968199919");
        userInfoService.save(userInfo);
    }

}
