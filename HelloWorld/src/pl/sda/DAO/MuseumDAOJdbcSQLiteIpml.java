package pl.sda.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pl.sda.model.Museum;

public class MuseumDAOJdbcSQLiteIpml implements MuseumDAO {
	private final String CREATE_TABLE_STMT = "Create table museums(id int, Name varchar(300), PostalCode varchar(6), City varchar(30), Prefix varchar(3), Street varchar(100), NouseNumber varchar(5), LocalNumber varchar(5), Owner varchar(100), AddDate varchar(10), Status varchar(30))";
	private final String DELETE_TABLE_STMT = "DROP TABLE IF EXISTS museums";
	private final String INSERT_STM = "INSERT INTO museums(id, Name, PostalCode, City, Prefix, Street, NouseNumber, LocalNumber, Owner, AddDate, Status) values(?,?,?,?,?,?,?,?,?,?,?)";
	private final String SELECT_ALL_SMT = "SELECT * FROM museums";

	public String selectSMT(String column){
		return "SELECT * FROM museums WHERE " + column +" = ?";
	}
	
	private MuseumSQLiteConnectionMenager museumSQLiteConnectionMenager;

	public MuseumDAOJdbcSQLiteIpml(MuseumSQLiteConnectionMenager museumSQLiteConnectionMenager) {
		this.museumSQLiteConnectionMenager = museumSQLiteConnectionMenager;
	}

	@Override
	public void add(Museum museum) throws Exception {
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
			ps.setString(9, museum.getOwner());
			ps.setString(10, museum.getAddDate());
			ps.setString(11, museum.getStatus());
			ps.execute();
		}

	}

	@Override
	public void create(List<Museum> museums) throws Exception {
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement ps = conn.prepareStatement(INSERT_STM)) {
				for (Museum m : museums) {
					ps.setInt(1, m.getid());
					ps.setString(2, m.getMseumName());
					ps.setString(3, m.getPostalCode());
					ps.setString(4, m.getCity());
					ps.setString(5, m.getPrefix());
					ps.setString(6, m.getStreet());
					ps.setString(7, m.getHouseNumber());
					ps.setString(8, m.getLocalNumber());
					ps.setString(9, m.getOwner());
					ps.setString(10, m.getAddDate());
					ps.setString(11, m.getStatus());

					ps.addBatch();
				}
				ps.executeBatch();
			} catch (SQLException e) {
				conn.rollback();
			}
			conn.commit();
		}
	}

	@Override
	public void createTable() throws Exception {
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(CREATE_TABLE_STMT);
			ps.execute();
		}
	}
	
	@Override
	public void dropTable() throws Exception{
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(DELETE_TABLE_STMT);
			ps.execute();
		}
	}

	private Museum mapFromResult(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String mseumName = rs.getString(2);
		String postalCode = rs.getString(3);
		String city = rs.getString(4);
		String prefix = rs.getString(5);
		String street = rs.getString(6);
		String houseNumber = rs.getString(7);
		String localNumber = rs.getString(8);
		String owner = rs.getString(9);
		String addDate = rs.getString(10);
		String status = rs.getString(11);
		return new Museum(id, mseumName, postalCode, city, prefix, street, houseNumber, localNumber, owner, addDate,
				status);
	}

	@Override
	public List<Museum> getById(int id) throws Exception {
		List<Museum> museums = new LinkedList<>();
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(selectSMT("id"));
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				museums.add(mapFromResult(rs));
			}
		}
		return museums;
	}

	@Override
	public List<Museum> getByName(String museumName) throws Exception {
		List<Museum> museums = new LinkedList<>();
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(selectSMT("name"));
			ps.setString(1, museumName);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				museums.add(mapFromResult(rs));
			}
		}
		return museums;
	}

	@Override
	public List<Museum> getByPostal(String postalCode) throws Exception {
		List<Museum> museums = new LinkedList<>();
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(selectSMT("PostalCode"));
			ps.setString(1, postalCode);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				museums.add(mapFromResult(rs));
			}
		}
		return museums;
	}

	@Override
	public List<Museum> getByCity(String city) throws Exception {
		List<Museum> museums = new LinkedList<>();
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("City");
			ps.setString(1, city);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				museums.add(mapFromResult(rs));
			}
		}
		return museums;
	}

	@Override
	public List<Museum> getByStreet(String street) throws Exception {
		List<Museum> museums = new LinkedList<>();
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(selectSMT("Street"));
			ps.setString(1, street);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				museums.add(mapFromResult(rs));
			}
		}
		return museums;
	}

	@Override
	public List<Museum> getByOwner(String owner) throws Exception {
		List<Museum> museums = new LinkedList<>();
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(selectSMT("Owner"));
			ps.setString(1, owner);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				museums.add(mapFromResult(rs));
			}
		}
		return museums;
	}

	@Override
	public List<Museum> getByDate(String addDate) throws Exception {
		List<Museum> museums = new LinkedList<>();
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(selectSMT("AddDate"));
			ps.setString(1, addDate);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				museums.add(mapFromResult(rs));
			}
		}
		return museums;
	}

	@Override
	public List<Museum> getByStatus(String status) throws Exception {
		List<Museum> museums = new LinkedList<>();
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(selectSMT("Status"));
			ps.setString(1, status);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				museums.add(mapFromResult(rs));
			}
		}
		return museums;
	}

	@Override
	public List<Museum> getAll() throws Exception {
		List<Museum> museums = new LinkedList<>();
		try (Connection conn = museumSQLiteConnectionMenager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SMT);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				museums.add(mapFromResult(rs));
			}
		}
		return museums;
	}

}
