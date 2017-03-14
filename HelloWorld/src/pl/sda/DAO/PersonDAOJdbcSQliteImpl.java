package pl.sda.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.sda.model.Person;

public class PersonDAOJdbcSQliteImpl implements PersonDAO {
	private final String GET_ALL_STM = "SELECT * FROM people";
	private final String INSERT_STM = "INSERT INTO people(Name, Surname, BornYear, Phone, Sex) values(?,?,?,?,?)";

	private SQLiteConnectionMenager sqliteConnectionMenager;

	public PersonDAOJdbcSQliteImpl(SQLiteConnectionMenager sqliteConnectionMenager) {
		this.sqliteConnectionMenager = sqliteConnectionMenager;
	}

	@Override
	public List<Person> getPeople() throws Exception {
		List<Person> people = new ArrayList<>();
		try (Connection conn = sqliteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(GET_ALL_STM);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				people.add(mapPersonFromResulSet(rs));
			}
		}
		return people;
	}

	private Person mapPersonFromResulSet(ResultSet rs) throws SQLException {
		String firstName = rs.getString("Name");
		String lastName = rs.getString("Surname");
		int bornYear = rs.getInt("BornYear");
		int phoneNumber = rs.getInt("Phone");
		String sex = rs.getString("Sex");

		return new Person(firstName, lastName, bornYear, phoneNumber, sex);
	}

	@Override
	public void create(Person person) throws Exception {
		try(Connection conn = sqliteConnectionMenager.getConnection()){
			PreparedStatement ps = conn.prepareStatement(INSERT_STM);
			ps.setString(1, person.getFirstName());
			ps.setString(2, person.getLastName());
			ps.setInt(3, person.getBornYear());
			ps.setInt(4, person.getPhoneNumber());
			ps.setString(5, person.getSex());
			ps.execute();
		}
	}

	@Override
	public void update(Person person) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String name, String surname) throws Exception {
		// TODO Auto-generated method stub

	}

}
