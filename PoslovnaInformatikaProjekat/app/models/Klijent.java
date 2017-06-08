package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Klijent extends Model {

	@Column(nullable = false, length = 30)
	public String ime;
	@Column(nullable = false, length = 30)
	public String prezime;
	@Column(nullable = false)
	public Boolean pravnoLice;
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
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}
	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}
	public Boolean getPravnoLice() {
		return pravnoLice;
	}
	public void setPravnoLice(Boolean pravnoLice) {
		this.pravnoLice = pravnoLice;
	}
	
	
	
}
