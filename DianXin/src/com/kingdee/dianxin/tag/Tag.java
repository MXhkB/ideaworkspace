package com.kingdee.dianxin.tag;

import com.kingdee.dianxin.user.User;

import java.util.List;

public class Tag {

    //标签id
    private Integer tagid;
    //标签名字
    private String tagname;

    public Tag() {
    }

    public Tag(Integer tagid, String tagname) {

        this.tagid = tagid;
        this.tagname = tagname;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagid=" + tagid +
                ", tagname='" + tagname + '\'' +
                '}';
    }
}
