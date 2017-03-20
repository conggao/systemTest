package com.gk.protocol.cat;

/**
 * Created by pc on 2017/1/13.
 */
public class AddCatReq {
    private Long parentId;
    private String name;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
