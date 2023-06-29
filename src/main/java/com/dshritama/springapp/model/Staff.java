package com.dshritama.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phone;
    private String email;
    private String jobTitle;
    private double salary;
    private String benefits;

    // Constructors, getters, and setters


public Staff() {
	super();
	// TODO Auto-generated constructor stub
}



public Staff(Long id, String name, int age, String gender, String address, String phone, String email,
			String jobTitle, double salary, String benefits) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.setJobTitle(jobTitle);
		this.salary = salary;
		this.benefits = benefits;
	}



public Long getId() {
    return id;
}


public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

public String getGender() {
    return gender;
}

public void setGender(String gender) {
    this.gender = gender;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

@Override
public String toString() {
    return "Staff [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
            + ", phone=" + phone + ", email=" + email + ", job_title=" + jobTitle + ", salary=" + salary
            + ", benefits=" + benefits + "]";
}


public double getSalary() {
    return salary;
}

public void setSalary(double salary) {
    this.salary = salary;
}

public String getBenefits() {
    return benefits;
}

public void setBenefits(String benefits) {
    this.benefits = benefits;
}



public String getJobTitle() {
	return jobTitle;
}



public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}





}