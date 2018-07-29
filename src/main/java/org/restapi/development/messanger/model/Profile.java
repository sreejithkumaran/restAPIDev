package org.restapi.development.messanger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

	private String FirstName;
	private String LastName;
	private String Age;
	private String Gender;
	private String Nationality;
	private String SSN;

	public Profile() {

	}

	public Profile(String firstName, String lastName, String age, String gender, String nationality,String ssn) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Age = age;
		Gender = gender;
		Nationality = nationality;
		SSN = ssn;
	}
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getGender() {
		return Gender;
	}
	
	public String getSSN() {
		return SSN;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	
	public void setSSN(String ssn) {
		SSN = ssn;
	}

}
