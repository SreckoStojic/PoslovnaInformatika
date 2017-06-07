package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Klijent extends Model {

	@Column(nullable = false)
	public Integer oznaka;
	@Column(nullable = true, length = 120)
	public String naziv;
	@OneToMany(mappedBy = "klijent")
	public List<RacunPravnihLica> racuni;
	public Integer getOznaka() {
		return oznaka;
	}
	public void setOznaka(Integer oznaka) {
		this.oznaka = oznaka;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<RacunPravnihLica> getRacuni() {
		return racuni;
	}
	public void setRacuni(List<RacunPravnihLica> racuni) {
		this.racuni = racuni;
	}
	
	
}
