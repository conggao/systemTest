package com.gk.controller;

import com.gk.entity.user.UserInfo;
import com.gk.protocol.OptRsp;
import com.gk.protocol.userManage.LoginReq;
import com.gk.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by yons on 2017/1/27.
 */
@Controller
@RequestMapping(value = "user")
@SessionAttributes(value = "user")
public class UserController {
    @Autowired
    private UserService userService;
    @ApiOperation(value = "login",httpMethod = "POST")
    @ApiImplicitParam(value = "req",name = "req",dataType = "LoginReq")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public OptRsp login(@RequestBody LoginReq req, ModelMap map){
        OptRsp rsp = new OptRsp();
        if (userService.login(req.getUserName(),req.getPassword())) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(req.getUserName());
            map.addAttribute("user",userInfo);
            rsp.setStatus(0);
            rsp.setTip("login success");
            return rsp;
        }else {
            rsp.setStatus(1);
            rsp.setTip("login fail");
            return rsp;
        }
    }



}
