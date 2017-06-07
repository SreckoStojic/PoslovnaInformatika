package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Klijent extends Model {

	@Column(nullable = false)
	public Integer oznaka;
	@Column(nullable = true, length = 120)
	public String naziv;
	@OneToMany(mappedBy = "klijent")
	public List<RacunPravnihLica> racuni;
}
