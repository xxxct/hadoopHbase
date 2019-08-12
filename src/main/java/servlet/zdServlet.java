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
import mysql.SqlConnection;

import org.apache.phoenix.jdbc.PhoenixDriver;
import org.apache.tephra.TransactionSystemClient;

@WebServlet("/zhenduan")
public class zdServlet extends HttpServlet {

	private static String zhenduan = "";
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");		
		PrintWriter writer = response.getWriter();		
		String input =  request.getParameter("input");
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
//		System.out.println("搜索:"+input);
//		System.out.println("offset:"+offset);
//		System.out.println("pageNum:"+pageNum);
//		System.out.println("pageSize:"+pageSize);
		byte[] tmp = input.getBytes("ISO8859_1");
		input = new String(tmp, "UTF-8");
		String [] arr = input.split(",");
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
		}
	}

		
	
	



