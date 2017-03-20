package com.gk.entity;

import com.alibaba.fastjson.JSON;
import com.gk.protocol.json.AddJsonDataReq;
import org.junit.Test;

/**
 * Created by yons on 2017/2/1.
 */
public class JsonToObject {
    @Test
    public void testAddJsonDataReq() {
        String json = "{title:\"fgt\",json:\"jhfghg\",catId:\"1\"}";
        AddJsonDataReq req= JSON.parseObject(json,AddJsonDataReq.class);
        System.out.println(req.getCatId());
        System.out.println(req.getCatId());
        System.out.println(req.getTitle());
    }
}
