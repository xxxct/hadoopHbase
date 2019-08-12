package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hadoop.hbase.thrift.generated.Hbase.AsyncProcessor.append;

public class BingAn {
	
	public String status = "bl";
	
	private String bingAnNum;
	
	private String name;
	
	private String sex;
	
	private String birDate;
	
	private String age;
	
	private String marriage;
	
	private String leaveWay;
	
	private String outcome;
	
	private String hospitalNum;
	
	private String Province;
	
	private String City;
	
	private String Xian;
	
	private String IDNo;
	
	private String Address;
	
	private String Phone;
	
	private String inDate;
	
	private String RUYUANKS;
	
	private String inBed;
	
	private String outDate;
	
	private String CHUYUANKS;
	
	private String outBed;
	
	private String hospitalDay;
	
	private String menzhenDiaCode;
	
	private String menzhenDiaName;
	
	private String dischargeDiaCode;
	
	private String dischargeDiaName;
	
	private String otherCode1;
	
	private String otherName1;
	
    private String otherCode2;
	
	private String otherName2;
	
	private String otherCode3;
	
	private String otherName3;
	
    private String otherCode4;
	
	private String otherName4;
	
	private String otherCode5;
	
	private String otherName5;
	
    private String otherCode6;
	
	private String otherName6;

	private String otherCode7;
	
	private String otherName7;
	
    private String otherCode8;
	
	private String otherName8;
	
	private String otherCode9;
	
	private String otherName9;
	
    private String otherCode10;
	
	private String otherName10;
	
	private String bloodType;
	
	private String RH;

	public BingAn(String bingAnNum, String name, String sex, String birDate,
			String age, String marriage, String leaveWay, String outcome,
			String hospitalNum, String province, String city, String xian,
			String iDNo, String address, String phone, String inDate,
			String rUYUANKS, String inBed, String outDate, String cHUYUANKS,
			String outBed, String hospitalDay, String menzhenDiaCode,
			String menzhenDiaName, String dischargeDiaCode,
			String dischargeDiaName, String otherCode1, String otherName1,
			String otherCode2, String otherName2, String otherCode3,
			String otherName3, String otherCode4, String otherName4,
			String otherCode5, String otherName5, String otherCode6,
			String otherName6, String otherCode7, String otherName7,
			String otherCode8, String otherName8, String otherCode9,
			String otherName9, String otherCode10, String otherName10,
			String bloodType, String rH) {
		super();
		this.bingAnNum = bingAnNum;
		this.name = name;
		this.sex = sex;
		this.birDate = birDate;
		this.age = age;
		this.marriage = marriage;
		this.leaveWay = leaveWay;
		this.outcome = outcome;
		this.hospitalNum = hospitalNum;
		Province = province;
		City = city;
		Xian = xian;
		IDNo = iDNo;
		Address = address;
		Phone = phone;
		this.inDate = inDate;
		RUYUANKS = rUYUANKS;
		this.inBed = inBed;
		this.outDate = outDate;
		CHUYUANKS = cHUYUANKS;
		this.outBed = outBed;
		this.hospitalDay = hospitalDay;
		this.menzhenDiaCode = menzhenDiaCode;
		this.menzhenDiaName = menzhenDiaName;
		this.dischargeDiaCode = dischargeDiaCode;
		this.dischargeDiaName = dischargeDiaName;
		this.otherCode1 = otherCode1;
		this.otherName1 = otherName1;
		this.otherCode2 = otherCode2;
		this.otherName2 = otherName2;
		this.otherCode3 = otherCode3;
		this.otherName3 = otherName3;
		this.otherCode4 = otherCode4;
		this.otherName4 = otherName4;
		this.otherCode5 = otherCode5;
		this.otherName5 = otherName5;
		this.otherCode6 = otherCode6;
		this.otherName6 = otherName6;
		this.otherCode7 = otherCode7;
		this.otherName7 = otherName7;
		this.otherCode8 = otherCode8;
		this.otherName8 = otherName8;
		this.otherCode9 = otherCode9;
		this.otherName9 = otherName9;
		this.otherCode10 = otherCode10;
		this.otherName10 = otherName10;
		this.bloodType = bloodType;
		RH = rH;
	}

	public BingAn() {
		// TODO Auto-generated constructor stub
	}

	public String getBingAnNum() {
		return bingAnNum;
	}

