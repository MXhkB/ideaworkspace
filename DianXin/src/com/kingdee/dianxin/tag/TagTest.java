package com.kingdee.dianxin.tag;


import com.kingdee.dianxin.utils.WeiXinParamesUtil;
import com.kingdee.dianxin.utils.WeiXinUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    标签管理
*/
public class TagTest {

    //1.创建标签
    @Test
    public  void testCreateTag() {

        //标签id
        Integer tagid=18;
        //标签名字
        String tagname="后盾开发";

        //2.获取access_token:根据企业id和通讯录密钥获取access_token,并拼接请求url
        String accessToken= WeiXinUtil.getAccessTokenString(WeiXinParamesUtil.corpId, WeiXinParamesUtil.contactsSecret).getToken();
        System.out.println("accessToken:"+accessToken);

        //3.创建标签
        Contacts_TagService cds = new Contacts_TagService();
        cds.createTag(accessToken, tagname,tagid);

    }




    //2.增加标签成员
    @Test
    public void testaddTagUser(){

        //1.创建
       Integer tagid=10;
        //1.获取userIdList
        String userId1="qjing";
        String userId2="fangzh";
        List<String> userlist = Arrays.asList(userId1, userId2);  //此时将userIdList转json,则结果为：["3","4"],会报错：{"errcode":40063,"errmsg":"some parameters are empty"}


        //2.获取access_token:根据企业id和通讯录密钥获取access_token,并拼接请求url
        String accessToken= WeiXinUtil.getAccessTokenString(WeiXinParamesUtil.corpId, WeiXinParamesUtil.contactsSecret).getToken();
        System.out.println("accessToken:"+accessToken);

        //3.增加
        Contacts_TagService cds = new Contacts_TagService();
        cds.addTagUser(accessToken,tagid, userlist);
    }


    //3.删除标签成员
    @Test
    public void testdeleteTagUsers(){

        //1.创建
        String tagId="10";
        //1.获取userIdList
        String userId1="qjing";
        String userId2="fangzh";
        List<String> userlist = Arrays.asList(userId1, userId2);  //此时将userIdList转json,则结果为：["3","4"],会报错：{"errcode":40063,"errmsg":"some parameters are empty"}


        //2.获取access_token:根据企业id和通讯录密钥获取access_token,并拼接请求url
        String accessToken= WeiXinUtil.getAccessTokenString(WeiXinParamesUtil.corpId, WeiXinParamesUtil.contactsSecret).getToken();
        System.out.println("accessToken:"+accessToken);

        //3.删除标签成员
        Contacts_TagService cds = new Contacts_TagService();
        cds.deleteTagUsers(accessToken,tagId,userlist);
    }


    //4.获取标签列表
    @Test
    public void getTagList(){

        //String tagId="1";

        //2.获取access_token:根据企业id和通讯录密钥获取access_token,并拼接请求url
        String accessToken= WeiXinUtil.getAccessTokenString(WeiXinParamesUtil.corpId, WeiXinParamesUtil.contactsSecret).getToken();
        System.out.println("accessToken:"+accessToken);

        //3.更新
        Contacts_TagService cds = new Contacts_TagService();
        cds.getTagList(accessToken);
    }


    //5.获取标签成员
    @Test
    public void testgetTagUser(){
        //1.id
        Integer tagId=10;

        //2.获取access_token:根据企业id和通讯录密钥获取access_token,并拼接请求url
        String accessToken= WeiXinUtil.getAccessTokenString(WeiXinParamesUtil.corpId, WeiXinParamesUtil.contactsSecret).getToken();
        System.out.println("accessToken:"+accessToken);

        //3.创建成员
        Contacts_TagService cus=new Contacts_TagService();
        cus.getTagUser(accessToken,tagId);

    }
}
