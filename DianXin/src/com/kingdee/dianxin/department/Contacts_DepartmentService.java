package com.kingdee.dianxin.department;

import com.kingdee.dianxin.utils.Utils;
import com.kingdee.dianxin.utils.WeiXinUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.gson.Gson;

public class Contacts_DepartmentService {
    private static Logger log = LoggerFactory.getLogger(DepartmentTest.class);

    private  static  String createDepartment_url= Utils.DIANXIN_URL+ "department/create?access_token=ACCESS_TOKEN";
    private  static  String updateDepartment_url= Utils.DIANXIN_URL+"department/update?access_token=ACCESS_TOKEN";
    private  static  String deleteDepartment_url= Utils.DIANXIN_URL+"department/delete?access_token=ACCESS_TOKEN&id=ID";
    private  static  String getDepartmentList_url= Utils.DIANXIN_URL+"department/list?access_token=ACCESS_TOKEN&id=ID";


    //1.创建部门
    public void createDepartment(String accessToken,Department department) {

        //1.获取json字符串：将Department对象转换为json字符串
        Gson gson = new Gson();
        String jsonDepartment =gson.toJson(department);      //使用gson.toJson(jsonDepartment)即可将jsonDepartment对象顺序转成json
        System.out.println("jsonDepartment:"+jsonDepartment);
        //2.拼接请求的url
        createDepartment_url=createDepartment_url.replace("ACCESS_TOKEN", accessToken);

        //3.调用接口，发送请求，创建部门
        //JSONObject jsonObject = WeiXinUtil.httpRequest(createDepartment_url, "POST", jsonDepartment);
        String s = WeiXinUtil.httpRequestPost(createDepartment_url,jsonDepartment);
        com.alibaba.fastjson.JSONObject jsonObject =com.alibaba.fastjson.JSON.parseObject(s);
        System.out.println("jsonObject:"+jsonObject.toString());
        if (null != jsonObject) {
            if (0 != jsonObject.getIntValue("errcode")) {

                log.error("创建部门失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            }
        }
    }

    //2.更新部门
    public void updateDepartment(String accessToken,Department department) {

        //1.获取json字符串：将Department对象转换为json字符串
        Gson gson = new Gson();
        String jsonDepartment =gson.toJson(department);      //使用gson.toJson(jsonDepartment)即可将jsonDepartment对象顺序转成json
        System.out.println("jsonDepartment:"+jsonDepartment);
        //2.拼接请求的url
        updateDepartment_url=updateDepartment_url.replace("ACCESS_TOKEN", accessToken);

        //3.调用接口，发送请求，更新部门
        //JSONObject jsonObject = WeiXinUtil.httpRequest(updateDepartment_url, "POST", jsonDepartment);
        String s = WeiXinUtil.httpRequestPost(updateDepartment_url,jsonDepartment);
        com.alibaba.fastjson.JSONObject jsonObject = (com.alibaba.fastjson.JSONObject)com.alibaba.fastjson.JSON.parseObject(s);
        System.out.println("jsonObject:"+jsonObject.toString());
        if (null != jsonObject) {
            if (0 != jsonObject.getIntValue("errcode")) {

                log.error("更新部门失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            }
        }
    }


    //3.删除部门
    public void deleteDepartment(String accessToken,String departmentId) {

        //1.获取请求的url
        deleteDepartment_url=deleteDepartment_url.replace("ACCESS_TOKEN", accessToken)
                .replace("ID", departmentId);

        //2.调用接口，发送请求，删除部门
        //JSONObject jsonObject = WeiXinUtil.httpRequest(deleteDepartment_url, "GET", null);
        JSONObject jsonObject = WeiXinUtil.httpRequestGet(deleteDepartment_url, null);


        System.out.println("jsonObject:"+jsonObject.toString());

        //3.错误消息处理
        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                log.error("删除部门失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
    }



    //4.获取部门列表
    public void getDepartmentList(String accessToken,String departmentId) {

        //1.获取请求的url
        getDepartmentList_url=getDepartmentList_url.replace("ACCESS_TOKEN", accessToken)
                .replace("ID", departmentId);

        //2.调用接口，发送请求，获取成员
        //JSONObject jsonObject = WeiXinUtil.httpRequest(getDepartmentList_url, "GET", null);
        JSONObject jsonObject = WeiXinUtil.httpRequestGet(getDepartmentList_url, null);
        System.out.println("jsonObject:"+jsonObject.toString());

        //3.错误消息处理
        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                log.error("获取部门列表 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
    }


}