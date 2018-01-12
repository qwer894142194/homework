package com.lanou3g.adminjsps.category.domain;

public class Category {
        private String cname;
        private String cid;

    public Category() {
    }

    public String getCname() {

        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Category(String cname, String cid) {

        this.cname = cname;
        this.cid = cid;
    }
}
