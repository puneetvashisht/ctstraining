package com.cognizant.entity;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Emp {
		@Size(min=5, max=12) 
	    private String name;
	     
	    @NotEmpty @Email
	    private String email;
	     
	    @NotNull @Min(18) @Max(100)
	    private Integer age;
	     
//	    @NotNull
//	    private Gender gender;
	     
	    @DateTimeFormat(pattern="MM/dd/yyyy")
	    @NotNull @Past
	    private Date birthday;
	    
	    public enum Gender {
			MALE, FEMALE
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

//		public Gender getGender() {
//			return gender;
//		}
//
//		public void setGender(Gender gender) {
//			this.gender = gender;
//		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		@Override
		public String toString() {
			return "Emp [name=" + name + ", email=" + email + ", age=" + age
					+ ", birthday=" + birthday + "]";
		}

//		@Override
//		public String toString() {
//			return "Emp [name=" + name + ", email=" + email + ", age=" + age
//					+ ", gender=" + gender + ", birthday=" + birthday + "]";
//		}

		
	}