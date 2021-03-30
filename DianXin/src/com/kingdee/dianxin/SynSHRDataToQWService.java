package com.kingdee.dianxin;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.bsf.service.app.IHRMsfService;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;

public class SynSHRDataToQWService implements IHRMsfService{
    private SimpleDateFormat sdfDate =  new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdfTime =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat sdfMinute =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
//	public Object process(Context ctx, Map param) throws EASBizException, BOSException {
		HashSet<String> personSet = (HashSet<String>)param.get("person");
		HashSet<String> positionSet = (HashSet<String>)param.get("position");
		HashSet<String> adminSet = (HashSet<String>)param.get("orgUnit");
		synAdminOrgDataToSap(ctx,adminSet);
//		synPositionDataToSap(ctx,positionSet);
//		synPersonDataToSap(ctx,personSet);
		return null;
	}
	
	//根据组织id字符串，获取更新方式，获取组织信息更新到sap
	private void synAdminOrgDataToSap(Context ctx, HashSet<String> adminSet) throws BOSException {
		System.out.println("synAdminOrgDataToSap");
		
		if (adminSet == null || adminSet.size() == 0) {
			return;
		}
		Iterator<String> iter = adminSet.iterator();
		String[] str = null;
		while (iter.hasNext()) {
			String optMethod = null;
			str = iter.next().split("@");
			String adminOrgId = str[0];
			if (str.length > 1) {
				optMethod = str[1];
			}
			IRowSet rs = getAdminOrgData(ctx,adminOrgId);
			if (optMethod != null && optMethod.equals("addNewHistoryOnly") || optMethod.equals("addNew")) {//新增
				//处理组织新增
				addNewOrgToSap(rs);
			} else if(optMethod != null && (optMethod.equals("reviseHistoryOnly")//更新
					||optMethod.equals("updateHistoryOnly")
					||optMethod.equals("updatePartial")
					||optMethod.equals("update")
					||optMethod.equals("revise")))  {
				//处理组织修改
				updateOrgToSap(rs);
			}else if(optMethod != null && (optMethod.equals("delete"))){
				//处理组织删除
				deleteOrgOfSap(rs);
			}
		}
	}
	
	//获取变化的组织数据
	private IRowSet getAdminOrgData(Context ctx,String adminOrgId) throws BOSException{
		StringBuffer sql = new StringBuffer("select fid,fname_l2,fnumber from t_org_admin where fid='").append(adminOrgId).append("'");
		IRowSet rs = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx, sql.toString());
		return rs;
	}
	
	private void deleteOrgOfSap(IRowSet rs) {
		System.out.println("deleteOrgOfSap");
	}

	
	private void updateOrgToSap(IRowSet rs) {
		System.out.println("updateOrgToSap");
	}

	private void addNewOrgToSap(IRowSet rs) {
		System.out.println("addNewOrgToSap");
	}
}
