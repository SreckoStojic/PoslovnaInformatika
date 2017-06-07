package models;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class KursUValuti extends Model {

	@Column(nullable = false, precision = 9, scale=4)
	public Number redniBroj;
	@Column(nullable = false, precision = 9, scale=4)
	public BigDecimal kupovni;
	@Column(nullable = false, precision = 9, scale=4)
	public BigDecimal srednji;
	@Column(nullable = false, precision = 9, scale=4)
	public BigDecimal prodajni;
	@ManyToOne
	public KursnaLista kursnaLista;
	@ManyToOne
	public Valute osnovnaValuta;
	@ManyToOne
	public Valute premaValuti;
}
