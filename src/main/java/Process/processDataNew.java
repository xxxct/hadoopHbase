package Process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.BingAn;
import bean.xiechanggui;
import bean.yizhu;
import hbase.HBase;

public class processDataNew {
	public static List<BingAn> baResultToHbase(List<String> rowKeyList) throws IOException{
		List <Map<String, String>> maps = new ArrayList<>();
		for(String rowKey:rowKeyList){
			Map<String,String> map =HBase.getOneRecord("BINGAN", rowKey);
			maps.add(map);
		}
		List<BingAn> list = BingAn.toBingAnNew(maps);
		return list;
		
	}
	
	public static List<xiechanggui> xcgResultToHbase(List<String> rowKeyList) throws IOException{
		List <Map<String, String>> maps = new ArrayList<>();
		for(String rowKey:rowKeyList){
			Map<String,String> map =HBase.getOneRecord("xiechanggui", rowKey);
			maps.add(map);
		}
		List<xiechanggui> list = xiechanggui.toXcgNew(maps);
		return list;
		
	}
	
	public static List<yizhu> yzResultToHbase(List<String> rowKeyList) throws IOException{
		List <Map<String, String>> maps = new ArrayList<>();
		for(String rowKey:rowKeyList){
			Map<String,String> map =HBase.getOneRecord("YIZHU", rowKey);
			maps.add(map);
		}
		List<yizhu> list = yizhu.toYizhuNew(maps);
		return list;
		
	}

}
