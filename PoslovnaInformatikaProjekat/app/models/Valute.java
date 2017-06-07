package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Valute extends Model {

	@Column(nullable = false)
	public int sifra;
	@Column(nullable = false, length = 3)
	public String zvanicnaSifra;
	@Column(nullable = false, length = 30)
	public String naziv;
	@Column(nullable = false)
	public Boolean domicilna;
	@ManyToOne
	public Drzava drzava;
	@OneToMany(mappedBy = "osnovnaValuta")
	public List<KursUValuti> osnovnaValuta;
	@OneToMany(mappedBy = "premaValuti")
	public List<KursUValuti> premaValut;
	@OneToMany(mappedBy = "valuta")
	public List<RacunPravnihLica> racuni;
	@OneToMany(mappedBy="valuta")
	public List<AnalitikaIzvoda> analitikeIzvoda;
}
