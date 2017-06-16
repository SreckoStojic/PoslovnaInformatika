package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import play.db.jpa.Model;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "Klijent")
@Entity
public class Klijent extends Model {

	@Column(length = 30)
	public String adresa;
	@ManyToOne
	public NaseljenoMesto naseljenoMesto;
	@OneToMany(mappedBy = "klijent")
	public List<RacunPravnihLica> racuni;
	
	public List<RacunPravnihLica> getRacuni() {
		return racuni;
	}
	//@XmlElement(name = "RacuniKlijenta")
	@XmlTransient
	public void setRacuni(List<RacunPravnihLica> racuni) {
		this.racuni = racuni;
	}
	
	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}
	@XmlElement(name = "NaseljenoMestoKlijenta")
	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}
	public String getAdresa() {
		return adresa;
	}
	@XmlElement(name = "AdresaKlijenta")
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
}
