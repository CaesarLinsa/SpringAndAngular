package com.soft.entity;

public class User {
	
	private Integer id;
	
	private String userName;
	
	private String passWord;

	private String gender;
	
	private Integer age;

	public User() {
		super();
	}
	public User(Integer id, String userName, String passWord, String gender, Integer age) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.gender = gender;
		this.age = age;
	}
	public User(String userName, String passWord, String gender, Integer age) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.gender = gender;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", gender=" + gender + ", age="
				+ age + "]";
	}
	
}
