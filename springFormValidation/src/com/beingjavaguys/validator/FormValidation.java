package com.beingjavaguys.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.beingjavaguys.domain.Student;

public class FormValidation implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	String ID_PATTERN = "[0-9]+";
	String STRING_PATTERN = "[a-zA-Z]+";
	String MOBILE_PATTERN = "[0-9]{10}";

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

		Student student = (Student) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required.id",
				"Id is required.");
		if (student.getId() != null) {
			pattern = Pattern.compile(ID_PATTERN);
			matcher = pattern.matcher(student.getId().toString());
			if (!matcher.matches()) {
				errors.rejectValue("id", "id.incorrect",
						"Enter a numeric value");
			}
			if (student.getId().toString().length() > 5) {
				errors.rejectValue("id", "id.exceed",
						"Id should not contain more than 5 digits");
			}
		}
		ValidationUtils.rejectIfEmpty(errors, "name", "required.name",
				"Name is required.");
		if (!(student.getName() != null && student.getName().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(student.getName());
			if (!matcher.matches()) {
				errors.rejectValue("name", "name.containNonChar",
						"Enter a valid name");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender",
				"required.gender", "Select your gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"required.email", "Email is required.");
		if (!(student.getEmail() != null && student.getEmail().isEmpty())) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(student.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "email.incorrect",
						"Enter a correct email");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone",
				"required.phone", "Phone is required.");
		if (!(student.getPhone() != null && student.getPhone().isEmpty())) {
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(student.getPhone());
			if (!matcher.matches()) {
				errors.rejectValue("phone", "phone.incorrect",
						"Enter a correct phone number");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Password is required.");

		if (!student.getPassword().equals(student.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "password.mismatch",
					"Password does not match");
		}
		if (student.getCity().equals("select")) {
			errors.rejectValue("city", "city.select", "select a city");
		}

		ValidationUtils.rejectIfEmpty(errors, "overview", "required.overview",
				"Overview is required.");
		System.out.println(student.getInterest().length);
		if (student.getInterest().length <= 0) {
			errors.rejectValue("interest", "noselect.interest",
					"Select atleast one interest");
		}

	}

}
