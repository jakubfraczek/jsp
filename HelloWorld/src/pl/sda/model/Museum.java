package pl.sda.model;

public class Museum {
	private int id;
	private String mseumName;
	private String postalCode;
	private String city;
	private String prefix;
	private String street;
	private String houseNumber;
	private String localNumber;
	private String owner;
	private String addDate;
	private String status;
	private String address;

	public Museum(int id, String mseumName, String postalCode, String city, String prefix, String street,
			String houseNumber, String localNumber, String owner, String addDate, String status) {
		super();
		this.id = id;
		this.mseumName = mseumName;
		this.postalCode = postalCode;
		this.city = city;
		this.prefix = prefix;
		this.street = street;
		this.houseNumber = houseNumber;
		this.localNumber = localNumber;
		this.owner = owner;
		this.addDate = addDate;
		this.status = status;
		if (!localNumber.isEmpty()) {
			this.address = prefix + " " + street + " " + houseNumber + "/" + localNumber + ", " + postalCode + " "
					+ city;
		} else {
			this.address = prefix + " " + street + " " + houseNumber + ", " + postalCode + " " + city;
		}
	}

	public Museum(String id, String mseumName, String postalCode, String city, String prefix, String street,
			String houseNumber, String localNumber, String owner, String addDate, String status) {
		super();
		this.id = Integer.parseInt(id);
		this.mseumName = mseumName;
		this.postalCode = postalCode;
		this.city = city;
		this.prefix = prefix;
		this.street = street;
		this.houseNumber = houseNumber;
		this.localNumber = localNumber;
		this.owner = owner;
		this.addDate = addDate;
		this.status = status;
		if (localNumber != null) {
			this.address = prefix + " " + street + " " + houseNumber + "/" + localNumber + ", " + postalCode + " "
					+ city;
		} else {
			this.address = prefix + " " + street + " " + houseNumber + ", " + postalCode + " " + city;
		}
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
