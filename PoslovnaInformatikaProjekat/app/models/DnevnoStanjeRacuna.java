package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class DnevnoStanjeRacuna extends Model {

	@Column(nullable = false)
	public Long brojIzvoda;
	@Column(nullable = false)
	public Date datumPrometa;
	@Column(nullable = false, precision = 15, scale = 2)
	public BigDecimal prethodnoStanje;
	@Column(nullable = false, precision = 15, scale = 2)
	public BigDecimal prometUKorist;
	@Column(nullable = false, precision = 15, scale = 2)
	public BigDecimal prometNaTeret;
	@Column(nullable = false, precision = 15, scale = 2)
	public BigDecimal novoStanje;
	@ManyToOne
	public RacunPravnihLica racun;
	@OneToMany(mappedBy = "stanjeRacuna")
	public List<AnalitikaIzvoda> analitikaIzvoda;
	
	public Long getBrojIzvoda() {
		return brojIzvoda;
	}
	public void setBrojIzvoda(Long brojIzvoda) {
		this.brojIzvoda = brojIzvoda;
	}
	public Date getDatumPrometa() {
		return datumPrometa;
	}
	public void setDatumPrometa(Date datumPrometa) {
		this.datumPrometa = datumPrometa;
	}
	public BigDecimal getPrethodnoStanje() {
		return prethodnoStanje;
	}
	public void setPrethodnoStanje(BigDecimal prethodnoStanje) {
		this.prethodnoStanje = prethodnoStanje;
	}
	public BigDecimal getPrometUKorist() {
		return prometUKorist;
	}
	public void setPrometUKorist(BigDecimal prometUKorist) {
		this.prometUKorist = prometUKorist;
	}
	public BigDecimal getPrometNaTeret() {
		return prometNaTeret;
	}
	public void setPrometNaTeret(BigDecimal prometNaTeret) {
		this.prometNaTeret = prometNaTeret;
	}
	public BigDecimal getNovoStanje() {
		return novoStanje;
	}
	public void setNovoStanje(BigDecimal novoStanje) {
		this.novoStanje = novoStanje;
	}
	public RacunPravnihLica getRacun() {
		return racun;
	}
	public void setRacun(RacunPravnihLica racun) {
		this.racun = racun;
	}
	public List<AnalitikaIzvoda> getAnalitikaIzvoda() {
		return analitikaIzvoda;
	}
	public void setAnalitikaIzvoda(List<AnalitikaIzvoda> analitikaIzvoda) {
		this.analitikaIzvoda = analitikaIzvoda;
	}

	
}
