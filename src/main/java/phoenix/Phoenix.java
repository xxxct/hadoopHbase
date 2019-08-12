package phoenix;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jruby.RubyProcess.Sys;



public class Phoenix {
	public static Connection con = null;

	static{		
			try {
				Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
				con = DriverManager.getConnection("jdbc:phoenix:10.60.38.108");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public static List<String> BAzhenDuan(String search,String inTime,String outTime,String pageszie,String offset) throws SQLException{
		String sqlString = "select \"hbase_row_key\" from bingan";
		List<String> list = new ArrayList<>();
		if(!search.isEmpty() || !inTime.isEmpty() || !outTime.isEmpty())
			sqlString += " where";
		if(!search.isEmpty()){
			sqlString += " (\"f1\".\"门诊诊断名称\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"出院诊断名称\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称1\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称2\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称3\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称4\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称5\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称6\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称7\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称8\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称9\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称10\" like \'%"+search+"%\')";
		}
		if(!inTime.isEmpty()){
			if(!search.isEmpty()){
				sqlString +=" and TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}else{
				sqlString +=" TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}		
		}
		if(!outTime.isEmpty()){
			if(search.isEmpty() && inTime.isEmpty()){
				sqlString +=" TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}else{
				sqlString +=" and TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}
		}
		sqlString += " limit "+pageszie+" offset "+offset;
//		System.out.print(sqlString);
		PreparedStatement statement = con.prepareStatement(sqlString);
		ResultSet rset = statement.executeQuery();
		while (rset.next()){
			list.add(rset.getString("hbase_row_key"));
//			System.out.println(rset.getString("hbase_row_key"));
		}
		return list;
	}
	
	public static List<String> BAzhenDuanMul(String [] search,String inTime,String outTime,String pageszie,String offset) throws SQLException{
		String sqlString = "select \"hbase_row_key\" from bingan where";
		List<String> list = new ArrayList<>();
			sqlString += " SUBSTR(\"hbase_row_key\",0,8) in";
			sqlString += " (select SUBSTR(\"hbase_row_key\",0,8) from bingan where";
			sqlString += " \"f1\".\"门诊诊断名称\" like \'%"+search[0]+"%\' or";
			sqlString += " \"f1\".\"出院诊断名称\" like \'%"+search[0]+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称1\" like \'%"+search[0]+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称2\" like \'%"+search[0]+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称3\" like \'%"+search[0]+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称4\" like \'%"+search[0]+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称5\" like \'%"+search[0]+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称6\" like \'%"+search[0]+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称7\" like \'%"+search[0]+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称8\" like \'%"+search[0]+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称9\" like \'%"+search[0]+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称10\" like \'%"+search[0]+"%\')";
			
			for(int i = 1; i < search.length; i++ ){
				sqlString += " and SUBSTR(\"hbase_row_key\",0,8) in";
				sqlString += " (select SUBSTR(\"hbase_row_key\",0,8) from bingan where";
				sqlString += " \"f1\".\"门诊诊断名称\" like \'%"+search[1]+"%\' or";
				sqlString += " \"f1\".\"出院诊断名称\" like \'%"+search[1]+"%\' or";
				sqlString += " \"f1\".\"其他诊断名称1\" like \'%"+search[1]+"%\' or";
				sqlString += " \"f1\".\"其他诊断名称2\" like \'%"+search[1]+"%\' or";
				sqlString += " \"f1\".\"其他诊断名称3\" like \'%"+search[1]+"%\' or";
				sqlString += " \"f1\".\"其他诊断名称4\" like \'%"+search[1]+"%\' or";
				sqlString += " \"f1\".\"其他诊断名称5\" like \'%"+search[1]+"%\' or";
				sqlString += " \"f1\".\"其他诊断名称6\" like \'%"+search[1]+"%\' or";
				sqlString += " \"f1\".\"其他诊断名称7\" like \'%"+search[1]+"%\' or";
				sqlString += " \"f1\".\"其他诊断名称8\" like \'%"+search[1]+"%\' or";
				sqlString += " \"f1\".\"其他诊断名称9\" like \'%"+search[1]+"%\' or";
				sqlString += " \"f1\".\"其他诊断名称10\" like \'%"+search[1]+"%\')";
			}

		if(!inTime.isEmpty()){
				sqlString +=" and TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";	
		}
		if(!outTime.isEmpty()){
				sqlString +=" and TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
		}
		sqlString += " limit "+pageszie+" offset "+offset;
		System.out.print(sqlString);
		PreparedStatement statement = con.prepareStatement(sqlString);
		ResultSet rset = statement.executeQuery();
		while (rset.next()){
			list.add(rset.getString("hbase_row_key"));
		}
		return list;
	}
	
	public static List<String> BAzhenDuan_1(String search,String inTime,String outTime) throws SQLException{
		String sqlString = "select \"hbase_row_key\" from bingan";
		List<String> list = new ArrayList<>();
		if(!search.isEmpty() || !inTime.isEmpty() || !outTime.isEmpty())
			sqlString += " where";
		if(!search.isEmpty()){
			sqlString += " (\"f1\".\"门诊诊断名称\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"出院诊断名称\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称1\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称2\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称3\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称4\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称5\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称6\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称7\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称8\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称9\" like \'%"+search+"%\' or";
			sqlString += " \"f1\".\"其他诊断名称10\" like \'%"+search+"%\')";
		}
		if(!inTime.isEmpty()){
			if(!search.isEmpty()){
				sqlString +=" and TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}else{
				sqlString +=" TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}		
		}
		if(!outTime.isEmpty()){
			if(search.isEmpty() && inTime.isEmpty()){
				sqlString +=" TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}else{
				sqlString +=" and TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}
		}
//		System.out.print(sqlString);
		PreparedStatement statement = con.prepareStatement(sqlString);
		ResultSet rset = statement.executeQuery();
		while (rset.next()){
			list.add(rset.getString("hbase_row_key"));
//			System.out.println(rset.getString("hbase_row_key"));
		}
		return list;
	}
	
	
	public static List<String> BAbingAn(String search,String inTime,String outTime,String pageszie,String offset) throws SQLException{
		String sqlString = "select \"hbase_row_key\" from bingan";
		List<String> list = new ArrayList<>();
		if(!search.isEmpty() || !inTime.isEmpty() || !outTime.isEmpty())
			sqlString += " where";
		if(!search.isEmpty()){
			sqlString +=" \"f1\".\"病案号\"=\'"+search+"\'";
		}
		if(!inTime.isEmpty()){
			if(!search.isEmpty()){
				sqlString +=" and TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}else{
				sqlString +=" TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}		
		}
		if(!outTime.isEmpty()){
			if(search.isEmpty() && inTime.isEmpty()){
				sqlString +=" TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}else{
				sqlString +=" and TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}
		}
		if(pageszie.length()!=0 && offset.length()!=0){
			sqlString += " limit "+pageszie+" offset "+offset;
		}
//		System.out.print(sqlString);
		PreparedStatement statement = con.prepareStatement(sqlString);
		ResultSet rset = statement.executeQuery();
		while (rset.next()){
			list.add(rset.getString("hbase_row_key"));
//			System.out.println(rset.getString("hbase_row_key"));
		}
		return list;
	}
	
	public static List<String> BAzhuYuan(String search,String inTime,String outTime,String pageszie,String offset) throws SQLException{
		String str = "select \"f1\".\"病案号\" from \"xiechanggui\" where \"f1\".\"住院号\"=\'"+search+"\' limit 1";
		PreparedStatement stmt = con.prepareStatement(str);
		ResultSet rs = stmt.executeQuery();
		String bingAn = "";
		while(rs.next()){
			bingAn = rs.getString("病案号");
		}		 
//		System.out.println("病案号为"+bingAn);		
		String sqlString = "select \"hbase_row_key\" from bingan";
		
		List<String> list = new ArrayList<>();
		if(bingAn.length()!=0){
			if(!bingAn.isEmpty() || !inTime.isEmpty() || !outTime.isEmpty())
				sqlString += " where";
			if(!bingAn.isEmpty()){
				sqlString +=" \"f1\".\"病案号\"=\'"+bingAn+"\'";
			}
			if(!inTime.isEmpty()){
				if(!bingAn.isEmpty()){
					sqlString +=" and TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
				}else{
					sqlString +=" TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
				}		
			}
			if(!outTime.isEmpty()){
				if(bingAn.isEmpty() && inTime.isEmpty()){
					sqlString +=" TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
				}else{
					sqlString +=" and TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
				}
			}
			sqlString += " limit "+pageszie+" offset "+offset;
//			System.out.print(sqlString);
			PreparedStatement statement = con.prepareStatement(sqlString);
			ResultSet rset = statement.executeQuery();
			while (rset.next()){
				list.add(rset.getString("hbase_row_key"));
//				System.out.println(rset.getString("hbase_row_key"));
			}
			
		}
		
		return list;
	}
	
	public static List<String> BAname(String search,String inTime,String outTime,String pageszie,String offset) throws SQLException{
		String sqlString = "select \"hbase_row_key\" from bingan";
		List<String> list = new ArrayList<>();
		if(!search.isEmpty() || !inTime.isEmpty() || !outTime.isEmpty())
			sqlString += " where";
		if(!search.isEmpty()){
			sqlString +=" \"f1\".\"姓名\"=\'"+search+"\'";
		}
		if(!inTime.isEmpty()){
			if(!search.isEmpty()){
				sqlString +=" and TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}else{
				sqlString +=" TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}		
		}
		if(!outTime.isEmpty()){
			if(search.isEmpty() && inTime.isEmpty()){
				sqlString +=" TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}else{
				sqlString +=" and TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}
		}
		sqlString += " limit "+pageszie+" offset "+offset;
//		System.out.print(sqlString);
		PreparedStatement statement = con.prepareStatement(sqlString);
		ResultSet rset = statement.executeQuery();
		while (rset.next()){
			list.add(rset.getString("hbase_row_key"));
//			System.out.println(rset.getString("hbase_row_key"));
		}
		return list;
	}
	
	public static List<String> XCGzhuYuan(String search,String inTime,String outTime,String pageszie,String offset) throws SQLException{
		String sqlString = "select \"hbase_row_key\" from \"xiechanggui\"";
		List<String> list = new ArrayList<>();
		if(!search.isEmpty() || !inTime.isEmpty() || !outTime.isEmpty())
			sqlString += " where";
		if(!search.isEmpty()){
			sqlString +=" \"f1\".\"住院号\"=\'"+search+"\'";
		}
		if(!inTime.isEmpty()){
			if(!search.isEmpty()){
				sqlString +=" and TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}else{
				sqlString +=" TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}		
		}
		if(!outTime.isEmpty()){
			if(search.isEmpty() && inTime.isEmpty()){
				sqlString +=" TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}else{
				sqlString +=" and TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}
		}
		sqlString += " limit "+pageszie+" offset "+offset;
//		System.out.print(sqlString);
		PreparedStatement statement = con.prepareStatement(sqlString);
		ResultSet rset = statement.executeQuery();
		while (rset.next()){
			list.add(rset.getString("hbase_row_key"));
//			System.out.println(rset.getString("hbase_row_key"));
		}
		return list;
	}
	
	public static List<String> XCGname(String search,String inTime,String outTime,String pageszie,String offset) throws SQLException{
		String sqlString = "select \"hbase_row_key\" from \"xiechanggui\"";
		List<String> list = new ArrayList<>();
		if(!search.isEmpty() || !inTime.isEmpty() || !outTime.isEmpty())
			sqlString += " where";
		if(!search.isEmpty()){
			sqlString +=" \"f1\".\"姓名\"=\'"+search+"\'";
		}
		if(!inTime.isEmpty()){
			if(!search.isEmpty()){
				sqlString +=" and TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}else{
				sqlString +=" TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}		
		}
		if(!outTime.isEmpty()){
			if(search.isEmpty() && inTime.isEmpty()){
				sqlString +=" TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}else{
				sqlString +=" and TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}
		}
		sqlString += " limit "+pageszie+" offset "+offset;
//		System.out.print(sqlString);
		PreparedStatement statement = con.prepareStatement(sqlString);
		ResultSet rset = statement.executeQuery();
		while (rset.next()){
			list.add(rset.getString("hbase_row_key"));
//			System.out.println(rset.getString("hbase_row_key"));
		}
		return list;
	}
	
	public static List<String> YZzhuYuan(String search,String inTime,String outTime,String pageszie,String offset) throws SQLException{
		String sqlString = "select \"hbase_row_key\" from yizhu";
		List<String> list = new ArrayList<>();
		if(!search.isEmpty() || !inTime.isEmpty() || !outTime.isEmpty())
			sqlString += " where";
		if(!search.isEmpty()){
			sqlString +=" \"f1\".\"住院号\"=\'"+search+"\'";
		}
		if(!inTime.isEmpty()){
			if(!search.isEmpty()){
				sqlString +=" and TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}else{
				sqlString +=" TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}		
		}
		if(!outTime.isEmpty()){
			if(search.isEmpty() && inTime.isEmpty()){
				sqlString +=" TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}else{
				sqlString +=" and TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}
		}
		sqlString += " limit "+pageszie+" offset "+offset;
//		System.out.print(sqlString);
		PreparedStatement statement = con.prepareStatement(sqlString);
		ResultSet rset = statement.executeQuery();
		while (rset.next()){
			list.add(rset.getString("hbase_row_key"));
//			System.out.println(rset.getString("hbase_row_key"));
		}
		return list;
	}
	
	public static List<String> YZname(String search,String inTime,String outTime,String pageszie,String offset) throws SQLException{
		String sqlString = "select \"hbase_row_key\" from yizhu";
		List<String> list = new ArrayList<>();
		if(!search.isEmpty() || !inTime.isEmpty() || !outTime.isEmpty())
			sqlString += " where";
		if(!search.isEmpty()){
			sqlString +=" \"f1\".\"姓名\"=\'"+search+"\'";
		}
		if(!inTime.isEmpty()){
			if(!search.isEmpty()){
				sqlString +=" and TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}else{
				sqlString +=" TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}		
		}
		if(!outTime.isEmpty()){
			if(search.isEmpty() && inTime.isEmpty()){
				sqlString +=" TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}else{
				sqlString +=" and TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}
		}
		sqlString += " limit "+pageszie+" offset "+offset;
//		System.out.print(sqlString);
		PreparedStatement statement = con.prepareStatement(sqlString);
		ResultSet rset = statement.executeQuery();
		while (rset.next()){
			list.add(rset.getString("hbase_row_key"));
//			System.out.println(rset.getString("hbase_row_key"));
		}
		return list;
	}
	
	public static List<String> YZyzmc(String search,String inTime,String outTime,String pageszie,String offset) throws SQLException{
		String sqlString = "select \"hbase_row_key\" from yizhu";
		List<String> list = new ArrayList<>();
		if(!search.isEmpty() || !inTime.isEmpty() || !outTime.isEmpty())
			sqlString += " where";
		if(!search.isEmpty()){
			sqlString +=" \"f1\".\"医嘱名称\" like \'%"+search+"%\'";
		}
		if(!inTime.isEmpty()){
			if(!search.isEmpty()){
				sqlString +=" and TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}else{
				sqlString +=" TO_DATE(\"f1\".\"入院日期\") > TO_DATE(\'"+inTime+"\')";
			}		
		}
		if(!outTime.isEmpty()){
			if(search.isEmpty() && inTime.isEmpty()){
				sqlString +=" TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}else{
				sqlString +=" and TO_DATE(\"f1\".\"出院日期\") < TO_DATE(\'"+outTime+"\')";
			}
		}
		sqlString += " limit "+pageszie+" offset "+offset;
//		System.out.print(sqlString);
		PreparedStatement statement = con.prepareStatement(sqlString);
		ResultSet rset = statement.executeQuery();
		while (rset.next()){
			list.add(rset.getString("hbase_row_key"));
//			System.out.println(rset.getString("hbase_row_key"));
		}
		return list;
	}
	
	public static void main(String[] args) throws SQLException {
		BAzhenDuan("贫血", "2014-9-10", "2014-10-10", "10", "10");
//		Statement stmt = con.createStatement();
//		stmt.executeUpdate("create table test (mykey integer not null primary key, mycolumn varchar)");
//		stmt.executeUpdate("upsert into test values (1,'Hello')");
//		stmt.executeUpdate("upsert into test values (2,'World!')");
//		con.commit();
//		
//		PreparedStatement statement = con.prepareStatement("select * from test");
//		ResultSet rset = statement.executeQuery();
//		while (rset.next()) {
//			System.out.println(rset.getString("mycolumn"));
//		}
//		statement.close();
//		con.close();
	}
}
