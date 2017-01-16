package com.gk.protocol.jsonManage;

import java.util.List;

/**
 * Created by pc on 2017/1/13.
 */
public class JsonListRsp {

    private List<JsonBean> lists;

    public List<JsonBean> getLists() {
        return lists;
    }

    public void setLists(List<JsonBean> lists) {
        this.lists = lists;
    }

    public static class JsonBean {
        private String title;
        private String json;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }
    }
}
