package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class RacunPravnihLica extends Model {

	@Column(nullable = false)
	public Long sifra;
	@Column(nullable = false, length = 18)
	public String brojRacuna;
	@Column(nullable = false)
	public Date datumOtvaranja;
	@Column(nullable = false)
	public Boolean vazeci;
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

	public Long getSifra() {
		return sifra;
	}

	public void setSifra(Long sifra) {
		this.sifra = sifra;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public Date getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(Date datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}

	public Boolean getVazeci() {
		return vazeci;
	}

	public void setVazeci(Boolean vazeci) {
		this.vazeci = vazeci;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	public Klijent getKlijent() {
		return klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public List<Ukidanje> getUkidanjeRacuna() {
		return ukidanjeRacuna;
	}

	public void setUkidanjeRacuna(List<Ukidanje> ukidanjeRacuna) {
		this.ukidanjeRacuna = ukidanjeRacuna;
	}

	public List<DnevnoStanjeRacuna> getStanjeRacuna() {
		return stanjeRacuna;
	}

	public void setStanjeRacuna(List<DnevnoStanjeRacuna> stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}
}
