package servlet;

import hbase.HBase;
import Process.processDataNew;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Process.processData;
import Process.processDataNew;
import bean.BingAn;
import bean.Person;
import bean.xiechanggui;
import bean.yizhu;

import com.alibaba.fastjson.JSON;
import com.sun.javadoc.SeeTag;

import phoenix.Phoenix;

import org.apache.phoenix.jdbc.PhoenixDriver;
import org.apache.tephra.TransactionSystemClient;

@WebServlet("/queryAll")
public class QueryAllServlet extends HttpServlet {
	
	private static final int Person = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");		
		PrintWriter writer = response.getWriter();
		String select = request.getParameter("select");
		String input = request.getParameter("input");
		String type = request.getParameter("type");
		String inTime = request.getParameter("inDate");
		String outTime = request.getParameter("outDate");
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		int num = Integer.parseInt(pageNum);
		int size = Integer.parseInt(pageSize);
		int offset = size*(num - 1);
		//返回空list
		List nullList = new ArrayList<>();
		JSON nulljson= (JSON) JSON.toJSON(nullList);		
		//查询病案首页
		System.out.println("类型:"+type);
		System.out.println("选择:"+select);
		System.out.println("搜索:"+input);
		System.out.println("offset:"+offset);
		if(type.equals("bingAn")){
			if(select.equals("zhenDuan")){
				byte[] tmp = input.getBytes("ISO8859_1");
				input = new String(tmp, "UTF-8");
				//输入多个词用空格分隔
				String [] arr = input.split("\\s+");
				for(String ss : arr){
				    System.out.println(ss);
				}
				if(arr.length == 1){
					try {
					input = arr[0];
					List<String> rowKeyList = Phoenix.BAzhenDuan(input, inTime, outTime, pageSize, Integer.toString(offset));
					if(!rowKeyList.isEmpty()){
						List<BingAn> list = processDataNew.baResultToHbase(rowKeyList);
						JSON json= (JSON) JSON.toJSON(list);
						writer.write(json.toString());
					}else{
						writer.write(nulljson.toString());
					}
				} catch (SQLException e) {				
					e.printStackTrace();
				}
				}else{
					try {
						List<String> rowKeyList = Phoenix.BAzhenDuanMul(arr, inTime, outTime, pageSize, Integer.toString(offset));
						if(!rowKeyList.isEmpty()){
							List<BingAn> list = processDataNew.baResultToHbase(rowKeyList);
							JSON json= (JSON) JSON.toJSON(list);
							writer.write(json.toString());
						}else{
							writer.write(nulljson.toString());
						}			
					} catch (SQLException e) {
						e.printStackTrace();
					}

//					try{
//						List<String> list = new ArrayList<String>();
//						list = Phoenix.BAzhenDuan_1(arr[0], inTime, outTime);	
//						
//						HashSet<String> set = new HashSet<String>();
//						HashSet<String> set_1 = new HashSet<String>();
//						List<String> rowKeyList = new ArrayList<String>();
//						for(String rowKey:list){
//							set.add(rowKey.substring(0,8));
//						}
//					   
//						
//						for(int i = 1; i < arr.length; i++ ){
//							
//								list = Phoenix.BAzhenDuan_1(arr[i], inTime, outTime);
//								for (int j=0;j<list.size();j++) {
//						            String value = list.get(j).substring(0,8);
//						              if (set.contains(value)) {
//						            	  set_1.add(value);
//						            }     
//						        }
//								set.clear();
//								for(String str:set_1){
//									set.add(str);
//								}
//								set_1.clear();							
//						}
//						
//						for (String string : set){
//							
//							rowKeyList.addAll(Phoenix.BAbingAn(string, inTime, outTime, "", ""));
//						}	
//						
//						List<String> newRowKeyList = new ArrayList<>();
//						for(int i = offset; i < rowKeyList.size() && i < (offset+size); i++){
//							newRowKeyList.add(rowKeyList.get(i));
//						}
//						if(!newRowKeyList.isEmpty()){
//							List<BingAn> result = processDataNew.baResultToHbase(newRowKeyList);
//							JSON json= (JSON) JSON.toJSON(result);
//							writer.write(json.toString());
//						}else{
//							writer.write(nulljson.toString());
//				        }	
//					} catch (SQLException e) {
//							e.printStackTrace();
//					  }
				}
			}
			if(select.equals("bingAn")){
				try {
					List<String> rowKeyList = Phoenix.BAbingAn(input, inTime, outTime, pageSize, Integer.toString(offset));
					if(!rowKeyList.isEmpty()){
						List<BingAn> list = processDataNew.baResultToHbase(rowKeyList);
						JSON json= (JSON) JSON.toJSON(list);
						writer.write(json.toString());
					}else{
						writer.write(nulljson.toString());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if(select.equals("zhuYuan")){
				try {
					List<String> rowKeyList = Phoenix.BAzhuYuan(input, inTime, outTime, pageSize, Integer.toString(offset));
					if(!rowKeyList.isEmpty()){
						List<BingAn> list = processDataNew.baResultToHbase(rowKeyList);
						JSON json= (JSON) JSON.toJSON(list);
						writer.write(json.toString());
					}else{
						writer.write(nulljson.toString());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			if(select.equals("name")){
				try {
					System.out.println("搜索:"+input);
					byte[] tmp = input.getBytes("ISO8859_1");
					input = new String(tmp, "UTF-8");
					List<String> rowKeyList = Phoenix.BAname(input, inTime, outTime, pageSize, Integer.toString(offset));
					if(!rowKeyList.isEmpty()){
						
						List<BingAn> list = processDataNew.baResultToHbase(rowKeyList);
						JSON json= (JSON) JSON.toJSON(list);
						writer.write(json.toString());
					}else{
						writer.write(nulljson.toString());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
//			if(select.equals("zhuYuan")){
////				List<yizhu> yzList = processData.yizhuSearchByZhuYuan("yizhu", input);			
//				List<xiechanggui> xcgList = processData.xcgSearchByColumn("xiechanggui","住院号",input);
//				List<BingAn> list = new ArrayList<>();
//				if(!xcgList.isEmpty()){
//					String bingAnNumString = xcgList.get(0).getBingAnNum();
//					list = processData.bingAnSearchByBingAn("bingli",bingAnNumString);
//				}				
//				JSON json= (JSON) JSON.toJSON(list);
//				writer.write(json.toString());			
//			}
//			if(select.equals("name")){
//				byte[] tmp = input.getBytes("ISO8859_1");
//				input = new String(tmp, "UTF-8");	
//				List<BingAn> list = processData.bingAnSearchByColumn("bingli","姓名",input);
//				JSON json= (JSON) JSON.toJSON(list);
//				writer.write(json.toString());	
//			}
//			if(select.equals("illness")){
////				byte[] tmp = input.getBytes("ISO8859_1");
////				input = new String(tmp, "UTF-8");	
////				List<BingAn> list = processData.bingAnSearchByColumn("bingli","姓名",input);
////				JSON json= (JSON) JSON.toJSON(list);
////				writer.write(json.toString());	
//			}
		}
		
		if(type.equals("xcg")){
			if(select.equals("zhuYuan")){
				try {
					List<String> rowKeyList = Phoenix.XCGzhuYuan(input, inTime, outTime, pageSize, Integer.toString(offset));
					if(!rowKeyList.isEmpty()){
						List<xiechanggui> list = processDataNew.xcgResultToHbase(rowKeyList);
						JSON json= (JSON) JSON.toJSON(list);
						writer.write(json.toString());
					}else{
						writer.write(nulljson.toString());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
			if(select.equals("name")){
				try {
					byte[] tmp = input.getBytes("ISO8859_1");
					input = new String(tmp, "UTF-8");
					List<String> rowKeyList = Phoenix.XCGname(input, inTime, outTime, pageSize, Integer.toString(offset));
					if(!rowKeyList.isEmpty()){
						List<xiechanggui> list = processDataNew.xcgResultToHbase(rowKeyList);
						JSON json= (JSON) JSON.toJSON(list);
						writer.write(json.toString());
					}else{
						writer.write(nulljson.toString());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}		
				
			}
		}
		
		if(type.equals("yizhu")){
			if(select.equals("zhuYuan")){
				try {
					List<String> rowKeyList = Phoenix.YZzhuYuan(input, inTime, outTime, pageSize, Integer.toString(offset));
					if(!rowKeyList.isEmpty()){
						List<yizhu> list = processDataNew.yzResultToHbase(rowKeyList);
						JSON json= (JSON) JSON.toJSON(list);
						writer.write(json.toString());
					}else{
						writer.write(nulljson.toString());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}			
			}
			if(select.equals("name")){
				try {
					byte[] tmp = input.getBytes("ISO8859_1");
					input = new String(tmp, "UTF-8");
					List<String> rowKeyList = Phoenix.YZname(input, inTime, outTime, pageSize, Integer.toString(offset));
					if(!rowKeyList.isEmpty()){
						List<yizhu> list = processDataNew.yzResultToHbase(rowKeyList);
						JSON json= (JSON) JSON.toJSON(list);
						writer.write(json.toString());
					}else{
						writer.write(nulljson.toString());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}			
				
			}
			if(select.equals("yizhu")){
				try {
					byte[] tmp = input.getBytes("ISO8859_1");
					input = new String(tmp, "UTF-8");
					List<String> rowKeyList = Phoenix.YZyzmc(input, inTime, outTime, pageSize, Integer.toString(offset));
					if(!rowKeyList.isEmpty()){
						List<yizhu> list = processDataNew.yzResultToHbase(rowKeyList);
						JSON json= (JSON) JSON.toJSON(list);
						writer.write(json.toString());
					}else{
						writer.write(nulljson.toString());
					}
					} catch (SQLException e) {				
					e.printStackTrace();
				}
				
			}
			
		}
//		
//		if(type.equals("xcg")){
//			if(select.equals("zhuYuan")){
//				List<xiechanggui> xcgList = processData.xcgSearchByZhuYuan("xiechanggui", input);
//				JSON json= (JSON) JSON.toJSON(xcgList);
//				writer.write(json.toString());
//			}
//			if(select.equals("name")){
//				byte[] tmp = input.getBytes("ISO8859_1");
//				input = new String(tmp, "UTF-8");	
//				List<xiechanggui> list = processData.xcgSearchByColumn("xiechanggui", "姓名", input);
//				JSON json= (JSON) JSON.toJSON(list);
//				writer.write(json.toString());
//				
//			}
//		}
//		
//		if(type.equals("yizhu")){
//			System.out.println("type");
//			System.out.println("input");
//			if(select.equals("zhuYuan")){
//				List<yizhu> list = processData.yizhuSearchByZhuYuan("yizhu", input);
//				JSON json= (JSON) JSON.toJSON(list);
//				writer.write(json.toString());
//			}
//			if(select.equals("name")){
//				byte[] tmp = input.getBytes("ISO8859_1");
//				input = new String(tmp, "UTF-8");	
//				List<yizhu> list = processData.yizhuSearchByColumn("yizhu","姓名", input);
//				JSON json= (JSON) JSON.toJSON(list);
//				writer.write(json.toString());
//			}
//			if(select.equals("yizhu")){
//				byte[] tmp = input.getBytes("ISO8859_1");
//				input = new String(tmp, "UTF-8");	
//				List<yizhu> list = processData.yizhuSearchByColumn("yizhu","医嘱名称", input);
//				JSON json= (JSON) JSON.toJSON(list);
//				writer.write(json.toString());
//			}
//			
//		}

		

	}
 
	
	}



