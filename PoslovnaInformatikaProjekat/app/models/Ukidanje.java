package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Ukidanje extends Model{

	@Column (nullable=false)
	public int sifra;
	@Column (nullable=false)
	public Date datumUkidanja;
	@Column (nullable=false, length=20)
	public String prenosenjeNaRacun;
	@ManyToOne
	public RacunPravnihLica racun;
	
}
