package bean;

import java.util.ArrayList;
import java.util.List;

import org.jruby.compiler.ir.operands.Array;

public class Person {
			
	private List<BingAn> blList = new ArrayList();
	
	private List<xiechanggui> xcgList = new ArrayList();
	
	private List<yizhu> yzList = new ArrayList();
	
	
	public List<BingAn> getBlList() {
		return blList;
	}
	public void setBlList(List<BingAn> blList) {
		this.blList = blList;
	}
	public List<xiechanggui> getXcgList() {
		return xcgList;
	}
	public void setXcgList(List<xiechanggui> xcgList) {
		this.xcgList = xcgList;
	}
	public List<yizhu> getYzList() {
		return yzList;
	}
	public void setYzList(List<yizhu> yzList) {
		this.yzList = yzList;
	}
	
	
}
