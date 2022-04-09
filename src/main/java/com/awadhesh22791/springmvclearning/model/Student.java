package com.awadhesh22791.springmvclearning.model;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.awadhesh22791.springmvclearning.custom.validator.CourseCode;

import lombok.ToString;

@ToString
public class Student {
	@NotNull(message = "is required.")
	@Size(min = 1,message = "is required.")
	private String firstName;
	@NotNull(message = "is required.")
	@Size(min = 1,message = "is required.")
	private String lastName;
	@NotNull(message = "is required.")
	@Min(value = 5,message = "Must be greater than 5 years.")
	@Max(value = 30,message = "Must be less than 30 years.")
	private Integer age;
	@NotNull(message = "is required.")
	@Size(min = 1,message = "is required.")
	private String country;
	@NotNull(message = "is required.")
	@Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 chars/digits")
	private String postalCode;
	@NotNull(message = "is required.")
	@Size(min = 1,message = "is required.")
	private String favoriteLanguage;
	@Size(min = 1,message = "is required.")
	private String[] operatingSystem;
	@NotNull(message="is required.")
	@Size(min=1,message="is required.")
	@CourseCode(value = "DEC",message = "course code must start with DEC")
	private String courseCode;
	private LinkedHashMap<String, String>countryOptions=new LinkedHashMap<String, String>();
	private LinkedHashMap<String, String>languages=new LinkedHashMap<String, String>();
	private LinkedHashMap<String, String>operatingSystems=new LinkedHashMap<String, String>();
	public Student(){
		countryOptions.put(null, "Select Country");
		countryOptions.put("India", "India");
		countryOptions.put("Japan", "Japan");
		countryOptions.put("Italy", "Italy");
		countryOptions.put("Brazil", "Brazil");
		
		languages.put("Java", "Java");
		languages.put("C#", "C#");
		languages.put("Js", "Js");
		languages.put("Python", "Python");
		
		operatingSystems.put("Windows", "Windows");
		operatingSystems.put("Mac OS", "Mac OS");
		operatingSystems.put("Ubuntu", "Ubuntu");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String fullName() {
		String fullName = null;
		fullName=this.firstName;
		if(this.lastName!=null && !this.lastName.trim().isEmpty()) {
			fullName+=" "+this.lastName.trim();
		}
		return fullName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getLanguages() {
		return languages;
	}

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public LinkedHashMap<String, String> getOperatingSystems() {
		return operatingSystems;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
}
