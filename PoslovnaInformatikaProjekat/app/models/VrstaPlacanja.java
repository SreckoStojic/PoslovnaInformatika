package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import play.db.jpa.Model;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "VrstaPlacanja")
@Entity
public class VrstaPlacanja extends Model {

	@Column(nullable = false, length = 120)
	public String naziv;
	@OneToMany(mappedBy = "vrstaPlacanja")
	public List<AnalitikaIzvoda> analitikeIzvoda;
	
	public String getNaziv() {
		return naziv;
	}
	@XmlElement(name = "NazivVrsePlacanja")
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<AnalitikaIzvoda> getAnalitikeIzvoda() {
		return analitikeIzvoda;
	}
	//@XmlElement(name = "AnalitikeIzvodaVP")
	@XmlTransient
	public void setAnalitikeIzvoda(List<AnalitikaIzvoda> analitikeIzvoda) {
		this.analitikeIzvoda = analitikeIzvoda;
	}
	
	

}
