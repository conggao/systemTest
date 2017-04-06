package com.gk.service;

import com.gk.protocol.user.RigistReq;

/**
 * Created by yons on 2017/1/27.
 */
public interface UserService {
    boolean login(String userName,String password);
    boolean rigist(RigistReq req);
}
