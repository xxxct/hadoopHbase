package mysql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jruby.RubyProcess.Sys;
import org.jruby.compiler.ir.operands.Array;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SqlConnection {
	//这里是SqlConnection 类
	 
			/*
			*java连接mysql数据库
			*1、加载驱动程序
			*2、数据库连接字符串"jdbc:mysql://localhost:3306/数据库名?"
			*3、数据库登录名
			*3、数据库登录密码
			*/
	 
	    private static final String URL="jdbc:mysql://10.60.38.108:3306/ill?useUnicode=true&characterEncoding=utf8";//数据库连接字符串，这里的deom为数据库名
	    private static final String NAME="root";//登录名
	    private static final String PASSWORD="root";//密码
	    private static Connection conn = null;

		
		public static List<String> searchZhenduan(String xxx,int start,int size) throws SQLException{ 
	       
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("未能成功加载驱动程序，请检查是否导入驱动程序！");
			}
			conn = (Connection) DriverManager.getConnection(URL, NAME, PASSWORD);
		    List<String> list = new ArrayList<>();
//		    String sql ="select * from zhenduan where zhenduan like '%"+xxx+"%' ORDER BY CONVERT(zhenduan USING gbk) ASC limit "+start+","+size;	
		    String sql ="select * from zhenduan ";
		    if(!(xxx == null)){
		    	sql +="where zhenduan like '%"+xxx+"%' ";
		    }
		    sql+= "ORDER BY CONVERT(zhenduan USING gbk) ASC limit "+start+","+size;
		    PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		    ResultSet rs = ptmt.executeQuery(); 
		    while(rs.next()){ 
			  list.add(rs.getString("zhenduan"));		
		    }
		    if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					conn=null;
				}
			 }
		    return list;    
		} 
		
		public static int zhenDuanNum(String xxx) throws SQLException{ 		       
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("未能成功加载驱动程序，请检查是否导入驱动程序！");
			}
			conn = (Connection) DriverManager.getConnection(URL, NAME, PASSWORD);
		    int result = 0;
		    String sql ="select count(*) from zhenduan "; 
		    if(!(xxx == null)){
		    	sql +="where zhenduan like '%"+xxx+"%' ";
		    }
		    PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql); 			    
		    ResultSet rs = ptmt.executeQuery(); 
		    while(rs.next())
		    	result = rs.getInt(1);    
		    if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					conn=null;
				}
			 }
		    return result;    
		} 
		public static void main(String[] args) {
			// TODO 自动生成的方法存根
//			  List<String> list = new ArrayList<>();
//			  try {
//				list = searchZhenduan("1",1,10);
//				for(int i = 0 ; i < list.size(); i++)
//					System.out.println(list.get(i));
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		

			  
		}
	}

