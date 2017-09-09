package pers.luan.web.tool;

import java.util.List;

public class Vector {

	private double number;
	private List<Double> list;
	
	public double getNumber() {
		return number;
	}
	
	public void setNumber(double number) {
		this.number = number;
	}
	
	public List<Double> getList() {
		return list;
	}
	
	public void setList(List<Double> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Vector [number=" + number + ", list=" + list + "]";
	}
	
}
