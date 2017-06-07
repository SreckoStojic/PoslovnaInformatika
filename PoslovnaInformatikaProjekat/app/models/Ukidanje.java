package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Ukidanje extends Model{

	@Column (nullable=false)
	public int sifra;
	@Column (nullable=false)
	public Date datumUkidanja;
	@Column (nullable=false, length=20)
	public String prenosenjeNaRacun;
	@ManyToOne
	public RacunPravnihLica racun;
	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	public Date getDatumUkidanja() {
		return datumUkidanja;
	}
	public void setDatumUkidanja(Date datumUkidanja) {
		this.datumUkidanja = datumUkidanja;
	}
	public String getPrenosenjeNaRacun() {
		return prenosenjeNaRacun;
	}
	public void setPrenosenjeNaRacun(String prenosenjeNaRacun) {
		this.prenosenjeNaRacun = prenosenjeNaRacun;
	}
	public RacunPravnihLica getRacun() {
		return racun;
	}
	public void setRacun(RacunPravnihLica racun) {
		this.racun = racun;
	}
	
	
}
