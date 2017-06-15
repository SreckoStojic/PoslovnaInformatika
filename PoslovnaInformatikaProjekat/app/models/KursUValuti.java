package models;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import play.db.jpa.Model;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "KursUValuti")
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
	@XmlElement(name = "KupovniKurs")
	public void setKupovni(BigDecimal kupovni) {
		this.kupovni = kupovni;
	}
	public BigDecimal getSrednji() {
		return srednji;
	}
	@XmlElement(name = "SrednjiKurs")
	public void setSrednji(BigDecimal srednji) {
		this.srednji = srednji;
	}
	public BigDecimal getProdajni() {
		return prodajni;
	}
	@XmlElement(name = "ProdajniKurs")
	public void setProdajni(BigDecimal prodajni) {
		this.prodajni = prodajni;
	}
	public KursnaLista getKursnaLista() {
		return kursnaLista;
	}
	@XmlElement(name = "KursnaListaKursa")
	public void setKursnaLista(KursnaLista kursnaLista) {
		this.kursnaLista = kursnaLista;
	}
	public Valuta getOsnovnaValuta() {
		return osnovnaValuta;
	}
	@XmlElement(name = "OsnovnaValutaKursa")
	public void setOsnovnaValuta(Valuta osnovnaValuta) {
		this.osnovnaValuta = osnovnaValuta;
	}
	public Valuta getPremaValuti() {
		return premaValuti;
	}
	@XmlElement(name = "PremaValutiKurs")
	public void setPremaValuti(Valuta premaValuti) {
		this.premaValuti = premaValuti;
	}

	@PrePersist
	public void izracunajSrednjiKurs() {
		this.srednji = (this.kupovni.add(this.prodajni)).divide(new BigDecimal(2));
	}
	
}
