package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Banka extends Model {

	@Column(nullable = false)
	public Integer oznaka;
	@Column(nullable = false, length = 3)
	public String sifra;
	@Column(nullable = false, length = 10)
	public String pib;
	@Column(nullable = false, length = 120)
	public String naziv;
	@Column(nullable = false, length = 120)
	public String adresa;
	@Column(nullable = true, length = 128)
	public String email;
	@Column(nullable = true, length = 128)
	public String web;
	@Column(nullable = true, length = 20)
	public String telefon;
	@Column(nullable = true, length = 20)
	public String fax;
	@Column(nullable = false)
	public Boolean banka;
	@OneToMany(mappedBy = "banka")
	public List<KursnaLista> kursnaLista;
	@OneToMany(mappedBy = "banka")
	public List<RacunPravnihLica> racuni;
	public Integer getOznaka() {
		return oznaka;
	}
	public void setOznaka(Integer oznaka) {
		this.oznaka = oznaka;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getPib() {
		return pib;
	}
	public void setPib(String pib) {
		this.pib = pib;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public Boolean getBanka() {
		return banka;
	}
	public void setBanka(Boolean banka) {
		this.banka = banka;
	}
	public List<KursnaLista> getKursnaLista() {
		return kursnaLista;
	}
	public void setKursnaLista(List<KursnaLista> kursnaLista) {
		this.kursnaLista = kursnaLista;
	}
	public List<RacunPravnihLica> getRacuni() {
		return racuni;
	}
	public void setRacuni(List<RacunPravnihLica> racuni) {
		this.racuni = racuni;
	}
	
	
}
