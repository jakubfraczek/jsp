package pl.sda.DAO;

import java.util.List;

import pl.sda.model.Museum;

public interface MuseumDAO {
	
	List<Museum> getAll() throws Exception;
	List<Museum> getById(int id) throws Exception;
	List<Museum> getByName(String museumName) throws Exception;
	List<Museum> getByPostal(String postalCode) throws Exception;
	List<Museum> getByCity(String city) throws Exception;
	List<Museum> getByStreet(String street) throws Exception;
	List<Museum> getByOwner(String owner) throws Exception;
	List<Museum> getByDate(String addDate) throws Exception;
	List<Museum> getByStatus(String status) throws Exception;
	void createTable() throws Exception;
	void dropTable() throws Exception;
	void add(Museum museum) throws Exception;
	void create(List<Museum> museums) throws Exception;
}
