package com.kingdee.dianxin.department;


import com.kingdee.dianxin.utils.WeiXinParamesUtil;
import com.kingdee.dianxin.utils.WeiXinUtil;
import org.junit.Test;

/**
 * 部门管理
 * @author shirayner
 *
 *
 */

public class DepartmentTest {


    //1.创建部门
    @Test
    public  void testCreateDepartment() {
        //1.创建Department对象，并将对象转换成json字符串
        //Department department = new Department(3, "HEC武汉分公司", 2);
        Department department = new Department(12345,"广州研发", 102);

        //2.获取access_token:根据企业id和通讯录密钥获取access_token,并拼接请求url
        String accessToken= WeiXinUtil.getAccessTokenString(WeiXinParamesUtil.corpId, WeiXinParamesUtil.contactsSecret).getToken();
        System.out.println("accessToken:"+accessToken);

        //3.创建部门
        Contacts_DepartmentService cds= new Contacts_DepartmentService();
        cds.createDepartment(accessToken, department);

    }


    //2.更新部门
    @Test
    public void testUpdateDepartment() {
        //1.创建Department对象，并将对象转换成json字符串
        Department department = new Department( 123456,"HEC技术服务中心", 102);


        //2.获取access_token:根据企业id和通讯录密钥获取access_token,并拼接请求url
        String accessToken= WeiXinUtil.getAccessTokenString(WeiXinParamesUtil.corpId, WeiXinParamesUtil.contactsSecret).getToken();
        System.out.println("accessToken:"+accessToken);

        //3.更新部门
        Contacts_DepartmentService cds= new Contacts_DepartmentService();
        cds.updateDepartment(accessToken, department);
    }

    //3.删除部门
    @Test
    public void testDeleteDepartment() {
        //1.获取userId
        String departmentId="123456";

        //2.获取access_token:根据企业id和通讯录密钥获取access_token,并拼接请求url
        String accessToken= WeiXinUtil.getAccessTokenString(WeiXinParamesUtil.corpId, WeiXinParamesUtil.contactsSecret).getToken();
        System.out.println("accessToken:"+accessToken);

        //3.删除部门
        Contacts_DepartmentService cds= new Contacts_DepartmentService();
        cds.deleteDepartment(accessToken, departmentId);
    }


    /**
     * 4.获取部门列表
     * 参数                  必须说明
     * access_token    是    调用接口凭证
     * id              否    部门id。获取指定部门及其下的子部门。 如果不填，默认获取全量组织架构
     */
    @Test
    public void testGetDepartmentList() {
        //1.获取departmentId
        String departmentId="1";

        //2.获取access_token:根据企业id和通讯录密钥获取access_token,并拼接请求url
        String accessToken= WeiXinUtil.getAccessTokenString(WeiXinParamesUtil.corpId, WeiXinParamesUtil.contactsSecret).getToken();
        System.out.println("accessToken:"+accessToken);

        //3.调用接口，发送请求，
        Contacts_DepartmentService cds= new Contacts_DepartmentService();
        cds.getDepartmentList(accessToken, departmentId);
    }


}