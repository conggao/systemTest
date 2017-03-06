package com.gk.protocol.jsonManage;

import com.gk.entity.RefreshInfo;
import com.gk.entity.jsonManage.CatInfo;

/**
 * Created by pc on 2017/1/13.
 */
public class ConditionReq {
    private Long  catId;
    private RefreshInfo refreshInfo;

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public RefreshInfo getRefreshInfo() {
        return refreshInfo;
    }

    public void setRefreshInfo(RefreshInfo refreshInfo) {
        this.refreshInfo = refreshInfo;
    }
}
