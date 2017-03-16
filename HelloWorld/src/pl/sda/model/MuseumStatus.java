package pl.sda.model;

public enum MuseumStatus {
	PRIVATE("Utworzone przez osoby fizyczne"),
	LOCAL_GOVERNMENTS("Samorządowe"),
	COLEAD_LOCAL("Współprowadzone wpisane do rejestru prowadzonego przez jednostkę samorządu terytorialnego"), 
	COLEAD_NATIONAL("Współprowadzone wpisane do rejestru prowadzonego przez Ministra Kultury i Dziedzictwa Narodowego"),
	CHURCH("Kościelne"),
	NATIONAL("Państwowe");
	
	private String status;
	
	MuseumStatus(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return status;
	}
}
