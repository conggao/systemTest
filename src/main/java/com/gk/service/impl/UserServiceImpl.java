package com.gk.service.impl;

import com.gk.protocol.user.RigistReq;
import com.gk.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by yons on 2017/1/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean login(String userName,String password) {
        return false;
    }

    @Override
    public boolean rigist(RigistReq req) {
        return false;
    }
}
