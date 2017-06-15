package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import play.db.jpa.Model;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "KlijentFL")
@Entity
public class KlijentFizickoLice extends Klijent {

	@Column(nullable = true, length = 30)
	public String ime;
	@Column(nullable = true, length = 30)
	public String prezime;
	
	
	public String getIme() {
		return ime;
	}
	@XmlElement(name = "ImeKlijenta")
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	@XmlElement(name = "PrezimeKlijenta")
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
	
}
