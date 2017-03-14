package pl.sda.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

import pl.sda.model.Museum;
import pl.sda.model.MuseumStatus;

public class MuseumDAOJdbcSQLiteIpml implements MuseumDAO {
	private final String CREATE_TABLE_STMT = "Create table museums(id int, Name varchar(300), PostalCode varchar(6), City varchar(30), Prefix varchar(3), Street varchar(100), NouseNumber varchar(5), LocalNumber varchar(5), AddDate varchar(10), Status varchar(30))";
	private final String INSERT_STM = "INSERT INTO museums(id, Name, PostalCode, City, Prefix, Street, NouseNumber, LocalNumber, AddDate, Status) values(?,?,?,?,?,?,?,?,?,?)";
	
	private MuseumSQLiteConnectionMenager museumSQLiteConnectionMenager;

	public MuseumDAOJdbcSQLiteIpml(MuseumSQLiteConnectionMenager museumSQLiteConnectionMenager) {
		this.museumSQLiteConnectionMenager = museumSQLiteConnectionMenager;
	}

	@Override
	public Museum getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Museum getByName(String mseumName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Museum getByPostal(String postalCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Museum getByCity(String city) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Museum getByStreet(String street) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Museum getByDate(LocalDate addDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Museum getByStatus(MuseumStatus status) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Museum museum) throws Exception {
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(INSERT_STM);
			ps.setInt(1, museum.getid());
			ps.setString(2, museum.getMseumName());
			ps.setString(3, museum.getPostalCode());
			ps.setString(4, museum.getCity());
			ps.setString(5, museum.getPrefix());
			ps.setString(6, museum.getStreet());
			ps.setString(7, museum.getHouseNumber());
			ps.setString(8, museum.getLocalNumber());
			//tu poprawic tostring
			ps.setString(9, museum.getAddDate().toString());
			ps.setString(10, museum.getStatus());
			ps.execute();
		}

		
	}

	
	public void create(List<Museum> museums) throws Exception {
		//to dac commit
	}
	
	@Override
	public void createTable() throws Exception {
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(CREATE_TABLE_STMT);
			ps.execute();
		}
		
	}

}
