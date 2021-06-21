package com.employee.bean;

import org.springframework.stereotype.Component;

@Component
public class StudentMarkBean {


	
	private String tamil;
	public String getTamil() {
		return tamil;
	}
	public void setTamil(String tamil) {
		this.tamil = tamil;
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
	public String getScience() {
		return science;
	}
	public void setScience(String science) {
		this.science = science;
	}
	public String getSocial() {
		return social;
	}
	public void setSocial(String social) {
		this.social = social;
	}
	public String getTotal() {
		return String.valueOf(Integer.parseInt(tamil) + Integer.parseInt(english) + Integer.parseInt(maths) + Integer.parseInt(science)
				+ Integer.parseInt(social));
	}
	public void setTotal(String total) {
		this.total = total;
	}
	private String english;
	private String maths;
	private String science;
	private String social;
	private String total;
	
}
