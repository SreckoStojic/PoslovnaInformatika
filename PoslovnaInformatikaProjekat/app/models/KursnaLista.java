package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import antlr.collections.List;
import play.db.jpa.Model;

@Entity
public class KursnaLista extends Model {

	@Column(nullable = false)
	public Date datum;
	@Column(nullable = false, precision = 3, scale=0)
	public Number brojKursneListe;
	@Column(nullable = false)
	public Date primenjujeSeOd;
	@ManyToOne
	public Banka banka;
	@OneToMany (mappedBy="kursnaLista")
	public java.util.List<KursUValuti> valuteUListi;
	
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Number getBrojKursneListe() {
		return brojKursneListe;
	}
	public void setBrojKursneListe(Number brojKursneListe) {
		this.brojKursneListe = brojKursneListe;
	}
	public Date getPrimenjujeSeOd() {
		return primenjujeSeOd;
	}
	public void setPrimenjujeSeOd(Date primenjujeSeOd) {
		this.primenjujeSeOd = primenjujeSeOd;
	}
	public Banka getBanka() {
		return banka;
	}
	public void setBanka(Banka banka) {
		this.banka = banka;
	}
	public java.util.List<KursUValuti> getValuteUListi() {
		return valuteUListi;
	}
	public void setValuteUListi(java.util.List<KursUValuti> valuteUListi) {
		this.valuteUListi = valuteUListi;
	}
	
	
}
