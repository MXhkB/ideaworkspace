package com.kingdee.dianxin.tag;


import com.google.gson.Gson;

import com.kingdee.dianxin.department.DepartmentTest;
import com.kingdee.dianxin.user.User;
import com.kingdee.dianxin.utils.Utils;
import com.kingdee.dianxin.utils.WeiXinUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts_TagService {

    private static Logger log = LoggerFactory.getLogger(DepartmentTest.class);

    private static String createTag_url = Utils.DIANXIN_URL + "tag/create?access_token=ACCESS_TOKEN";
    private static String getTagUser_url = Utils.DIANXIN_URL + "tag/get?access_token=ACCESS_TOKEN&tagid=TAGID";
    private static String addTagUsers_url = Utils.DIANXIN_URL + "tag/addtagusers?access_token=ACCESS_TOKEN";
    private static String deleteTagUsers_url = Utils.DIANXIN_URL + "tag/deltagusers?access_token=ACCESS_TOKEN";
    private static String getTagList_url = Utils.DIANXIN_URL + "tag/list?access_token=ACCESS_TOKEN";


    //1.创建标签
    public void createTag(String accessToken, String tagname, Integer tagid) {

        //获取标签列表
        String tagList = getTagList(accessToken);

        if (!tagname.isEmpty() && !tagList.contains(tagname)) {

            Tag tag = new Tag();
            tag.setTagname(tagname);
            tag.setTagid(tagid);

            //1.获取json字符串：将tag对象转换为json字符串
            Gson gson = new Gson();
            String jsonTag = gson.toJson(tag);
            System.out.println("jsonTag:" + jsonTag);
            //2.拼接请求的url
            createTag_url = createTag_url.replace("ACCESS_TOKEN", accessToken);

            //3.调用接口，发送请求，创建标签
            String s = WeiXinUtil.httpRequestPost(createTag_url, jsonTag);
            com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSON.parseObject(s);
            System.out.println("jsonObject:" + jsonObject.toString());

            if (null != jsonObject) {
                if (0 != jsonObject.getIntValue("errcode")) {
                    log.error("创建标签失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
                }
            }
        }else {
            System.out.println("标签已存在");
        }
    }


    //2.增加标签成员
    public void addTagUser(String accessToken, Integer tagid, List<String> userlist) {

        Map<String, Object> content = new HashMap<String, Object>();
        content.put("tagid", tagid);
        content.put("userlist", userlist);

        Gson gson=new Gson();
        String json=gson.toJson(content);
        System.out.println(json);

        //2.获取请求的url
        addTagUsers_url = addTagUsers_url.replace("ACCESS_TOKEN", accessToken);
        //3.调用接口，发送请求，创建成员
        String s = WeiXinUtil.httpRequestPost(addTagUsers_url, json);
        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSON.parseObject(s);

        System.out.println("jsonObject:" + jsonObject.toString());

        //4.错误消息处理
        if (null != jsonObject) {
            if (0 != jsonObject.getIntValue("errcode")) {
                log.error("增加标签成员失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            }
        }
    }


    //3.删除标签成员
    public void deleteTagUsers(String accessToken, String tagid,List<String> userlist) {

        //1.获取json字符串：将user对象转换为json字符串
        Map<String, Object> content = new HashMap<String, Object>();
        content.put("userlist", userlist);
        content.put("tagid", tagid);

        Gson gson=new Gson();
        String json=gson.toJson(content);
        System.out.println(json);

        //1.请求路径
        deleteTagUsers_url = deleteTagUsers_url.replace("ACCESS_TOKEN", accessToken);

        //2.调用接口，发送请求，删除标签
        String s = WeiXinUtil.httpRequestPost(deleteTagUsers_url, json);
        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSON.parseObject(s);
        System.out.println("jsonObject:" + jsonObject.toString());

        //3.错误消息处理
        if (null != jsonObject) {
            if (0 != jsonObject.getIntValue("errcode")) {
                log.error("删除标签成员失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
            }
        }
    }

    //获取标签列表
    public String getTagList(String accessToken) {
        //1.请求路径
        getTagList_url = getTagList_url.replace("ACCESS_TOKEN", accessToken);

        //2.调用接口，发送请求，获取标签成员
        JSONObject jsonObject = WeiXinUtil.httpRequestGet(getTagList_url, null);
        System.out.println("jsonObject:" + jsonObject.toString());

        //3.错误消息处理
        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                log.error("获取标签成员失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }

        return jsonObject.toString();
    }



    //4.获取标签成员
    public void getTagUser(String accessToken, Integer tagid) {

        //1.请求路径
        getTagUser_url=getTagUser_url.replace("ACCESS_TOKEN", accessToken)
                .replace("TAGID", tagid.toString());

        //2.调用接口，发送请求，获取标签成员
        JSONObject jsonObject = WeiXinUtil.httpRequestGet(getTagUser_url,null);
        System.out.println("jsonObject:"+jsonObject.toString());

        //3.错误消息处理
        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                log.error("获取标签成员失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }
    }
}
