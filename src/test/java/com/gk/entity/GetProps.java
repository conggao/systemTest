package com.gk.entity;

import com.alibaba.fastjson.JSON;
import com.gk.protocol.jsonManage.AddCatReq;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yons on 2017/1/28.
 */
public class GetProps {
    @Test
    public void getProps(){
        Class addCatReq = AddCatReq.class;
        Field[] fields = addCatReq.getDeclaredFields();
        List<String> fieldList = new ArrayList<>();
        for (Field field : fields) {
            fieldList.add(field.getName());
            System.out.println("className:"+field.getType().getName()+"   "+"fieldName:"+field.getName());
            System.out.println(JSON.toJSONString(fieldList));

        }
    }
}
