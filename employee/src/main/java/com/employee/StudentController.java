package com.employee;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employee.bean.StudentMarkBean;
@XmlRootElement
@RestController
public class StudentController {

	@Autowired
	StudentMarkBean studentMarkBean;

	@RequestMapping("/getStudent")
	public ModelAndView getStudent() {
		ModelAndView mv = new ModelAndView("student");

		return mv;
	}

	/*
	 * @RequestMapping(value = "/processStudentData" , method = RequestMethod.POST )
	 * public ModelAndView processStudentData(HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * ModelAndView mv = new ModelAndView("student");
	 * 
	 * studentMarkBean.setTamil(request.getParameter("tamil"));
	 * studentMarkBean.setEnglish(request.getParameter("english"));
	 * studentMarkBean.setMaths(request.getParameter("maths"));
	 * studentMarkBean.setScience(request.getParameter("science"));
	 * studentMarkBean.setSocial(request.getParameter("social"));
	 * 
	 * 
	 * mv.addObject("studentMarkBean", studentMarkBean);
	 * 
	 * mv.addObject("tamilmark", request.getParameter("tamil"));
	 * mv.addObject("tamilmark", request.getParameter("tamil"));
	 * mv.addObject("tamilmark", request.getParameter("tamil"));
	 * 
	 * 
	 * return mv; }
	 */

	@RequestMapping(value = "/findTotal", method = RequestMethod.POST)
	public StudentMarkBean findTotal(@RequestBody StudentMarkBean studentMarkBean) {
		/*
		 * request.getHeaderNames();
		 * studentMarkBean.setTamil(request.getParameter("tamil"));
		 * studentMarkBean.setEnglish(request.getParameter("english"));
		 * studentMarkBean.setMaths(request.getParameter("maths"));
		 * studentMarkBean.setScience(request.getParameter("science"));
		 * studentMarkBean.setSocial(request.getParameter("social"));
		 */
		return studentMarkBean;
	}

	@GetMapping("/welcome")
	public String getMessage() {// Spring MVC operation can be done easily here // outside of main.
		return "Welcome to Boot";
	}
}
