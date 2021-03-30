package com.kingdee.dianxin.department;

public class Department {
    //部门id
    private Integer id ;
    //部门名称
    private String name;
    //父部门id
    private Integer parentid;
    //在父部门中的次序值
    private Integer order;
    //调用接口凭证
    private String access_token;
    //英文名称
    private String name_en;



    public Department( String name, int parentid) {
        super();
        this.id = id;
        this.name = name;
        this.parentid = parentid;
    }

    public Department(Integer id, String name, Integer parentid) {
        this.id = id;
        this.name = name;
        this.parentid = parentid;
        this.order = order;
        this.access_token = access_token;
        this.name_en = name_en;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }
}