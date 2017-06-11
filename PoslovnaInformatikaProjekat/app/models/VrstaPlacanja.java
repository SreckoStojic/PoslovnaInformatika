package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class VrstaPlacanja extends Model {

	@Column(nullable = false, length = 120)
	public String naziv;
	@OneToMany(mappedBy = "vrstaPlacanja")
	public List<AnalitikaIzvoda> analitikeIzvoda;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<AnalitikaIzvoda> getAnalitikeIzvoda() {
		return analitikeIzvoda;
	}
	public void setAnalitikeIzvoda(List<AnalitikaIzvoda> analitikeIzvoda) {
		this.analitikeIzvoda = analitikeIzvoda;
	}
	
	

}
