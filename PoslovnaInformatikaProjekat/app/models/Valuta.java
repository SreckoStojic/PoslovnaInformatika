package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import play.db.jpa.Model;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "Valuta")
@Entity
public class Valuta extends Model {
	
	@Column(nullable = false, length = 3)
	public String oznaka;
	@Column(nullable = false)
	public Integer zvanicnaSifra;
	@Column(nullable = false, length = 30)
	public String naziv;
	@Column(nullable = false)
	public Boolean domicilna = false;
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
	
	
	public String getOznaka() {
		return oznaka;
	}
	@XmlElement(name = "OznakaValute")
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public List<KursUValuti> getPremaValuti() {
		return premaValuti;
	}
	@XmlElement(name = "KurseviPremaValutama")
	public void setPremaValuti(List<KursUValuti> premaValuti) {
		this.premaValuti = premaValuti;
	}
	public Integer getZvanicnaSifra() {
		return zvanicnaSifra;
	}
	@XmlElement(name = "SifraValute")
	public void setZvanicnaSifra(Integer zvanicnaSifra) {
		this.zvanicnaSifra = zvanicnaSifra;
	}
	public String getNaziv() {
		return naziv;
	}
	@XmlElement(name = "NazivValute")
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Boolean getDomicilna() {
		return domicilna;
	}
	@XmlElement(name = "Domicilna")
	public void setDomicilna(Boolean domicilna) {
		this.domicilna = domicilna;
	}
	public Drzava getDrzava() {
		return drzava;
	}
	@XmlElement(name = "DrzavaValute")
	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
	public List<KursUValuti> getOsnovnaValuta() {
		return osnovnaValuta;
	}
	@XmlElement(name = "OsnovnaJeValuta")
	public void setOsnovnaValuta(List<KursUValuti> osnovnaValuta) {
		this.osnovnaValuta = osnovnaValuta;
	}
	public List<RacunPravnihLica> getRacuni() {
		return racuni;
	}
	@XmlElement(name = "RacuniValuta")
	public void setRacuni(List<RacunPravnihLica> racuni) {
		this.racuni = racuni;
	}
	public List<AnalitikaIzvoda> getAnalitikeIzvoda() {
		return analitikeIzvoda;
	}
	@XmlElement(name = "AnalitikeIzvodaValuta")
	public void setAnalitikeIzvoda(List<AnalitikaIzvoda> analitikeIzvoda) {
		this.analitikeIzvoda = analitikeIzvoda;
	}
	
	
}
