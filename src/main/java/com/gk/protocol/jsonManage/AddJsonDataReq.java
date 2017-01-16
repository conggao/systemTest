package com.gk.protocol.jsonManage;

import com.gk.entity.jsonManage.CatInfo;
import com.gk.entity.jsonManage.JsonDataInfo;

import java.sql.Timestamp;

/**
 * Created by pc on 2017/1/13.
 */
public class AddJsonDataReq {
    private String json;
    private String title;
    private Long catId;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }
}
