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
@XmlRootElement(name = "NaseljenoMesto")
@Entity
public class NaseljenoMesto extends Model {

	@Column(nullable = false, length = 2)
	public String oznaka;
	@Column(nullable = false, length = 60)
	public String naziv;
	@Column(nullable = false, length = 12)
	public String postanskiBroj;
	@ManyToOne
	public Drzava drzava;
	@OneToMany(mappedBy = "mestoPrijema")
	public List<AnalitikaIzvoda> analitikeIzvoda;
	
	public String getOznaka() {
		return oznaka;
	}
	@XmlElement(name = "OznakaNaseljenogMesta")
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public String getNaziv() {
		return naziv;
	}
	@XmlElement(name = "NazivNaseljenogMesta")
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getPostanskiBroj() {
		return postanskiBroj;
	}
	@XmlElement(name = "PTTNaseljenogMesta")
	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}
	public Drzava getDrzava() {
		return drzava;
	}
	@XmlElement(name = "DrzavaNaseljenogMesta")
	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
	public List<AnalitikaIzvoda> getAnalitikeIzvoda() {
		return analitikeIzvoda;
	}
	@XmlElement(name = "ObavljeneAnalitikeIzvoda")
	public void setAnalitikeIzvoda(List<AnalitikaIzvoda> analitikeIzvoda) {
		this.analitikeIzvoda = analitikeIzvoda;
	}
	
	
}
