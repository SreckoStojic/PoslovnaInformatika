package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Valuta extends Model {

	@Column(nullable = false)
	public int sifra;
	@Column(nullable = false, length = 3)
	public String zvanicnaSifra;
	@Column(nullable = false, length = 30)
	public String naziv;
	@Column(nullable = false)
	public Boolean domicilna;
	@ManyToOne
	public Drzava drzava;
	@OneToMany(mappedBy = "osnovnaValuta")
	public List<KursUValuti> osnovnaValuta;
	@OneToMany(mappedBy = "premaValuti")
	public List<KursUValuti> premaValuti;
	@OneToMany(mappedBy = "valuta")
	public List<RacunPravnihLica> racuni;
	@OneToMany(mappedBy="valuta")
	public List<AnalitikaIzvoda> analitikeIzvoda;
	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	public String getZvanicnaSifra() {
		return zvanicnaSifra;
	}
	public void setZvanicnaSifra(String zvanicnaSifra) {
		this.zvanicnaSifra = zvanicnaSifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Boolean getDomicilna() {
		return domicilna;
	}
	public void setDomicilna(Boolean domicilna) {
		this.domicilna = domicilna;
	}
	public Drzava getDrzava() {
		return drzava;
	}
	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
	public List<KursUValuti> getOsnovnaValuta() {
		return osnovnaValuta;
	}
	public void setOsnovnaValuta(List<KursUValuti> osnovnaValuta) {
		this.osnovnaValuta = osnovnaValuta;
	}
	public List<KursUValuti> getPremaValut() {
		return premaValuti;
	}
	public void setPremaValut(List<KursUValuti> premaValuti) {
		this.premaValuti = premaValuti;
	}
	public List<RacunPravnihLica> getRacuni() {
		return racuni;
	}
	public void setRacuni(List<RacunPravnihLica> racuni) {
		this.racuni = racuni;
	}
	public List<AnalitikaIzvoda> getAnalitikeIzvoda() {
		return analitikeIzvoda;
	}
	public void setAnalitikeIzvoda(List<AnalitikaIzvoda> analitikeIzvoda) {
		this.analitikeIzvoda = analitikeIzvoda;
	}
	
	
}
