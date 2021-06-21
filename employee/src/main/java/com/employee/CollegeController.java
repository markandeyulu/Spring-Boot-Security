package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.bean.CollegeMarks;

@Controller
public class CollegeController {

	@Autowired
	CollegeMarks collegeMarks; 
	
	@RequestMapping("/getCollegeMarkRequest")
	public String getCollegeMarkRequest(Model model) {
		
		model.addAttribute("collegeMarks", collegeMarks);
		
		return "student_springform";
	}
	
	@RequestMapping(value="/getCollegeMarkRequest", method = RequestMethod.POST)
	public String getTotalForCollegeMarks(@ModelAttribute CollegeMarks collegeMarks) {
		
		collegeMarks.setTotal(String.valueOf(Integer.parseInt(collegeMarks.getEnglish()) + Integer.parseInt(collegeMarks.getMaths())
				+ Integer.parseInt(collegeMarks.getPhysics())));
		return "student_springform";
	}
}
