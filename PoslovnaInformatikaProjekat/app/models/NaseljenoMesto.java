package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class NaseljenoMesto extends Model {

	@Column(nullable = false)
	public int oznaka;
	@Column(nullable = false, length = 60)
	public String naziv;
	@Column(nullable = false, length = 12)
	public String postanskiBroj;
	@ManyToOne
	public Drzava drzava;
	@OneToMany(mappedBy = "mestoPrijema")
	public List<AnalitikaIzvoda> analitikeIzvoda;
	public int getOznaka() {
		return oznaka;
	}
	public void setOznaka(int oznaka) {
		this.oznaka = oznaka;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getPostanskiBroj() {
		return postanskiBroj;
	}
	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public Drzava getDrzava() {
		return drzava;
	}
	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
	public List<AnalitikaIzvoda> getAnalitikeIzvoda() {
		return analitikeIzvoda;
	}
	public void setAnalitikeIzvoda(List<AnalitikaIzvoda> analitikeIzvoda) {
		this.analitikeIzvoda = analitikeIzvoda;
	}
	
	
}
