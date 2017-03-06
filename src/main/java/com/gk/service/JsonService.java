package com.gk.service;

import com.gk.entity.DefineForm;
import com.gk.entity.jsonManage.CatInfo;
import com.gk.protocol.jsonManage.AddCatReq;
import com.gk.protocol.jsonManage.AddJsonDataReq;
import com.gk.protocol.jsonManage.ConditionReq;
import com.gk.protocol.jsonManage.JsonListRsp;

/**
 * Created by pc on 2017/1/13.
 */
public interface JsonService {
    boolean TestJson(String jsonString);

    /*
    数据操作
     */
    boolean addJsonData(AddJsonDataReq req);

    boolean addDefineFormData(DefineForm defineForm);

    boolean removeJsonData(Long id);

    boolean modifyJsonData(Long id, AddJsonDataReq req);

    JsonListRsp getJsonDataList(ConditionReq conditionReq,Long userId);

    JsonListRsp getFormDataList(Long userId);
    /*
     目录操作
      */
    CatInfo getRootCatInfoByUserId(Long userId);

    CatInfo addCat(AddCatReq req, Long userId);


}
