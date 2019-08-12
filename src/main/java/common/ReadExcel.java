package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import csv.CSVUtils;

public class ReadExcel {
    public static void main(String[] args) {
    	
        ReadExcel obj = new ReadExcel();
        // 此处为我创建Excel路径
        File file = new File("E:/2017yizhu");
        File[] array = file.listFiles();  
        for(int v = 0; v < array.length; v++){
        	List finalList = obj.readExcel(array[v]);
            for(int i = 0; i < finalList.size(); i++){
            	
            	List<String> dataList=new ArrayList<String>();
            	List excelList = (List) finalList.get(i);
        		for(int j = 0; j < excelList.size(); j++){
        			String str="";
        			List list = (List) excelList.get(j);
        			for(int k = 0; k < list.size(); k++){
//        				System.out.print(list.get(k));
        				str = str + list.get(k);
        				
        				
        			}
        			dataList.add(str);
//        			System.out.println();
        		}
            boolean isSuccess=CSVUtils.exportCsv(new File("E:/yizhucsv/"+array[v].getName().substring(0,array[v].getName().indexOf("."))+"_"+i+".csv"), dataList);
            }
        }
        
    
        System.out.println("已完成");
        
        
//        List excelList = obj.readExcel(file);
//        for (int i = 0; i < excelList.size(); i++) {
//            List list = (List) excelList.get(i);
//            for (int j = 0; j < list.size(); j++) {
////                System.out.print(list.get(j));
//                str = str + list.get(j);
//            }
////            System.out.print(str);
//            dataList.add(str);
//            str="";
////            System.out.println();
//        }
//        boolean isSuccess=CSVUtils.exportCsv(new File("E:/2017yizhu/201701.csv"), dataList);
//        System.out.println(isSuccess);
       
    }

    
    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public List readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            
            int sheet_size = wb.getNumberOfSheets();
            
            List<List> finalList = new ArrayList<List>();
            for (int index = 0; index < sheet_size; index++) {  
//            	System.out.print("第"+index+"页:");
            	List<List> outerList=new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                jxl.Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
//                	System.out.println(i+"行 ");
                    List innerList=new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {                    	
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(j!=0){
	                        if(cellinfo.isEmpty()){
	                        	if(j != sheet.getColumns()-1){
	                        		innerList.add("|");
	                        	}else{
	                        		continue;
	                        	}
	                        	
	                        }else{
	                        	if(j != sheet.getColumns()-1){
//	                        		System.out.println(cellinfo);
	                        		innerList.add(cellinfo+"|");
	                        	}else{
	                        		innerList.add(cellinfo);
	                        	}
	                        	
	                        }
                        }else{
                        	innerList.add("|");
                        }
                     
//                        System.out.print(cellinfo);
                    }
                    outerList.add(i, innerList);
//                    System.out.println();
                }
                finalList.add(outerList);
                
            }
            return finalList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
