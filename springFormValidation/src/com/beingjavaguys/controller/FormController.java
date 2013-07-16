package com.beingjavaguys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beingjavaguys.domain.Student;
import com.beingjavaguys.validator.FormValidation;

@Controller
public class FormController {

	@RequestMapping("/showForm")
	public String getForm(ModelMap model) {

		Student student = new Student();
		model.addAttribute("student", student);

		getList(model);
		return "Register";
	}

	@RequestMapping("/submit")
	public String saveForm(Student student, BindingResult result, ModelMap model) {
		FormValidation formValidation = new FormValidation();

		formValidation.validate(student, result);

		if (result.hasErrors()) {
			getList(model);
			return "Register";
		}

		student = (Student) result.getModel().get("student");
		System.out.println(student.getId());
		return "Details";
	}

	public void getList(ModelMap model) {
		HashMap<String, String> cityList = new HashMap<String, String>();

		cityList.put("delhi", "Delhi");
		cityList.put("noida", "Noida");
		cityList.put("gurgaon", "Gurgaon");
		cityList.put("ghaziabad", "Ghaziabad");
		model.addAttribute("cityList", cityList);

		ArrayList<String> interestList = new ArrayList<String>();
		interestList.add("reading");
		interestList.add("cricket");
		interestList.add("movies");
		model.addAttribute("interestList", interestList);
	}
}
