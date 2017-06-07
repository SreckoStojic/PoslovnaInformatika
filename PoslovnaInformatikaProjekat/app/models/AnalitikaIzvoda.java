package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import play.db.jpa.Model;

@Entity
public class AnalitikaIzvoda extends Model {

	@Column(nullable = false)
	public Long brojStavke;
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
	@Column(nullable = true, precision = 2, scale = 0)
	public Number modelZaduzenja;
	@Column(nullable = true, length = 20)
	public String pozivNaBrZaduzenja;
	@Column(nullable = true, length = 20)
	public String racunPoverioca;
	@Column(nullable = true, precision = 2, scale = 0)
	public Number modelOdobrenja;
	@Column(nullable = true, length = 20)
	public String pozivNaBrOdobrenja;
	@Column(nullable = false)
	public Boolean hitno;
	@Column(nullable = false, precision = 15, scale = 2)
	public BigDecimal iznos;
	@Column(nullable = false, precision = 1, scale = 0)
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
	public VrstePlacanja vrstaPlacanja;
	public Long getBrojStavke() {
		return brojStavke;
	}
	public void setBrojStavke(Long brojStavke) {
		this.brojStavke = brojStavke;
	}
	public String getDuznik() {
		return duznik;
	}
	public void setDuznik(String duznik) {
		this.duznik = duznik;
	}
	public String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}
	public void setSvrhaPlacanja(String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}
	public String getPoverilac() {
		return poverilac;
	}
	public void setPoverilac(String poverilac) {
		this.poverilac = poverilac;
	}
	public Date getDatumPrijema() {
		return datumPrijema;
	}
	public void setDatumPrijema(Date datumPrijema) {
		this.datumPrijema = datumPrijema;
	}
	public Date getDatumValute() {
		return datumValute;
	}
	public void setDatumValute(Date datumValute) {
		this.datumValute = datumValute;
	}
	public String getRacunDuznika() {
		return racunDuznika;
	}
	public void setRacunDuznika(String racunDuznika) {
		this.racunDuznika = racunDuznika;
	}
	public Number getModelZaduzenja() {
		return modelZaduzenja;
	}
	public void setModelZaduzenja(Number modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}
	public String getPozivNaBrZaduzenja() {
		return pozivNaBrZaduzenja;
	}
	public void setPozivNaBrZaduzenja(String pozivNaBrZaduzenja) {
		this.pozivNaBrZaduzenja = pozivNaBrZaduzenja;
	}
	public String getRacunPoverioca() {
		return racunPoverioca;
	}
	public void setRacunPoverioca(String racunPoverioca) {
		this.racunPoverioca = racunPoverioca;
	}
	public Number getModelOdobrenja() {
		return modelOdobrenja;
	}
	public void setModelOdobrenja(Number modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}
	public String getPozivNaBrOdobrenja() {
		return pozivNaBrOdobrenja;
	}
	public void setPozivNaBrOdobrenja(String pozivNaBrOdobrenja) {
		this.pozivNaBrOdobrenja = pozivNaBrOdobrenja;
	}
	public Boolean getHitno() {
		return hitno;
	}
	public void setHitno(Boolean hitno) {
		this.hitno = hitno;
	}
	public BigDecimal getIznos() {
		return iznos;
	}
	public void setIznos(BigDecimal iznos) {
		this.iznos = iznos;
	}
	public Number getTipGreske() {
		return tipGreske;
	}
	public void setTipGreske(Number tipGreske) {
		this.tipGreske = tipGreske;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public DnevnoStanjeRacuna getStanjeRacuna() {
		return stanjeRacuna;
	}
	public void setStanjeRacuna(DnevnoStanjeRacuna stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}
	public NaseljenoMesto getMestoPrijema() {
		return mestoPrijema;
	}
	public void setMestoPrijema(NaseljenoMesto mestoPrijema) {
		this.mestoPrijema = mestoPrijema;
	}
	public Valuta getValuta() {
		return valuta;
	}
	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}
	public VrstePlacanja getVrstaPlacanja() {
		return vrstaPlacanja;
	}
	public void setVrstaPlacanja(VrstePlacanja vrstaPlacanja) {
		this.vrstaPlacanja = vrstaPlacanja;
	}
	
	
	
}
