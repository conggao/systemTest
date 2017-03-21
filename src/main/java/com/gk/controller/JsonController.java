package com.gk.controller;

import com.alibaba.fastjson.JSON;
import com.gk.protocol.OptRsp;
import com.gk.protocol.jsonManage.AddJsonDataReq;
import com.gk.protocol.jsonManage.JsonListRsp;
import com.gk.service.JsonService;
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
    @RequestMapping(value = "getJsonList")
    @ResponseBody
    public JsonListRsp getJsonList(){
        JsonListRsp rsp = jsonService.getJsonDataList(null,null);
        return rsp;
    }
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
}
