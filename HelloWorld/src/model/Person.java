package model;

public class Person {
	private String firstName;
	private String lastName;
	private int BornYear;
	private int phoneNumber;
	private Sex sex;
	
	public Person(){}
	
	public Person(String firstName, String lastName, int bornYear, int phoneNumber, Sex sex) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.BornYear = bornYear;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
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
	public int getBornYear() {
		return BornYear;
	}
	public void setBornYear(int bornYear) {
		this.BornYear = bornYear;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	
	
}
