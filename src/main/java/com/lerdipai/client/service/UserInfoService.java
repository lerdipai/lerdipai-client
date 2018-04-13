package com.lerdipai.client.service;

import org.springframework.stereotype.Service;

import com.icafebutler.framework.service.CrudService;
import com.lerdipai.client.dao.UserInfoDAO;
import com.lerdipai.client.pojo.UserInfo;

@Service
public class UserInfoService extends CrudService<UserInfo, UserInfoDAO> {
    
}
