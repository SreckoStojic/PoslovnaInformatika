package models;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@XmlRootElement(name = "RacunPravnihLica")
@Entity
public class RacunPravnihLica extends Model {

	@Column(nullable = false, length = 18)
	public String brojRacuna;
	@Column(nullable = false)
	Date datumOtvaranja = new Date();
	@Column(nullable = false)
	public Boolean vazeci = true;
	@ManyToOne
	public Banka banka;
	@ManyToOne
	public Klijent klijent;
	@ManyToOne
	public Valuta valuta;
	@OneToMany(mappedBy = "racun")
	public List<Ukidanje> ukidanjeRacuna;
	@OneToMany(mappedBy = "racun")
	public List<DnevnoStanjeRacuna> stanjeRacuna;

	

	public String getBrojRacuna() {
		return brojRacuna;
	}

	@XmlElement(name = "BrojRacunaPL")
	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Date getDatumOtvaranja() {
		return datumOtvaranja;
	}

	@XmlElement(name = "DatumOtvaranjaRAcuna")
	public void setDatumOtvaranja(Date datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}

	public Boolean getVazeci() {
		return vazeci;
	}

	@XmlElement(name = "VazeciJeRacun")
	public void setVazeci(Boolean vazeci) {
		this.vazeci = vazeci;
	}

	public Banka getBanka() {
		return banka;
	}

	@XmlElement(name = "OtvorenUBanci")
	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	public Klijent getKlijent() {
		return klijent;
	}

	//@XmlElement(name = "VlasnikRacuna")
	@XmlTransient
	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public Valuta getValuta() {
		return valuta;
	}

	@XmlElement(name = "ValutaRacuna")
	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public List<Ukidanje> getUkidanjeRacuna() {
		return ukidanjeRacuna;
	}

	//@XmlElement(name = "UkidanjeRacuna")
	@XmlTransient
	public void setUkidanjeRacuna(List<Ukidanje> ukidanjeRacuna) {
		this.ukidanjeRacuna = ukidanjeRacuna;
	}

	public List<DnevnoStanjeRacuna> getStanjeRacuna() {
		return stanjeRacuna;
	}

	//@XmlElement(name = "StanjeRacunaPL")
	@XmlTransient
	public void setStanjeRacuna(List<DnevnoStanjeRacuna> stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}
	
	public String formatDate(Date datum){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(datum);
	}
	
	public static RacunPravnihLica pronadjiBrojRacuna(String brojRacuna){
		RacunPravnihLica racun = RacunPravnihLica.find("brojRacuna = ?", brojRacuna).first();
		return racun;
	}
}
