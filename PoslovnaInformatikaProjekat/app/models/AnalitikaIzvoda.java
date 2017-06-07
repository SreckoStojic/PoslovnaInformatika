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
	public Valute valuta;
	@ManyToOne(optional=true)
	public VrstePlacanja vrstaPlacanja;
	
}
