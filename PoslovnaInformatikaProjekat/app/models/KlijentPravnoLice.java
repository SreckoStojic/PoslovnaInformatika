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

@XmlRootElement(name = "KlijentPL")
@Entity
public class KlijentPravnoLice extends Klijent {

	@Column(nullable = true, length = 30)
	public String naziv;
	
	public String getNaziv() {
		return naziv;
	}
	@XmlElement(name = "NazivKlijentaPL")
	public void setNaziv(String naziv) {
		this.naziv= naziv;
	}
	
}
