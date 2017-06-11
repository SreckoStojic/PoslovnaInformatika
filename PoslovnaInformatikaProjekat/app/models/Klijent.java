package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

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
	public void setRacuni(List<RacunPravnihLica> racuni) {
		this.racuni = racuni;
	}
	
	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}
	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
}
