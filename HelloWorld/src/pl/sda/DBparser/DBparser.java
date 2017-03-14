package pl.sda.DBparser;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Iterator;
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

		
		File source = Paths.get(System.getProperty("user.home"), "Desktop", "museums.csv").toFile();
		Reader in = new FileReader(source);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withDelimiter(';').withHeader().parse(in);
		
		MuseumSQLiteConnectionMenager museumSQLiteConnectionMenager = new MuseumSQLiteConnectionMenager();
		MuseumDAO museumDAO = new MuseumDAOJdbcSQLiteIpml(museumSQLiteConnectionMenager);
		museumDAO.createTable();
		
		List<Museum> museums = new LinkedList<>();
		
		Iterator<CSVRecord> rec = records.iterator();
		rec.next();
		while(rec.hasNext()){
			
		}
		

	}

}
