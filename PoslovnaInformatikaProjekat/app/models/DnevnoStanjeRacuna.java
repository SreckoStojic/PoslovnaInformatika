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

}
