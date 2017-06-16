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
@XmlRootElement(name = "Drzava")
@Entity
public class Drzava extends Model {

	@Column(nullable = false, length = 3)
	public String oznaka;
	@Column(nullable = false, length = 40)
	public String naziv;
	@OneToMany(mappedBy = "drzava")
	public List<NaseljenoMesto> naseljenaMesta;
	@OneToMany(mappedBy = "drzava")
	public List<Valuta> drzavneValute;
	
	public String getOznaka() {
		return oznaka;
	}
	@XmlElement(name = "OznakaDrzave")
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public String getNaziv() {
		return naziv;
	}
	@XmlElement(name = "NazivDrzave")
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<NaseljenoMesto> getNaseljenaMesta() {
		return naseljenaMesta;
	}
	@XmlTransient
	public void setNaseljenaMesta(List<NaseljenoMesto> naseljenaMesta) {
		this.naseljenaMesta = naseljenaMesta;
	}
	public List<Valuta> getDrzavneValute() {
		return drzavneValute;
	}
	//@XmlElement(name = "ValuteUDrzavi")
	@XmlTransient
	public void setDrzavneValute(List<Valuta> drzavneValute) {
		this.drzavneValute = drzavneValute;
	}
	
	

}
