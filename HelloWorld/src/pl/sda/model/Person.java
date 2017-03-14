package pl.sda.model;

public class Person {
	private String firstName;
	private String lastName;
	private int BornYear;
	private int phoneNumber;
	private Sex sex;
	
	public Person(){}
	
	public Person(String firstName, String lastName, int bornYear, int phoneNumber, Sex sex) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.BornYear = bornYear;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
	}
	
	public Person(String firstName, String lastName, String bornYear, String phoneNumber, String sex) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.BornYear = Integer.parseInt(bornYear);
		this.phoneNumber = Integer.parseInt(phoneNumber);
		if (sex.equals(Sex.F.getSex())){
			this.sex = Sex.F;
		} else {
			this.sex = Sex.M;
		}
	}
	
	public Person(String firstName, String lastName, int bornYear, int phoneNumber, String sex) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.BornYear = bornYear;
		this.phoneNumber = phoneNumber;
		if (sex.equals(Sex.F.getSex())){
			this.sex = Sex.F;
		} else {
			this.sex = Sex.M;
		}
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
	public String getSex() {
		return sex.getSex();
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	
	
}
