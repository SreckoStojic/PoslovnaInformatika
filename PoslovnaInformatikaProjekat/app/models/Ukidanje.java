package models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import play.db.jpa.Model;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "UkidanjeRacuna")
@Entity
public class Ukidanje extends Model{

	@Column (nullable=false)
	public Date datumUkidanja;
	@Column (nullable=false, length=20)
	public String prenosenjeNaRacun;
	@ManyToOne
	public RacunPravnihLica racun;
	
	
	public Date getDatumUkidanja() {
		return datumUkidanja;
	}
	@XmlElement(name = "DatumUkidanjaRacuna")
	public void setDatumUkidanja(Date datumUkidanja) {
		this.datumUkidanja = datumUkidanja;
	}
	public String getPrenosenjeNaRacun() {
		return prenosenjeNaRacun;
	}
	@XmlElement(name = "PrenosenjeNaRAcun")
	public void setPrenosenjeNaRacun(String prenosenjeNaRacun) {
		this.prenosenjeNaRacun = prenosenjeNaRacun;
	}
	public RacunPravnihLica getRacun() {
		return racun;
	}
	@XmlElement(name = "RacunZaUkidanje")
	public void setRacun(RacunPravnihLica racun) {
		this.racun = racun;
	}
	public String formatDate(Date datum){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(datum);
	}
	
	
}
