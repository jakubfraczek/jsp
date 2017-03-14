package pl.sda.DAO;

import java.util.List;

import pl.sda.model.Person;

public interface PersonDAO {
	List<Person> getPeople() throws Exception;
	void create(Person person) throws Exception;
	void update(Person person) throws Exception;
	void delete(String name, String surname) throws Exception;

}
