package pl.sda.model;

public class MessageConfirm {
	private String name;
	private String surname;
	private String email;
	private String message;
	
	public MessageConfirm(String name, String surname, String email, String message) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Cze��" + name + surname + "!\nDziekujemy za przeslanie wiadomosci.\nWyslales nastepujaca wiadomosc:\n" + message + "Dziekujemy,\njavalodz2";
		
	}

	
	
	
}
