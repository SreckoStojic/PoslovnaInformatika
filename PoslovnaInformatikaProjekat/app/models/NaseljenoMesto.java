package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class NaseljenoMesto extends Model {

	@Column(nullable = false)
	public int oznaka;
	@Column(nullable = false, length = 60)
	public String naziv;
	@Column(nullable = false, length = 12)
	public String postanskiBroj;
	@ManyToOne
	public Drzava drzava;
	@OneToMany(mappedBy = "mestoPrijema")
	public List<AnalitikaIzvoda> analitikeIzvoda;
}
