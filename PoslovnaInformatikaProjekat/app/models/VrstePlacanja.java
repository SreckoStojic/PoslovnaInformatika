package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class VrstePlacanja extends Model {

	@Column(nullable = false, precision = 3, scale = 0)
	public Number oznaka;
	@Column(nullable = false, length = 120)
	public String naziv;
	@OneToMany(mappedBy = "vrstaPlacanja")
	public List<AnalitikaIzvoda> analitikeIzvoda;

}
