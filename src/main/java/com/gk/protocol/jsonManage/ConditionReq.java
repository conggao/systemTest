package com.gk.protocol.jsonManage;

import com.gk.entity.RefreshInfo;
import com.gk.entity.jsonManage.CatInfo;

/**
 * Created by pc on 2017/1/13.
 */
public class ConditionReq {
    private CatInfo catInfo;
    private RefreshInfo refreshInfo;

    public CatInfo getCatInfo() {
        return catInfo;
    }

    public void setCatInfo(CatInfo catInfo) {
        this.catInfo = catInfo;
    }

    public RefreshInfo getRefreshInfo() {
        return refreshInfo;
    }

    public void setRefreshInfo(RefreshInfo refreshInfo) {
        this.refreshInfo = refreshInfo;
    }
}
