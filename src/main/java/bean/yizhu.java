package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class yizhu {
	
	public String status = "yz";
	
	private String name;
	
	private String sex;
	
	private String age;
	
	private String zhuYuanNum; 
	
	private String inDate;
	
	private String outDate;
	
	private String outKeShi;
	
	
	private String yizhuName;
	
	private String startTime;
	
	private String endTime;
	
	private String frequency;
	
	private String docName;
	
	private String specification;
	
	private String measureUnit;
	
	private String useLevel;
	
	

	public yizhu() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getZhuYuanNum() {
		return zhuYuanNum;
	}

	public void setZhuYuanNum(String zhuYuanNum) {
		this.zhuYuanNum = zhuYuanNum;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getOutKeShi() {
		return outKeShi;
	}

	public void setOutKeShi(String outKeShi) {
		this.outKeShi = outKeShi;
	}



	public String getYizhuName() {
		return yizhuName;
	}

	public void setYizhuName(String yizhuName) {
		this.yizhuName = yizhuName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getUseLevel() {
		return useLevel;
	}

	public void setUseLevel(String useLevel) {
		this.useLevel = useLevel;
	}
	
	public static List<yizhu> toYizhu(List<List> list){
		List<yizhu> result = new ArrayList();
		if(list!=null){
			for(int i = 0 ; i < list.size(); i++){
				List inList = list.get(i);
				yizhu oneyizhu = new yizhu();
				for(int j = 0; j < inList.size(); j=j+2){
//					System.out.println((String) inList.get(j));
//					System.out.println((String) inList.get(j+1));
//					System.out.println();
					if(inList.get(j).equals("姓名"))
						oneyizhu.setName((String) inList.get(j+1));
					
					if(inList.get(j).equals("性别"))
						oneyizhu.setSex((String) inList.get(j+1));
					
					if(inList.get(j).equals("年龄"))
						oneyizhu.setAge((String) inList.get(j+1));
					
					if(inList.get(j).equals("住院号"))
						oneyizhu.setZhuYuanNum((String) inList.get(j+1));
					
					if(inList.get(j).equals("入院日期"))
						oneyizhu.setInDate((String) inList.get(j+1));
					
					if(inList.get(j).equals("出院日期"))
						oneyizhu.setOutDate((String) inList.get(j+1));
					
					if(inList.get(j).equals("医嘱名称"))
						oneyizhu.setYizhuName((String) inList.get(j+1));
					
					if(inList.get(j).equals("出院科室"))
						oneyizhu.setOutKeShi((String) inList.get(j+1));
					
					if(inList.get(j).equals("开始时间"))
						oneyizhu.setStartTime((String) inList.get(j+1));
					
					if(inList.get(j).equals("结束时间"))
						oneyizhu.setEndTime((String) inList.get(j+1));
					
					if(inList.get(j).equals("频次"))
						oneyizhu.setFrequency((String) inList.get(j+1));
					
					if(inList.get(j).equals("开单医生"))
						oneyizhu.setDocName((String) inList.get(j+1));
					
					if(inList.get(j).equals("规格"))
						oneyizhu.setSpecification((String) inList.get(j+1));
					
					if(inList.get(j).equals("剂量单位"))
						oneyizhu.setMeasureUnit((String) inList.get(j+1));
					
					if(inList.get(j).equals("一次用量"))
						oneyizhu.setUseLevel((String) inList.get(j+1));
					
																																
				}			
				result.add(oneyizhu);
			}
			
		}
		return result;
	}
	
	public static List<yizhu> toYizhuNew(List <Map<String, String>> maps){
		List<yizhu> result = new ArrayList();
		for(Map<String, String> map:maps){
			yizhu oneyz = new yizhu();
			oneyz.setAge(map.get("年龄"));
			oneyz.setDocName(map.get("开单医生"));
			oneyz.setEndTime(map.get("结束时间"));
			oneyz.setFrequency(map.get("频次"));
			oneyz.setInDate(map.get("入院日期"));
			oneyz.setMeasureUnit(map.get("剂量单位"));
			oneyz.setName(map.get("姓名"));
			oneyz.setOutDate(map.get("出院日期"));
			oneyz.setOutKeShi(map.get("出院科室"));
			oneyz.setSex(map.get("性别"));
			oneyz.setSpecification(map.get("规格"));
			oneyz.setStartTime(map.get("开始时间"));
			oneyz.setUseLevel(map.get("一次用量"));
			oneyz.setYizhuName(map.get("医嘱名称"));
			oneyz.setZhuYuanNum(map.get("住院号"));
			result.add(oneyz);
		}

			return result;																													
	}	

	
	

	
	

}
