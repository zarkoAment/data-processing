package hr.ament.dataprocessing.domain;

import com.opencsv.bean.CsvBindByName;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PERSON_TABLE")
@Data
public class Person {
	
	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@CsvBindByName(column = "Ime")
	@Column (name = "PERSON_NAME", length = 100)
	private String name;
	
	@CsvBindByName(column = "Prezime")
	@Column (name = "PERSON_SURNAME", length = 100)
	private String surname;
	
	@CsvBindByName(column = "DatumRodjenja")
	@Column (name = "PERSON_DATE_OF_BIRTH")
	private Date dateOfBirth;
	
	
	public Person(){
	
	}
}
