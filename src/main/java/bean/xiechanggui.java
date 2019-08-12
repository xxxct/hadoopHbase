package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class xiechanggui {
	
	public String status = "xcg";
	
	private String zhuYuanNum;
	
	private String nameString;
	
	private String sex;
	
	private String applyTime;
	
	private String bingAnNum;
	
	private String inDate;
	
	private String outDate;
	
	private String kaiDanItem;
	
	private String checkTime;
	
	private String age;
	
	private String checkItems;
	
	private String result;
	
	private String reference;

	public xiechanggui(String zhuYuanNum, String nameString, String sex,
			String applyTime, String bingAnNum, String inDate, String outDate,
			String kaiDanItem, String checkTime, String age, String checkItems,
			String result, String reference) {
		super();
		this.zhuYuanNum = zhuYuanNum;
		this.nameString = nameString;
		this.sex = sex;
		this.applyTime = applyTime;
		this.bingAnNum = bingAnNum;
		this.inDate = inDate;
		this.outDate = outDate;
		this.kaiDanItem = kaiDanItem;
		this.checkTime = checkTime;
		this.age = age;
		this.checkItems = checkItems;
		this.result = result;
		this.reference = reference;
	}

	public xiechanggui() {
		// TODO Auto-generated constructor stub
	}

	public String getZhuYuanNum() {
		return zhuYuanNum;
	}

	public void setZhuYuanNum(String zhuYuanNum) {
		this.zhuYuanNum = zhuYuanNum;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getBingAnNum() {
		return bingAnNum;
	}

	public void setBingAnNum(String bingAnNum) {
		this.bingAnNum = bingAnNum;
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

	public String getKaiDanItem() {
		return kaiDanItem;
	}

	public void setKaiDanItem(String kaiDanItem) {
		this.kaiDanItem = kaiDanItem;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCheckItems() {
		return checkItems;
	}

	public void setCheckItems(String checkItems) {
		this.checkItems = checkItems;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public static List<xiechanggui> toXcg(List<List> list){
		List<xiechanggui> result = new ArrayList();
		if(list!=null){
			for(int i = 0 ; i < list.size(); i++){
				List inList = list.get(i);
				xiechanggui onexiechanggui = new xiechanggui();
				for(int j = 0; j < inList.size(); j=j+2){
					
					if(inList.get(j).equals("住院号"))
						onexiechanggui.setZhuYuanNum(((String) inList.get(j+1)));
					
					if(inList.get(j).equals("入院日期"))
						onexiechanggui.setInDate((String) inList.get(j+1));
					
					if(inList.get(j).equals("出院日期"))
						onexiechanggui.setOutDate((String) inList.get(j+1));
					
					if(inList.get(j).equals("参考值"))
						onexiechanggui.setReference((String) inList.get(j+1));
					
					if(inList.get(j).equals("姓名"))
						onexiechanggui.setNameString((String) inList.get(j+1));
					
					if(inList.get(j).equals("年龄"))
						onexiechanggui.setAge(((String) inList.get(j+1)));
					
					if(inList.get(j).equals("开单项目"))
						onexiechanggui.setKaiDanItem((String) inList.get(j+1));
					
					if(inList.get(j).equals("性别"))
						onexiechanggui.setSex((String) inList.get(j+1));
					
					if(inList.get(j).equals("检查时间"))
						onexiechanggui.setCheckTime((String) inList.get(j+1));
					
					if(inList.get(j).equals("检验项目"))
						onexiechanggui.setCheckItems((String) inList.get(j+1));
					
					if(inList.get(j).equals("申请时间"))
						onexiechanggui.setApplyTime((String) inList.get(j+1));
					
					if(inList.get(j).equals("病案号"))
						onexiechanggui.setBingAnNum((String) inList.get(j+1));
					
					if(inList.get(j).equals("结果"))
						onexiechanggui.setResult((String) inList.get(j+1));
																																		
				}			
				result.add(onexiechanggui);
			}
		}
		return  result;
	}
	
	public static List<xiechanggui> toXcgNew(List <Map<String, String>> maps){
		List<xiechanggui> result = new ArrayList();
		for(Map<String, String> map:maps){
			xiechanggui onexcg = new xiechanggui();
			onexcg.setAge(map.get("年龄"));
			onexcg.setApplyTime(map.get("申请时间"));
			onexcg.setBingAnNum(map.get("病案号"));  
			onexcg.setCheckItems(map.get("检验项目"));
			onexcg.setCheckTime(map.get("检查时间"));
			onexcg.setInDate(map.get("入院日期"));
			onexcg.setKaiDanItem(map.get("开单项目"));
			onexcg.setNameString(map.get("姓名"));
			onexcg.setOutDate(map.get("出院日期"));
			onexcg.setReference(map.get("参考值"));
			onexcg.setResult(map.get("结果"));
			onexcg.setSex(map.get("性别"));
			onexcg.setZhuYuanNum(map.get("住院号"));
			result.add(onexcg);
		}

			return result;																													
	}			
	
	

}
