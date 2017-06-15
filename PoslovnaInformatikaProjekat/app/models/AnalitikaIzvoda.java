package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ManyToAny;

import play.db.jpa.Model;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "AnalitikaIzvoda")
@Entity
public class AnalitikaIzvoda extends Model {

	@Column(nullable = false, length = 256)
	public String duznik;
	@Column(nullable = false, length = 256)
	public String svrhaPlacanja;
	@Column(nullable = false, length = 256)
	public String poverilac;
	@Column(nullable = false)
	public Date datumPrijema;
	@Column(nullable = false)
	public Date datumValute;
	@Column(nullable = true, length = 18)
	public String racunDuznika;
	@Column(nullable = true)
	public int modelZaduzenja;
	@Column(nullable = true, length = 20)
	public String pozivNaBrZaduzenja;
	@Column(nullable = true, length = 20)
	public String racunPoverioca;
	@Column(nullable = true)
	public int modelOdobrenja;
	@Column(nullable = true, length = 20)
	public String pozivNaBrOdobrenja;
	@Column(nullable = false)
	public Boolean hitno = false;
	@Column(nullable = false, precision = 15, scale = 2)
	public BigDecimal iznos;
	@Column(nullable = true, precision = 1, scale = 0)
	public Number tipGreske;
	@Column(nullable = true, length = 1)
	public char status;
	@ManyToOne
	public DnevnoStanjeRacuna stanjeRacuna;
	@ManyToOne (optional=true)
	public NaseljenoMesto mestoPrijema;
	@ManyToOne(optional=true)
	public Valuta valuta;
	@ManyToOne(optional=true)
	public VrstaPlacanja vrstaPlacanja;
	
	public String getDuznik() {
		return duznik;
	}
	@XmlElement(name = "Duznik")
	public void setDuznik(String duznik) {
		this.duznik = duznik;
	}
	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}
	@XmlElement(name = "SvrhaPlacanja")
	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}
	public String getPoverilac() {
		return poverilac;
	}
	@XmlElement(name = "Poverilac")
	public void setPoverilac(String poverilac) {
		this.poverilac = poverilac;
	}
	public Date getDatumPrijema() {
		return datumPrijema;
	}
	@XmlElement(name = "DatumPrijema")
	public void setDatumPrijema(Date datumPrijema) {
		this.datumPrijema = datumPrijema;
	}
	public Date getDatumValute() {
		return datumValute;
	}
	@XmlElement(name = "DatumValute")
	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}
	public String getRacunDuznika() {
		return racunDuznika;
	}
	@XmlElement(name = "RacunDuznika")
	public void setRacunDuznika(String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}
	public int getModelZaduzenja() {
		return modelZaduzenja;
	}
	@XmlElement(name = "ModelZaduzenja")
	public void setModelZaduzenja(int modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}
	public String getPozivNaBrZaduzenja() {
		return pozivNaBrZaduzenja;
	}
	@XmlElement(name = "PozivNaBrZaduzenja")
	public void setPozivNaBrZaduzenja(String pozivNaBrZaduzenja) {
		this.pozivNaBrZaduzenja = pozivNaBrZaduzenja;
	}
	public String getRacunPoverioca() {
		return racunPoverioca;
	}
	@XmlElement(name = "RacunPoverioca")
	public void setRacunPoverioca(String racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}
	public int getModelOdobrenja() {
		return modelOdobrenja;
	}
	@XmlElement(name = "ModelOdobrenja")
	public void setModelOdobrenja(int modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}
	public String getPozivNaBrOdobrenja() {
		return pozivNaBrOdobrenja;
	}
	@XmlElement(name = "PozivNaBrOdobrenja")
	public void setPozivNaBrOdobrenja(String pozivNaBrOdobrenja) {
		this.pozivNaBrOdobrenja = pozivNaBrOdobrenja;
	}
	public Boolean getHitno() {
		return hitno;
	}
	@XmlElement(name = "Hitno")
	public void setHitno(Boolean hitno) {
		this.hitno = hitno;
	}
	public BigDecimal getIznos() {
		return iznos;
	}
	@XmlElement(name = "IznosIzvod")
	public void setIznos(BigDecimal iznos) {
		this.iznos = iznos;
	}
	public Number getTipGreske() {
		return tipGreske;
	}
	@XmlElement(name = "TipGreske")
	public void setTipGreske(Number tipGreske) {
		this.tipGreske = tipGreske;
	}
	public char getStatus() {
		return status;
	}
	@XmlElement(name = "StatusIzvoda")
	public void setStatus(char status) {
		this.status = status;
	}
	public DnevnoStanjeRacuna getStanjeRacuna() {
		return stanjeRacuna;
	}
	@XmlElement(name = "StanjeRacunaIzvod")
	public void setStanjeRacuna(DnevnoStanjeRacuna stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}
	public NaseljenoMesto getMestoPrijema() {
		return mestoPrijema;
	}
	@XmlElement(name = "MestoPrijema")
	public void setMestoPrijema(NaseljenoMesto mestoPrijema) {
		this.mestoPrijema = mestoPrijema;
	}
	public Valuta getValuta() {
		return valuta;
	}
	@XmlElement(name = "ValutaIzvoda")
	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}
	public VrstaPlacanja getVrstaPlacanja() {
		return vrstaPlacanja;
	}
	@XmlElement(name = "VrstaPlacanjaIzvod")
	public void setVrstaPlacanja(VrstaPlacanja vrstaPlacanja) {
		this.vrstaPlacanja = vrstaPlacanja;
	}
}