	public void setBingAnNum(String bingAnNum) {
		this.bingAnNum = bingAnNum;
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

	public String getBirDate() {
		return birDate;
	}

	public void setBirDate(String birDate) {
		this.birDate = birDate;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getLeaveWay() {
		return leaveWay;
	}

	public void setLeaveWay(String leaveWay) {
		this.leaveWay = leaveWay;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getHospitalNum() {
		return hospitalNum;
	}

	public void setHospitalNum(String hospitalNum) {
		this.hospitalNum = hospitalNum;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getXian() {
		return Xian;
	}

	public void setXian(String xian) {
		Xian = xian;
	}

	public String getIDNo() {
		return IDNo;
	}

	public void setIDNo(String iDNo) {
		IDNo = iDNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getRUYUANKS() {
		return RUYUANKS;
	}

	public void setRUYUANKS(String rUYUANKS) {
		RUYUANKS = rUYUANKS;
	}

	public String getInBed() {
		return inBed;
	}

	public void setInBed(String inBed) {
		this.inBed = inBed;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getCHUYUANKS() {
		return CHUYUANKS;
	}

	public void setCHUYUANKS(String cHUYUANKS) {
		CHUYUANKS = cHUYUANKS;
	}

	public String getOutBed() {
		return outBed;
	}

	public void setOutBed(String outBed) {
		this.outBed = outBed;
	}

	public String getHospitalDay() {
		return hospitalDay;
	}

	public void setHospitalDay(String hospitalDay) {
		this.hospitalDay = hospitalDay;
	}

	public String getMenzhenDiaCode() {
		return menzhenDiaCode;
	}

	public void setMenzhenDiaCode(String menzhenDiaCode) {
		this.menzhenDiaCode = menzhenDiaCode;
	}

	public String getMenzhenDiaName() {
		return menzhenDiaName;
	}

	public void setMenzhenDiaName(String menzhenDiaName) {
		this.menzhenDiaName = menzhenDiaName;
	}

	public String getDischargeDiaCode() {
		return dischargeDiaCode;
	}

	public void setDischargeDiaCode(String dischargeDiaCode) {
		this.dischargeDiaCode = dischargeDiaCode;
	}

	public String getDischargeDiaName() {
		return dischargeDiaName;
	}

	public void setDischargeDiaName(String dischargeDiaName) {
		this.dischargeDiaName = dischargeDiaName;
	}

	public String getOtherCode1() {
		return otherCode1;
	}

	public void setOtherCode1(String otherCode1) {
		this.otherCode1 = otherCode1;
	}

	public String getOtherName1() {
		return otherName1;
	}

	public void setOtherName1(String otherName1) {
		this.otherName1 = otherName1;
	}

	public String getOtherCode2() {
		return otherCode2;
	}

	public void setOtherCode2(String otherCode2) {
		this.otherCode2 = otherCode2;
	}

	public String getOtherName2() {
		return otherName2;
	}

	public void setOtherName2(String otherName2) {
		this.otherName2 = otherName2;
	}

	public String getOtherCode3() {
		return otherCode3;
	}

	public void setOtherCode3(String otherCode3) {
		this.otherCode3 = otherCode3;
	}

	public String getOtherName3() {
		return otherName3;
	}

	public void setOtherName3(String otherName3) {
		this.otherName3 = otherName3;
	}

	public String getOtherCode4() {
		return otherCode4;
	}

	public void setOtherCode4(String otherCode4) {
		this.otherCode4 = otherCode4;
	}

	public String getOtherName4() {
		return otherName4;
	}

	public void setOtherName4(String otherName4) {
		this.otherName4 = otherName4;
	}

	public String getOtherCode5() {
		return otherCode5;
	}

	public void setOtherCode5(String otherCode5) {
		this.otherCode5 = otherCode5;
	}

	public String getOtherName5() {
		return otherName5;
	}

	public void setOtherName5(String otherName5) {
		this.otherName5 = otherName5;
	}

	public String getOtherCode6() {
		return otherCode6;
	}

	public void setOtherCode6(String otherCode6) {
		this.otherCode6 = otherCode6;
	}

	public String getOtherName6() {
		return otherName6;
	}

	public void setOtherName6(String otherName6) {
		this.otherName6 = otherName6;
	}

	public String getOtherCode7() {
		return otherCode7;
	}

	public void setOtherCode7(String otherCode7) {
		this.otherCode7 = otherCode7;
	}

	public String getOtherName7() {
		return otherName7;
	}

	public void setOtherName7(String otherName7) {
		this.otherName7 = otherName7;
	}

	public String getOtherCode8() {
		return otherCode8;
	}

	public void setOtherCode8(String otherCode8) {
		this.otherCode8 = otherCode8;
	}

	public String getOtherName8() {
		return otherName8;
	}

	public void setOtherName8(String otherName8) {
		this.otherName8 = otherName8;
	}

	public String getOtherCode9() {
		return otherCode9;
	}

	public void setOtherCode9(String otherCode9) {
		this.otherCode9 = otherCode9;
	}

	public String getOtherName9() {
		return otherName9;
	}

	public void setOtherName9(String otherName9) {
		this.otherName9 = otherName9;
	}

	public String getOtherCode10() {
		return otherCode10;
	}

	public void setOtherCode10(String otherCode10) {
		this.otherCode10 = otherCode10;
	}

	public String getOtherName10() {
		return otherName10;
	}

	public void setOtherName10(String otherName10) {
		this.otherName10 = otherName10;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getRH() {
		return RH;
	}

	public void setRH(String rH) {
		RH = rH;
	}
	
	
	public static List<BingAn> toBingAnNew(List <Map<String, String>> maps){
		List<BingAn> result = new ArrayList();
		for(Map<String, String> map:maps){
			BingAn onebingli = new BingAn();
			onebingli.setCHUYUANKS(map.get("CHUYUANKS"));
			onebingli.setRH(map.get("RH"));  
			onebingli.setRUYUANKS(map.get("RUYUANKS"));
			onebingli.setHospitalNum(map.get("住院次数"));
			onebingli.setInBed(map.get("入院床位"));
			onebingli.setInDate(map.get("入院日期"));
			onebingli.setOtherCode1(map.get("其他诊断代码1"));
			onebingli.setOtherCode2(map.get("其他诊断代码2"));
			onebingli.setOtherCode3(map.get("其他诊断代码3"));
			onebingli.setOtherCode4(map.get("其他诊断代码4"));
			onebingli.setOtherCode5(map.get("其他诊断代码5"));
			onebingli.setOtherCode6(map.get("其他诊断代码6"));
			onebingli.setOtherCode7(map.get("其他诊断代码7"));
			onebingli.setOtherCode8(map.get("其他诊断代码8"));
			onebingli.setOtherCode9(map.get("其他诊断代码9"));
			onebingli.setOtherCode10(map.get("其他诊断代码10"));
			onebingli.setOtherName1(map.get("其他诊断名称1"));
			onebingli.setOtherName2(map.get("其他诊断名称2"));
			onebingli.setOtherName3(map.get("其他诊断名称3"));
			onebingli.setOtherName4(map.get("其他诊断名称4"));
			onebingli.setOtherName5(map.get("其他诊断名称5"));
			onebingli.setOtherName6(map.get("其他诊断名称6"));
			onebingli.setOtherName7(map.get("其他诊断名称7"));
			onebingli.setOtherName8(map.get("其他诊断名称8"));
			onebingli.setOtherName9(map.get("其他诊断名称9"));
			onebingli.setOtherName10(map.get("其他诊断名称10"));
			onebingli.setBirDate(map.get("出生日期"));
			onebingli.setOutBed(map.get("出院床位"));
			onebingli.setOutDate(map.get("出院日期"));
			onebingli.setDischargeDiaCode(map.get("出院诊断代码"));
			onebingli.setDischargeDiaName(map.get("出院诊断名称"));
			onebingli.setXian(map.get("地址县"));
			onebingli.setCity(map.get("地址市"));
			onebingli.setProvince(map.get("地址省"));
			onebingli.setName(map.get("姓名"));
			onebingli.setMarriage(map.get("婚姻"));
			onebingli.setHospitalDay(map.get("实际住院天数"));
			onebingli.setAge(map.get("年龄"));
			onebingli.setSex(map.get("性别"));
			onebingli.setAddress(map.get("现住址"));
			onebingli.setBingAnNum(map.get("病案号"));
			onebingli.setLeaveWay(map.get("离院方式"));
			onebingli.setPhone(map.get("联系电话"));
			onebingli.setBloodType(map.get("血型"));
			onebingli.setIDNo(map.get("身份证号"));
			onebingli.setOutcome(map.get("转归情况"));
			onebingli.setMenzhenDiaCode(map.get("门诊诊断代码"));
			onebingli.setMenzhenDiaName(map.get("门诊诊断名称"));	
			result.add(onebingli);
		}

			return result;																													
	}			
				

	
	
	public static List<BingAn> toBingAn(List<List> list){
		List<BingAn> result = new ArrayList();
		if(list!=null){
			for(int i = 0 ; i < list.size(); i++){
				List inList = list.get(i);
				BingAn onebingli = new BingAn();
				for(int j = 0; j < inList.size(); j=j+2){
					
					if(inList.get(j).equals("CHUYUANKS"))
						onebingli.setCHUYUANKS((String) inList.get(j+1));
					
					if(inList.get(j).equals("RH"))
						onebingli.setRH((String) inList.get(j+1));
					
					if(inList.get(j).equals("RUYUANKS"))
						onebingli.setRUYUANKS((String) inList.get(j+1));
					
					if(inList.get(j).equals("住院次数"))
						onebingli.setHospitalNum((String) inList.get(j+1));
					
					if(inList.get(j).equals("入院床位"))
						onebingli.setInBed((String) inList.get(j+1));
					
					if(inList.get(j).equals("入院日期"))
						onebingli.setInDate((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断代码1"))
						onebingli.setOtherCode1((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断代码2"))
						onebingli.setOtherCode2((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断代码3"))
						onebingli.setOtherCode3((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断代码4"))
						onebingli.setOtherCode4((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断代码5"))
						onebingli.setOtherCode5((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断代码6"))
						onebingli.setOtherCode6((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断代码7"))
						onebingli.setOtherCode7((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断代码8"))
						onebingli.setOtherCode8((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断代码9"))
						onebingli.setOtherCode9((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断代码10"))
						onebingli.setOtherCode10((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断名称1"))
						onebingli.setOtherName1((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断名称2"))
						onebingli.setOtherName2((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断名称3"))
						onebingli.setOtherName3((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断名称4"))
						onebingli.setOtherName4((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断名称5"))
						onebingli.setOtherName5((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断名称6"))
						onebingli.setOtherName6((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断名称7"))
						onebingli.setOtherName7((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断名称8"))
						onebingli.setOtherName8((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断名称9"))
						onebingli.setOtherName9((String) inList.get(j+1));
					
					if(inList.get(j).equals("其他诊断名称10"))
						onebingli.setOtherName10((String) inList.get(j+1));
					
					if(inList.get(j).equals("出生日期"))
						onebingli.setBirDate((String) inList.get(j+1));
					
					if(inList.get(j).equals("出院床位"))
						onebingli.setOutBed((String) inList.get(j+1));
					
					if(inList.get(j).equals("出院日期"))
						onebingli.setOutDate((String) inList.get(j+1));
					
					if(inList.get(j).equals("出院诊断代码"))
						onebingli.setDischargeDiaCode((String) inList.get(j+1));
					
					if(inList.get(j).equals("出院诊断名称"))
						onebingli.setDischargeDiaName((String) inList.get(j+1));
					
					if(inList.get(j).equals("地址县"))
						onebingli.setXian((String) inList.get(j+1));
					
					if(inList.get(j).equals("地址市"))
						onebingli.setCity((String) inList.get(j+1));
					
					if(inList.get(j).equals("地址省"))
						onebingli.setProvince((String) inList.get(j+1));
					
					if(inList.get(j).equals("姓名"))
						onebingli.setName((String) inList.get(j+1));
					
					if(inList.get(j).equals("婚姻"))
						onebingli.setMarriage((String) inList.get(j+1));
					
					if(inList.get(j).equals("实际住院天数"))
						onebingli.setHospitalDay((String) inList.get(j+1));
					
					if(inList.get(j).equals("年龄"))
						onebingli.setAge((String) inList.get(j+1));
					
					if(inList.get(j).equals("性别"))
						onebingli.setSex((String) inList.get(j+1));
					
					if(inList.get(j).equals("现住址"))
						onebingli.setAddress((String) inList.get(j+1));
					
					if(inList.get(j).equals("病案号"))
						onebingli.setBingAnNum((String) inList.get(j+1));
					
					if(inList.get(j).equals("离院方式"))
						onebingli.setLeaveWay((String) inList.get(j+1));
					
					if(inList.get(j).equals("联系电话"))
						onebingli.setPhone((String) inList.get(j+1));
					
					if(inList.get(j).equals("血型"))
						onebingli.setBloodType((String) inList.get(j+1));
					
					if(inList.get(j).equals("身份证号"))
						onebingli.setIDNo((String) inList.get(j+1));
					
					if(inList.get(j).equals("转归情况"))
						onebingli.setOutcome((String) inList.get(j+1));
					
					if(inList.get(j).equals("门诊诊断代码"))
						onebingli.setMenzhenDiaCode((String) inList.get(j+1));
					
					if(inList.get(j).equals("门诊诊断名称"))
						onebingli.setMenzhenDiaName((String) inList.get(j+1));																											
				}			
				result.add(onebingli);
			}
		}
		return result;
		
	}


}
