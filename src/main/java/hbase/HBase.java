package hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;
import org.apache.hadoop.hbase.thrift.generated.Hbase.AsyncProcessor.append;
import org.apache.hadoop.hbase.util.Bytes;





public class HBase {

//    private static final String TABLE_NAME = "testcase";

      public static Configuration conf = null;
      public HTable table = null;
      public HBaseAdmin admin = null;
      public static String shc = "111111";
      

      static {
//    	  System.out.println("进来了");
        conf = HBaseConfiguration.create();
        System.out.println(conf.get("hbase.zookeeper.quorum"));
//        System.out.println("11111");
      }

      /**
       * 创建一张表
       */
      public static void creatTable(String tableName, String[] familys)
          throws Exception {
        HBaseAdmin admin = new HBaseAdmin(conf);
        if (admin.tableExists(tableName)) {
          System.out.println("table already exists!");
        } else {
          HTableDescriptor tableDesc = new HTableDescriptor(tableName);
          for (int i = 0; i < familys.length; i++) {
            tableDesc.addFamily(new HColumnDescriptor(familys[i]));
          }
          admin.createTable(tableDesc);
          System.out.println("create table " + tableName + " ok.");
        }
      }

      /**
       * 删除表
       */
      public static void deleteTable(String tableName) throws Exception {
        try {
          HBaseAdmin admin = new HBaseAdmin(conf);
          admin.disableTable(tableName);
          admin.deleteTable(tableName);
          System.out.println("delete table " + tableName + " ok.");
        } catch (MasterNotRunningException e) {
          e.printStackTrace();
        } catch (ZooKeeperConnectionException e) {
          e.printStackTrace();
        }
      }

