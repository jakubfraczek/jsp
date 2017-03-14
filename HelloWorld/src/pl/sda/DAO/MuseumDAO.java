package pl.sda.DAO;

import java.time.LocalDate;

import pl.sda.model.Museum;
import pl.sda.model.MuseumStatus;

public interface MuseumDAO {

	Museum getById(int id) throws Exception;
	Museum getByName(String mseumName) throws Exception;
	Museum getByPostal(String postalCode) throws Exception;
	Museum getByCity(String city) throws Exception;
	Museum getByStreet(String street) throws Exception;
	Museum getByDate(LocalDate addDate) throws Exception;
	Museum getByStatus(MuseumStatus status) throws Exception;
	void createTable() throws Exception;
	void create(Museum museum) throws Exception;
}
