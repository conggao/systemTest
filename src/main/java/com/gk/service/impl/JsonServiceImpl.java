package com.gk.service.impl;

import com.gk.dao.jsonManage.CatInfoRepository;
import com.gk.dao.jsonManage.JsonDataInfoRepository;
import com.gk.entity.jsonManage.CatInfo;
import com.gk.entity.jsonManage.JsonDataInfo;
import com.gk.protocol.jsonManage.AddCatReq;
import com.gk.protocol.jsonManage.AddJsonDataReq;
import com.gk.protocol.jsonManage.ConditionReq;
import com.gk.protocol.jsonManage.JsonListRsp;
import com.gk.service.JsonService;
import com.gk.util.BasicUtils;
import com.gk.util.ObjByteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/1/13.
 */
@Service
public class JsonServiceImpl implements JsonService {

    @Autowired
    private CatInfoRepository catInfoRepository;
    @Autowired
    private JsonDataInfoRepository jsonDataInfoRepository;

    @Override
    public boolean TestJson(String jsonString) {
        return false;
    }

    @Override
    public boolean addJsonData(AddJsonDataReq req) {
        Long catId = req.getCatId();
        if (null == catId) {
            CatInfo rootCat = checkRoot(1l, "root");
            if (null == rootCat) {
                return false;
            }

            catId = rootCat.getId();
        }
        JsonDataInfo dataInfo = new JsonDataInfo();
        dataInfo.setCatId(catId);
        System.out.println(ObjByteUtil.toByteArray(req.getJson()));
        dataInfo.setJson(ObjByteUtil.toByteArray(req.getJson()));
        dataInfo.setCreateTime(BasicUtils.getCurrentTime());
        dataInfo.setCreateUserId(1l);
        dataInfo.setDel(false);
        try {
            String UtfTitle=new String(req.getTitle().getBytes("UTF-8"));
            dataInfo.setTitle(UtfTitle);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dataInfo.setUpdateTime(BasicUtils.getCurrentTime());
        if (null != jsonDataInfoRepository.save(dataInfo)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean RemoveJsonData(Long id) {
        return false;
    }

    @Override
    public boolean ModifyJsonData(Long id, AddJsonDataReq req) {
        return false;
    }

    /**
     * 查询json列表
     *
     * @param conditionReq
     * @param userId
     * @return
     */
    @Override
    public JsonListRsp getJsonDataList(ConditionReq conditionReq, Long userId) {

        List<JsonDataInfo> dataInfoList = new ArrayList<>();
        JsonListRsp rsp = new JsonListRsp();
        List<JsonListRsp.JsonBean> lists = new ArrayList<>();
        for (JsonDataInfo info : jsonDataInfoRepository.findAll()) {
            JsonListRsp.JsonBean bean = new JsonListRsp.JsonBean();
            bean.setJson((String) ObjByteUtil.toObject(info.getJson()));
            bean.setTitle(info.getTitle());
            lists.add(bean);
        }
        rsp.setLists(lists);
        return rsp;
    }

    /**
     * 检查是否有根分类
     *
     * @return
     */
    private CatInfo checkRoot(Long userId, String rootName) {
        CatInfo rootCat = getRootCatInfoByUserId(userId);
        if (null == rootCat) {
            AddCatReq catReq = new AddCatReq();
            catReq.setName(rootName);
            catReq.setParentId(null);
            rootCat = addCat(catReq, userId);
            if (null == rootCat) {
                return null;
            }
            return rootCat;
        }
        return rootCat;
    }

    /**
     * 查询用户的根分类信息
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public CatInfo getRootCatInfoByUserId(Long userId) {
        return catInfoRepository.findByParentIdAndCreateUserIdAndDel(null, userId, false);
    }

    @Override
    public CatInfo addCat(AddCatReq req, Long userId) {
        CatInfo info = new CatInfo();
        info.setName(req.getName());
        info.setParentId(req.getParentId());
        info.setCreateTime(BasicUtils.getCurrentTime());
        info.setDel(false);
        info.setShare(false);
        info.setCreateUserId(userId);
        return catInfoRepository.saveAndFlush(info);


    }
}
