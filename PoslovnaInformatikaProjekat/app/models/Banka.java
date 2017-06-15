package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import play.db.jpa.Model;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "Banka")
@Entity
public class Banka extends Model {

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
	public Boolean banka = false;
	@OneToMany(mappedBy = "banka")
	public List<KursnaLista> kursnaLista;
	@OneToMany(mappedBy = "banka")
	public List<RacunPravnihLica> racuni;
	
	
	public String getSifra() {
		return sifra;
	}
	@XmlElement(name = "SifraBanke")
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getPib() {
		return pib;
	}
	@XmlElement(name = "PibBanke")
	public void setPib(String pib) {
		this.pib = pib;
	}
	public String getNaziv() {
		return naziv;
	}
	@XmlElement(name = "NazivBanke")
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	@XmlElement(name = "AdresaBanke")
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getEmail() {
		return email;
	}
	@XmlElement(name = "EmailBanke")
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeb() {
		return web;
	}
	@XmlElement(name = "WebBanke")
	public void setWeb(String web) {
		this.web = web;
	}
	public String getTelefon() {
		return telefon;
	}
	@XmlElement(name = "TelefonBanke")
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getFax() {
		return fax;
	}
	@XmlElement(name = "FaxBanke")
	public void setFax(String fax) {
		this.fax = fax;
	}
	public Boolean getBanka() {
		return banka;
	}
	@XmlElement(name = "CentralnaBanka")
	public void setBanka(Boolean banka) {
		this.banka = banka;
	}
	public List<KursnaLista> getKursnaLista() {
		return kursnaLista;
	}
	@XmlElement(name = "KursnaListaBanke")
	public void setKursnaLista(List<KursnaLista> kursnaLista) {
		this.kursnaLista = kursnaLista;
	}
	public List<RacunPravnihLica> getRacuni() {
		return racuni;
	}
	@XmlElement(name = "RacuniKlijenataBanke")
	public void setRacuni(List<RacunPravnihLica> racuni) {
		this.racuni = racuni;
	}
	
	
}
