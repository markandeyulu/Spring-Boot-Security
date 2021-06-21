package com.employee.bean;

import org.springframework.stereotype.Component;

@Component
public class CollegeMarks {
	
	private String english;
	private String maths;
	private String physics;
	private String total;
	public String getTotal() {
		return total;
		//return String.valueOf(Integer.parseInt(english)+Integer.parseInt(maths)+Integer.parseInt(physics));
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getMaths() {
		return maths;
	}
	public void setMaths(String maths) {
		this.maths = maths;
	}
	public String getPhysics() {
		return physics;
	}
	public void setPhysics(String physics) {
		this.physics = physics;
	}

}
