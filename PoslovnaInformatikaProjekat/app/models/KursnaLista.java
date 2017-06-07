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
	public Integer oznaka;
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
}
