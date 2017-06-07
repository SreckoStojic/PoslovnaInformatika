package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class RacunPravnihLica extends Model {

	@Column(nullable = false)
	public Long sifra;
	@Column(nullable = false, length = 18)
	public String brojRacuna;
	@Column(nullable = false)
	public Date datumOtvaranja;
	@Column(nullable = false)
	public Boolean vazeci;
	@ManyToOne
	public Banka banka;
	@ManyToOne
	public Klijent klijent;
	@ManyToOne
	public Valute valuta;
	@OneToMany(mappedBy = "racun")
	public List<Ukidanje> ukidanjeRacuna;
	@OneToMany(mappedBy = "racun")
	public List<DnevnoStanjeRacuna> stanjeRacuna;
}
