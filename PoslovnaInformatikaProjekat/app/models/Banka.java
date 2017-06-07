package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Banka extends Model {

	@Column(nullable = false)
	public Integer oznaka;
	@Column(nullable = false, length = 3)
	public String sifra;
	@Column(nullable = false, length = 10)
	public String pib;
	@Column(nullable = false, length = 120)
	public String naziv;
	@Column(nullable = false, length = 120)
	public String adresa;
	@Column(nullable = true, length = 128)
	public String email;
	@Column(nullable = true, length = 128)
	public String web;
	@Column(nullable = true, length = 20)
	public String telefon;
	@Column(nullable = true, length = 20)
	public String fax;
	@Column(nullable = false)
	public Boolean banka;
	@OneToMany(mappedBy = "banka")
	public List<KursnaLista> kursnaLista;
	@OneToMany(mappedBy = "banka")
	public List<RacunPravnihLica> racuni;
}
