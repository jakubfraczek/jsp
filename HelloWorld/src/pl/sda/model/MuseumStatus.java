package pl.sda.model;

public enum MuseumStatus {
	PRIVATE("Utworzone przez osoby fizyczne"),
	AUTONOMY("Samorz�dowe"),
	LOCAL("Wsp�prowadzone wpisane do rejestru prowadzonego przez jednostk� samorz�du terytorialnego"), 
	NATIONAL("Pa�stwowe");
	
	private String status;
	
	MuseumStatus(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return status;
	}
}