      /**
       * 插入一行记录
       */
      public static void addRecord(String tableName, String rowKey,
          String family, String qualifier, String value) throws Exception {
        try {
          HTable table = new HTable(conf, tableName);
          Put put = new Put(Bytes.toBytes(rowKey));
          put.add(Bytes.toBytes(family), Bytes.toBytes(qualifier),
              Bytes.toBytes(value));
          table.put(put);
          System.out.println("insert recored " + rowKey + " to table "
              + tableName + " ok.");
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      /**
       * 删除一行记录
       */
      public static void delRecord(String tableName, String rowKey)
          throws IOException {
        HTable table = new HTable(conf, tableName);
        List list = new ArrayList();
        Delete del = new Delete(rowKey.getBytes());
        list.add(del);
        table.delete(list);
        System.out.println("del recored " + rowKey + " ok.");
      }

      /**
       * 查找一行记录
       */
      public static Map<String, String> getOneRecord(String tableName, String rowKey)
          throws IOException {
        HTable table = new HTable(conf, tableName);
        Get get = new Get(rowKey.getBytes());
        Result rs = table.get(get);
        Map<String, String> map = new HashMap<String, String>();
        for (KeyValue kv : rs.raw()) {
        	map.put(new String(kv.getQualifier()), new String(kv.getValue()));
//          System.out.print(new String(kv.getRow()) + " ");
//          System.out.print(new String(kv.getFamily()) + ":");
//          System.out.print(new String(kv.getQualifier()) + " ");
//          System.out.print(kv.getTimestamp() + " ");
//          System.out.println();
        }
        return map;
      }
      
      /*病案号 住院号查询*/
      public static List<List> getByRowKey(String tableName, String rowKey){
          List<List> list = new ArrayList<>();
            try{
            	HTable table = new HTable(conf, tableName); 
//                System.out.println("3333");
                Scan scan = new Scan();
                Filter filter2 = new RowFilter(CompareOp.EQUAL,new RegexStringComparator(rowKey+"_.*"));
                scan.setFilter(filter2);
                ResultScanner scanner2 = table.getScanner(scan);
                for (Result r : scanner2) {
                	List<String> inlist = new ArrayList<>();
                    for (KeyValue kv : r.raw()) {                 
                      inlist.add(new String(kv.getQualifier()));
                      inlist.add(new String(kv.getValue()));
//                      System.out.print(new String(kv.getRow()) + " ");
//                      System.out.print(new String(kv.getFamily()) + ":");
//                      System.out.print(new String(kv.getQualifier()) + " ");                
//                      System.out.println(new String(kv.getValue()));                
                    }
                    list.add(inlist);
                  }
                scanner2.close();
            } catch (Exception e){
            	throw new RuntimeException();
            }
            return list;
          }
      
      /** 
     SingleColumnValueFilter和SingleColumnValueExcludeFilter 
          用来查找并返回指定条件的列的数据 
              a，如果查找时没有该列，两种filter都会把该行所有数据返回 
              b，如果查找时有该列，但是不符合条件，则该行所有列都不返回 
              c，如果找到该列，并且符合条件，前者返回所有列，后者返回除该列以外的所有列 
       */  
      public static List<List> SingleColumnValueFilter(String tableName,String column,String str) {  
    	  HTable table;
    	  List<List> list = new ArrayList<>();
    	  try {
			table = new HTable(conf, tableName);
			Scan scan = new Scan();  
	          
	          //完整匹配字节数组  
//	        Filter filter = new SingleColumnValueFilter(Bytes.toBytes("course"), Bytes.toBytes("art"),CompareOp.EQUAL,new BinaryComparator(Bytes.toBytes("90")));  
	          //匹配正则表达式  
//	        Filter filter = new SingleColumnValueFilter(Bytes.toBytes("course"), Bytes.toBytes("art"),CompareOp.EQUAL,new RegexStringComparator("8"));  
	          //匹配是否包含子串,大小写不敏感  
//	        Filter filter = new SingleColumnValueFilter(Bytes.toBytes("course"), Bytes.toBytes("art"),CompareOp.EQUAL,new SubstringComparator("9"));  
	          Filter filter = new SingleColumnValueFilter(Bytes.toBytes("f1"), Bytes.toBytes(column), CompareOp.EQUAL,new SubstringComparator(str));  
	          scan.setFilter(filter);  
	          ResultScanner scanner = table.getScanner(scan);  
	          for (Result r : scanner) { 
	        	  List<String> inlist = new ArrayList<>();
	              for (Cell cell : r.rawCells()) {
	            	  inlist.add(Bytes.toString(CellUtil.cloneQualifier(cell)));
	            	  inlist.add(Bytes.toString(CellUtil.cloneValue(cell)));
//	                  System.out.println(  
//	                          "Rowkey-->"+Bytes.toString(r.getRow())+"  "+  
//	                          "Familiy:Quilifier-->"+Bytes.toString(CellUtil.cloneQualifier(cell))+"  "+  
//	                          "Value-->"+Bytes.toString(CellUtil.cloneValue(cell)));  
	              }  
	              list.add(inlist);
	          }  
	         
			
    	  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    	  }
		
    	  return list;
      }  
      
      
   

      /**
       * 显示所有数据
       */
      public static void getAllRecord(String tableName) {
        try {
          HTable table = new HTable(conf, tableName);
          Scan s = new Scan();
          ResultScanner ss = table.getScanner(s);
          for (Result r : ss) {
            for (KeyValue kv : r.raw()) {
              System.out.print(new String(kv.getRow()) + " ");
              System.out.print(new String(kv.getFamily()) + ":");
              System.out.print(new String(kv.getQualifier()) + " ");
//               
              System.out.println(new String(kv.getValue()));
            }
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      
      
      

 
      
      
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         try {
        	 String tablexcg = "xiechanggui";
        	 String tableyz = "yizhu";
        	 String tableba = "bingli";
         
//              String tablename = "scores";
//              String[] familys = { "grade", "course" };
//              System.out.print(00);
//              HBaseTest.creatTable(tablename, familys);
//              System.out.print(11);
//              // add record zkb
//              HBaseTest.addRecord(tablename, "zkb", "grade", "", "5");
//              HBaseTest.addRecord(tablename, "zkb", "course", "", "91");
//              HBaseTest.addRecord(tablename, "zkb", "course", "math", "97");
//              HBaseTest.addRecord(tablename, "zkb", "course", "art", "87");
//              System.out.print(22);
//              // add record baoniu
//              HBaseTest.addRecord(tablename, "baoniu", "grade", "", "4");
//              HBaseTest.addRecord(tablename, "baoniu", "course", "math", "89");
//
//              System.out.println("===========get one record========");
//              HBaseTest.getOneRecord(tablename, "zkb");
//
//              System.out.println("===========show all record========");
//              HBase.getAllRecord(tablename);
//              HBase.getByRowKey(tablename,"00781274");
//        	    HBase.getByRowKey(tableyz,"11636503");
//        	 HBase.getByRowKey("yizhu","00012411");
//        	    System.out.println("yz");
//        	    HBase.getByRowKey(tablexcg,"11402975");
//        	    System.out.println("xcg");
//        	    HBase.getByRowKey(tableba,"00781178");
//        	    System.out.println("ba");
        	    
//        	    HBase.SingleColumnValueFilter("yizhu","医嘱名称","坦胶囊");
//            
//
//              System.out.println("===========show all record========");
//              HBaseTest.getAllRecord(tablename);
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
}
