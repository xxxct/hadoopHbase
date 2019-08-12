package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JDBC 操作 Hive（注：JDBC 访问 Hive 前需要先启动HiveServer2）
 */
public class HiveJDBC {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String url = "jdbc:hive2://master:10000/default";
    private static String user = "zkpk";
    private static String password = "zkpk";

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    // 加载驱动、创建连接
    @Before
    public void init() throws Exception {
        Class.forName(driverName);
        conn = DriverManager.getConnection(url,user,password);
        stmt = conn.createStatement();
    }

    // 创建数据库
    @Test
    public void createDatabase() throws Exception {
        String sql = "create database hive_jdbc_test";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 查询所有数据库
    @Test
    public void showDatabases() throws Exception {
        String sql = "show databases";
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

    // 创建表
    @Test
    public void createTable() throws Exception {
        String sql = "create table emp(\n" +
                        "empno int,\n" +
                        "ename string,\n" +
                        "job string,\n" +
                        "mgr int,\n" +
                        "hiredate string,\n" +
                        "sal double,\n" +
                        "comm double,\n" +
                        "deptno int\n" +
                        ")\n" +
                     "row format delimited fields terminated by '\\t'";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 查询所有表
    @Test
    public void showTables() throws Exception {
        String sql = "show tables";
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }

    // 查看表结构
    @Test
    public void descTable() throws Exception {
        String sql = "desc emp";
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2));
        }
    }

    // 加载数据
    @Test
    public void loadData() throws Exception {
        String filePath = "/home/hadoop/data/emp.txt";
        String sql = "load data local inpath '" + filePath + "' overwrite into table emp";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 查询数据
    @Test
    public void selectData() throws Exception {
        String sql = "select * from emp";
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        System.out.println("员工编号" + "\t" + "员工姓名" + "\t" + "工作岗位");
        while (rs.next()) {
            System.out.println(rs.getString("empno") + "\t\t" + rs.getString("ename") + "\t\t" + rs.getString("job"));
        }
    }

    // 统计查询（会运行mapreduce作业）
    @Test
    public void countData() throws Exception {
        String sql = "select count(1) from emp";
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt(1) );
        }
    }

    // 删除数据库
    @Test
    public void dropDatabase() throws Exception {
        String sql = "drop database if exists hive_jdbc_test";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 删除数据库表
    @Test
    public void deopTable() throws Exception {
        String sql = "drop table if exists emp";
        System.out.println("Running: " + sql);
        stmt.execute(sql);
    }

    // 释放资源
    @After
    public void destory() throws Exception {
        if ( rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.apache.log4j.Logger;
//
///** 
// * Hive的JavaApi 
// *  
// * 启动hive的远程服务接口命令行执行：hive --service hiveserver & 
// *  
// * @author 汤高 
// *  
// */  
//public class HiveJDBC {  
//    //网上写 org.apache.hadoop.hive.jdbc.HiveDriver ,新版本不能这样写
//    private static String driverName = "org.apache.hive.jdbc.HiveDriver";  
//
//  //这里是hive2，网上其他人都写hive,在高版本中会报错
//    private static String url = "jdbc:hive2://master:10000/default"; 
//    
////    jdbc:mysql://master:3306/hive_21?characterEncoding=UTF-8
//    	
//    
//    private static String user = "zkpk";  
//    private static String password = "zkpk";  
//    private static String sql = "";  
//    private static ResultSet res;  
//    private static final Logger log = Logger.getLogger(HiveJDBC.class);  
//
//    public static void main(String[] args) {  
//        Connection conn = null;  
//        Statement stmt = null;  
//        try {  
//            conn = getConn();  
//            stmt = conn.createStatement();  
//
//            // 第一步:存在就先删除  
//            String tableName = dropTable(stmt);  
//
//            // 第二步:不存在就创建  
//            createTable(stmt, tableName);  
//
//            // 第三步:查看创建的表  
//            showTables(stmt, tableName);  
//
//            // 执行describe table操作  
//            describeTables(stmt, tableName);  
//
//            // 执行load data into table操作  
//            loadData(stmt, tableName);  
//
//            // 执行 select * query 操作  
//            selectData(stmt, tableName);  
//
//            // 执行 regular hive query 统计操作  
//            countData(stmt, tableName);  
//
//        } catch (ClassNotFoundException e) {  
//            e.printStackTrace();  
//            log.error(driverName + " not found!", e);  
//            System.exit(1);  
//        } catch (SQLException e) {  
//            e.printStackTrace();  
//            log.error("Connection error!", e);  
//            System.exit(1);  
//        } finally {  
//            try {  
//                if (conn != null) {  
//                    conn.close();  
//                    conn = null;  
//                }  
//                if (stmt != null) {  
//                    stmt.close();  
//                    stmt = null;  
//                }  
//            } catch (SQLException e) {  
//                e.printStackTrace();  
//            }  
//        }  
//    }  
//
//    private static void countData(Statement stmt, String tableName)  
//            throws SQLException {  
//        sql = "select count(1) from " + tableName;  
//        System.out.println("Running:" + sql);  
//        res = stmt.executeQuery(sql);  
//        System.out.println("执行“regular hive query”运行结果:");  
//        while (res.next()) {  
//            System.out.println("count ------>" + res.getString(1));  
//        }  
//    }  
//
//    private static void selectData(Statement stmt, String tableName)  
//            throws SQLException {  
//        sql = "select * from " + tableName;  
//        System.out.println("Running:" + sql);  
//        res = stmt.executeQuery(sql);  
//        System.out.println("执行 select * query 运行结果:");  
//        while (res.next()) {  
//            System.out.println(res.getInt(1) + "\t" + res.getString(2));  
//        }  
//    }  
//
//    private static void loadData(Statement stmt, String tableName)  
//            throws SQLException {  
//        //目录 ，我的是hive安装的机子的虚拟机的home目录下
//        String filepath = "user.txt";  
//        sql = "load data local inpath '" + filepath + "' into table "  
//                + tableName;  
//        System.out.println("Running:" + sql);  
//         stmt.execute(sql);  
//    }  
//
//    private static void describeTables(Statement stmt, String tableName)  
//            throws SQLException {  
//        sql = "describe " + tableName;  
//        System.out.println("Running:" + sql);  
//        res = stmt.executeQuery(sql);  
//        System.out.println("执行 describe table 运行结果:");  
//        while (res.next()) {  
//            System.out.println(res.getString(1) + "\t" + res.getString(2));  
//        }  
//    }  
//
//    private static void showTables(Statement stmt, String tableName)  
//            throws SQLException {  
//        sql = "show tables '" + tableName + "'";  
//        System.out.println("Running:" + sql);  
//        res = stmt.executeQuery(sql);  
//        System.out.println("执行 show tables 运行结果:");  
//        if (res.next()) {  
//            System.out.println(res.getString(1));  
//        }  
//    }  
//
//    private static void createTable(Statement stmt, String tableName)  
//            throws SQLException {  
//        sql = "create table "  
//                + tableName  
//                + " (key int, value string)  row format delimited fields terminated by '\t'";  
//        stmt.execute(sql);  
//    }  
//
//    private static String dropTable(Statement stmt) throws SQLException {  
//        // 创建的表名  
//        String tableName = "testHive";  
//        sql = "drop table  " + tableName;  
//        stmt.execute(sql);  
//        return tableName;  
//    }  
//
//    private static Connection getConn() throws ClassNotFoundException,  
//            SQLException {  
//        Class.forName(driverName);  
//        Connection conn = DriverManager.getConnection(url, user, password);  
//        return conn;  
//    }  
//
//}  

