package com.gk.controller;

import com.gk.entity.DefineForm;
import com.gk.protocol.OptRsp;
import com.gk.protocol.json.JsonListRsp;
import com.gk.service.JsonService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yons on 2017/1/25.
 */
@Controller
@RequestMapping(value = "/Form")
public class FormController {
    @Autowired
    private JsonService jsonService;
    @ApiOperation(value = "getJsonList",httpMethod = "GET")
    @RequestMapping(value = "getJsonList")
    @ResponseBody
    public JsonListRsp getJsonList(){
        JsonListRsp rsp = jsonService.getFormDataList(null);
        return rsp;
    }
    @ApiOperation(value = "AddJson",httpMethod = "POST")
    @ApiImplicitParam(name = "req",value = "req",dataType = "DefineForm")
    @RequestMapping(value = "addJson",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public OptRsp AddJson(@RequestBody DefineForm req){
        OptRsp rsp = new OptRsp();
        rsp.setStatus(1);
        if (jsonService.addDefineFormData(req)) {
            rsp.setStatus(0);
            rsp.setTip("add Json Success");
            return rsp;
        }else {
            rsp.setTip("add Json Fail");
            return rsp;
        }




    }
}
