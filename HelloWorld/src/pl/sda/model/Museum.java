package pl.sda.model;

import java.time.LocalDate;

public class Museum {
	private int id;
	private String mseumName;
	private String postalCode;
	private String city;
	private String prefix;
	private String street;
	private String houseNumber;
	private String localNumber;
	private LocalDate addDate;
	private MuseumStatus status;
	
	public Museum(int id, String mseumName, String postalCode, String city, String prefix, String street,
			String houseNumber, String localNumber, LocalDate addDate, MuseumStatus status) {
		super();
		this.id = id;
		this.mseumName = mseumName;
		this.postalCode = postalCode;
		this.city = city;
		this.prefix = prefix;
		this.street = street;
		this.houseNumber = houseNumber;
		this.localNumber = localNumber;
		this.addDate = addDate;
		this.status = status;
	}
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getMseumName() {
		return mseumName;
	}
	public void setMseumName(String mseumName) {
		this.mseumName = mseumName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getLocalNumber() {
		return localNumber;
	}
	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}
	public LocalDate getAddDate() {
		return addDate;
	}
	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}
	public String getStatus() {
		return status.getStatus();
	}
	public void setStatus(MuseumStatus status) {
		this.status = status;
	}
	
	
}
