package pl.sda.model;

public enum MuseumStatus {
	PRIVATE("Utworzone przez osoby fizyczne"),
	AUTONOMY("Samorz¹dowe"),
	LOCAL("Wspó³prowadzone wpisane do rejestru prowadzonego przez jednostkê samorz¹du terytorialnego"), 
	NATIONAL("Pañstwowe");
	
	private String status;
	
	MuseumStatus(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return status;
	}
}
