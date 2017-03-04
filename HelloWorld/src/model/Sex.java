package model;

public enum Sex {
	M("male"), F("female");
	
	private String sex;
	
	Sex(String sex){
		this.sex = sex;
	}
	
	public String getSex(){
		return sex;
	}
}
