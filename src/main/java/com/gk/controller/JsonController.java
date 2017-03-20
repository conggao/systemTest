package com.gk.controller;

import com.alibaba.fastjson.JSON;
import com.gk.protocol.OptRsp;
import com.gk.protocol.cat.AddCatReq;
import com.gk.protocol.json.AddJsonDataReq;
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
@RequestMapping(value = "/Json")
public class JsonController {
    @Autowired
    private JsonService jsonService;
    @ApiOperation(value = "getListJson",httpMethod = "GET")
    @RequestMapping(value = "getJsonList")
    @ResponseBody
    public JsonListRsp getJsonList(){
        JsonListRsp rsp = jsonService.getJsonDataList(null,null);
        return rsp;
    }
    @ApiOperation(value = "addJson",notes = "新增json记录",httpMethod = "POST")
    @ApiImplicitParam(value = "req",dataType = "String")
    @RequestMapping(value = "addJson",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public OptRsp AddJson(@RequestBody String req){
        AddJsonDataReq dataReq = JSON.parseObject(req, AddJsonDataReq.class);
        OptRsp rsp = new OptRsp();
        rsp.setStatus(1);
        if (jsonService.addJsonData(dataReq)) {
            rsp.setStatus(0);
            rsp.setTip("add Json Success");
            return rsp;
        }else {
            rsp.setTip("add Json Fail");
            return rsp;
        }
    }
    @ApiOperation(value = "addCat",httpMethod = "POST")
    @ApiImplicitParam(value = "req",dataType = "com.gk.protocol.cat.AddCatReq")
    @RequestMapping(value = "addCat",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public OptRsp AddCat(AddCatReq req){

        OptRsp rsp = new OptRsp();
        rsp.setStatus(0);
    rsp.setTip("添加目录失败");
        if (null!=jsonService.addCat(req,1l)){
            rsp.setStatus(1);
            rsp.setTip("添加目录成功");
        }
        return rsp;
    }
}
