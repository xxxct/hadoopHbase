package Process;
import hbase.HBase;

import java.util.ArrayList;
import java.util.List;

import bean.BingAn;
import bean.xiechanggui;
import bean.yizhu;

/*根据前端的搜索条件  来对后端数据进行处理*/
public class processData {
	
	/*病案号*/
	public static List<BingAn> bingAnSearchByBingAn(String table,String input){	
		List<List> list = HBase.getByRowKey(table, input);	
		List<BingAn> result = BingAn.toBingAn(list);		
		return  result;
	}
	
	public static List<BingAn> bingAnSearchByColumn(String table,String column,String input){
		List<List> list = HBase.SingleColumnValueFilter(table,column,input);	
		List<BingAn> result = BingAn.toBingAn(list);		
		return  result;
	}
	
	
	/*血常规表    病案号查询*
	 														表       列       值
	 */
	public static List<xiechanggui> xcgSearchByColumn(String table,String column,String input){
		List<List> list = HBase.SingleColumnValueFilter(table,column,input);
		List<xiechanggui> result = xiechanggui.toXcg(list);
		return  result;
	}
	
	public static List<xiechanggui> xcgSearchByZhuYuan(String table,String input){
		List<List> list = HBase.getByRowKey(table, input);
		List<xiechanggui> result = xiechanggui.toXcg(list);
		return  result;
	}
	
	
	
	/*医嘱表  根据住院号查询*/
	public static List<yizhu> yizhuSearchByZhuYuan(String table,String input){	
		List<List> list = HBase.getByRowKey(table, input);	
		List<yizhu> result = yizhu.toYizhu(list);		
		return  result;
	}
	
	
	/*医嘱表  根据医嘱查询*/
	public static List<yizhu> yizhuSearchByColumn(String table,String column,String input){	
		List<List> list = HBase.SingleColumnValueFilter(table,column,input);	
		List<yizhu> result = yizhu.toYizhu(list);		
		return  result;
	}
	
}
		
