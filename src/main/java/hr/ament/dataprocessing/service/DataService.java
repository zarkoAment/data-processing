package hr.ament.dataprocessing.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.MappingStrategy;
import hr.ament.dataprocessing.domain.Person;
import hr.ament.dataprocessing.utils.CsvTransfer;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DataService {
	
	public List<Person> getPersons () throws Exception {
		
		return personBuilder(Paths.get(ClassLoader.getSystemResource("csv/persons.csv").toURI()),Person.class);
	}

	private List<Person> personBuilder(Path path, Class<Person> clazz) throws Exception {
		CsvTransfer csvTransfer = new CsvTransfer();
		MappingStrategy<Person> ms = new HeaderColumnNameMappingStrategy<>();
		ms.setType(clazz);
		
		Reader reader = Files.newBufferedReader(path);
		CsvToBean<Person> cb = new CsvToBeanBuilder<Person>(reader)
				.withType(clazz)
				.withSeparator(',')
				.withMappingStrategy(ms)
				.build();
		
		csvTransfer.setCsvList(cb.parse());
		reader.close();

		return csvTransfer.getCsvList();
	}
}
