package models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Drzava extends Model {

	@Column(nullable = false, precision = 3, scale = 0)
	public Number oznaka;
	@Column(nullable = false, length = 40)
	public String naziv;
	@OneToMany(mappedBy = "drzava")
	public List<NaseljenoMesto> naseljenaMesta;
	@OneToMany(mappedBy = "drzava")
	public List<Valuta> drzavneValute;
	public Number getOznaka() {
		return oznaka;
	}
	public void setOznaka(Number oznaka) {
		this.oznaka = oznaka;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<NaseljenoMesto> getNaseljenaMesta() {
		return naseljenaMesta;
	}
	public void setNaseljenaMesta(List<NaseljenoMesto> naseljenaMesta) {
		this.naseljenaMesta = naseljenaMesta;
	}
	public List<Valuta> getDrzavneValute() {
		return drzavneValute;
	}
	public void setDrzavneValute(List<Valuta> drzavneValute) {
		this.drzavneValute = drzavneValute;
	}
	
	

}
