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

import json.data;
import json.gridResult;
import json.jsonData;
import json.returnData;
import json.values;
import Process.processData;
import Process.processDataNew;
import bean.BingAn;
import bean.Person;
import bean.xiechanggui;
import bean.yizhu;

import com.alibaba.fastjson.JSON;
import com.sun.javadoc.SeeTag;

import phoenix.Phoenix;
import mysql.SqlConnection;

import org.apache.phoenix.jdbc.PhoenixDriver;
import org.apache.tephra.TransactionSystemClient;

@WebServlet("/initZhenDuan")
public class initZdServlet extends HttpServlet {

	private static String zhenduan = "";
	public static String getZhenduan() {
		return zhenduan;
	}
	public static void setZhenduan(String zhenduan) {
		initZdServlet.zhenduan = zhenduan;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");		
		PrintWriter writer = response.getWriter();	
		//返回空list
		List nullList = new ArrayList<>();
		JSON nulljson= (JSON) JSON.toJSON(nullList);
		
		String pageNumber = request.getParameter("pageNumber");
//		String pageSize  = request.getParameter("pageSize ");
		String name  = request.getParameter("name");
		int num = Integer.parseInt(pageNumber);
		if(!initZdServlet.getZhenduan().equals(name)){
			num = 1;
			initZdServlet.setZhenduan(name);
		}
		int size = 10;
		int start = (num-1)*size;
				List<String> list = new ArrayList<>();
				List<data> result = new ArrayList<>();
				  try {					
					list = SqlConnection.searchZhenduan(name,start,size);					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				  jsonData jsonData = new jsonData();
				  values values = new values();
				  gridResult gR = new gridResult();
				  for(int i = 0; i < list.size(); i++){
					  data oneData = new data();
					  oneData.setId(String.valueOf(i+1));
					  oneData.setName(list.get(i));
					  result.add(oneData);
				  }
				  gR.setList(result);
				  try {
					gR.setTotalRow(SqlConnection.zhenDuanNum(name));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				  values.setGridResult(gR);
				  jsonData.setValues(values);
				  JSON json= (JSON) JSON.toJSON(jsonData);
				  writer.write(json.toString());
				
	}
	
}


