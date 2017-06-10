package models;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import play.db.jpa.Model;

@Entity
public class KursUValuti extends Model {

	@Column(nullable = false, precision = 9, scale=4)
	public BigDecimal kupovni;
	@Column(nullable = false, precision = 9, scale=4)
	public BigDecimal srednji;
	@Column(nullable = false, precision = 9, scale=4)
	public BigDecimal prodajni;
	@ManyToOne
	public KursnaLista kursnaLista;
	@ManyToOne
	public Valuta osnovnaValuta;
	@ManyToOne
	public Valuta premaValuti;
	
	public BigDecimal getKupovni() {
		return kupovni;
	}
	public void setKupovni(BigDecimal kupovni) {
		this.kupovni = kupovni;
	}
	public BigDecimal getSrednji() {
		return srednji;
	}
	public void setSrednji(BigDecimal srednji) {
		this.srednji = srednji;
	}
	public BigDecimal getProdajni() {
		return prodajni;
	}
	public void setProdajni(BigDecimal prodajni) {
		this.prodajni = prodajni;
	}
	public KursnaLista getKursnaLista() {
		return kursnaLista;
	}
	public void setKursnaLista(KursnaLista kursnaLista) {
		this.kursnaLista = kursnaLista;
	}
	public Valuta getOsnovnaValuta() {
		return osnovnaValuta;
	}
	public void setOsnovnaValuta(Valuta osnovnaValuta) {
		this.osnovnaValuta = osnovnaValuta;
	}
	public Valuta getPremaValuti() {
		return premaValuti;
	}
	public void setPremaValuti(Valuta premaValuti) {
		this.premaValuti = premaValuti;
	}

	@PrePersist
	public void izracunajSrednjiKurs() {
		this.srednji = this.kupovni.add(this.prodajni).divide((new BigDecimal(2)));
	}
	
}
