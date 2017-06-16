package models;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import play.db.jpa.Model;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "DnevnoStanjeRacuna")
@Entity
public class DnevnoStanjeRacuna extends Model {

	@Column(nullable = false)
	public Date datumPrometa;
	@Column(nullable = false, precision = 15, scale = 2)
	public BigDecimal prethodnoStanje = BigDecimal.valueOf(0);
	@Column(nullable = false, precision = 15, scale = 2)
	public BigDecimal prometUKorist = BigDecimal.valueOf(0);
	@Column(nullable = false, precision = 15, scale = 2)
	public BigDecimal prometNaTeret = BigDecimal.valueOf(0);
	@Column(nullable = false, precision = 15, scale = 2)
	public BigDecimal novoStanje = BigDecimal.valueOf(0);
	@ManyToOne
	public RacunPravnihLica racun;
	@OneToMany(mappedBy = "stanjeRacuna")
	public List<AnalitikaIzvoda> analitikaIzvoda;
	
	public Date getDatumPrometa() {
		return datumPrometa;
	}
	@XmlElement(name = "DatumPrometa")
	public void setDatumPrometa(Date datumPrometa) {
		this.datumPrometa = datumPrometa;
	}
	public BigDecimal getPrethodnoStanje() {
		return prethodnoStanje;
	}
	@XmlElement(name = "PrethodnoStanjeRacuna")
	public void setPrethodnoStanje(BigDecimal prethodnoStanje) {
		this.prethodnoStanje = prethodnoStanje;
	}
	public BigDecimal getPrometUKorist() {
		return prometUKorist;
	}
	@XmlElement(name = "PrometUKorist")
	public void setPrometUKorist(BigDecimal prometUKorist) {
		this.prometUKorist = prometUKorist;
	}
	public BigDecimal getPrometNaTeret() {
		return prometNaTeret;
	}
	@XmlElement(name = "PrometNaTeret")
	public void setPrometNaTeret(BigDecimal prometNaTeret) {
		this.prometNaTeret = prometNaTeret;
	}
	public BigDecimal getNovoStanje() {
		return novoStanje;
	}
	@XmlElement(name = "NovoStanjeRacuna")
	public void setNovoStanje(BigDecimal novoStanje) {
		this.novoStanje = novoStanje;
	}
	public RacunPravnihLica getRacun() {
		return racun;
	}
	@XmlElement(name = "RacunPravnihLica")
	public void setRacun(RacunPravnihLica racun) {
		this.racun = racun;
	}
	public List<AnalitikaIzvoda> getAnalitikaIzvoda() {
		return analitikaIzvoda;
	}
	//@XmlElement(name = "AnalitikaIzvodaDSR")
	@XmlTransient
	public void setAnalitikaIzvoda(List<AnalitikaIzvoda> analitikaIzvoda) {
		this.analitikaIzvoda = analitikaIzvoda;
	}
	
	public String formatDate(Date datum){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(datum);
	}
	
	public BigDecimal izracunajNovoStanje(BigDecimal prethodnoStanje, BigDecimal prometUKorist, BigDecimal prometNaTeret){
		return prethodnoStanje.add(prometUKorist).subtract(prometNaTeret);
	}
	public void setPrethodnoZaNoviDan(BigDecimal novoStanje){
		this.prethodnoStanje = novoStanje; 
	}
	public static DnevnoStanjeRacuna pronadjiDnevnoStanjeRacunaNaOsnovuIDRacuna(Long racunID){
		DnevnoStanjeRacuna dsr = DnevnoStanjeRacuna.find("racun_id = ?", racunID).first();
		return dsr;
	}
	public static DnevnoStanjeRacuna pronadjiDnevnoStanjeRacunaNaOsnovuBrojaRacuna(String brojRacuna){
		RacunPravnihLica racun = RacunPravnihLica.find("brojRacuna = ?", brojRacuna).first();
		DnevnoStanjeRacuna dsr = DnevnoStanjeRacuna.find("racun_id = ?", racun.id).first();
		return dsr;
	}
}
