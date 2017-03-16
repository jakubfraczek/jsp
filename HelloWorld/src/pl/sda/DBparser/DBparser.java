package pl.sda.DBparser;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import pl.sda.DAO.MuseumDAO;
import pl.sda.DAO.MuseumDAOJdbcSQLiteIpml;
import pl.sda.DAO.MuseumSQLiteConnectionMenager;
import pl.sda.model.Museum;

public class DBparser {

	public static void main(String[] args) throws Exception {

		System.out.println("-----Program Begin-----");

		File source = Paths.get(System.getProperty("user.home"), "Desktop", "museums.csv").toFile();
		Reader in = new FileReader(source);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withDelimiter(';').withHeader().parse(in);

		MuseumSQLiteConnectionMenager museumSQLiteConnectionMenager = new MuseumSQLiteConnectionMenager();
		MuseumDAO museumDAO = new MuseumDAOJdbcSQLiteIpml(museumSQLiteConnectionMenager);
		museumDAO.dropTable();
		museumDAO.createTable();

		List<Museum> museums = new LinkedList<>();
		for (CSVRecord r : records) {
			String date = null;
			if (!r.get(9).isEmpty() && r.get(9).length() > 10) {
				date = r.get(9).substring(0, 10);
			} else {
				date = r.get(9);
			}
			museums.add(new Museum(r.get(0), r.get(1), r.get(2), r.get(3), r.get(4), r.get(5), r.get(6), r.get(7),
					r.get(8), date, r.get(10)));
		}
		museumDAO.create(museums);

		System.out.println("-----Program End-----");

	}

}
