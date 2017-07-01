package controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import models.Banka;
import models.DnevnoStanjeRacuna;
import models.Klijent;
import models.RacunPravnihLica;
import models.Ukidanje;
import models.Valuta;
import play.mvc.Controller;

public class RacuniPravnihLica extends Controller{
	
	public static void show(String mode)
	{
		List<RacunPravnihLica> racuni = RacunPravnihLica.findAll();
		List<Banka> banke = Banka.findAll();
		List<Klijent> klijenti = Klijent.findAll();
		List<Valuta> valute = Valuta.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(racuni,banke,klijenti,valute,mode);
	}
	
	public static void create(RacunPravnihLica racun){
		try {
			racun.save();
		}
		catch(PersistenceException e) {
			error("Niste uneli validne podatke.");
		}
		KlijentiPravnaLica.show("edit");
	}
	
	public static void edit(RacunPravnihLica racun){
		try {
			RacunPravnihLica r = RacunPravnihLica.findById(racun.id);
			r.setBrojRacuna(racun.brojRacuna);
			r.setVazeci(racun.vazeci);
			r.setBanka(racun.banka);
			r.setKlijent(racun.klijent);
			r.setValuta(racun.valuta);
			r.save();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Racun pravnog lica.");
		}
		catch(PersistenceException e) {
			error("Niste uneli validne podatke.");
		}
		show("edit");
		
	}
	
	public static void remove(Long id){
		try {
			RacunPravnihLica r = RacunPravnihLica.findById(id);
			r.delete();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Racun pravnog lica.");
		}
		
	
		show("edit");
		
	}
	
	public static void filter(RacunPravnihLica racun){
		List<RacunPravnihLica> racuni = RacunPravnihLica.find("brojRacuna like ? AND datumOtvaranja = ? AND racun_banka_id = ? AND racun_klijent_id = ? AND racun_valuta_id = ?",  "%"+racun.brojRacuna+"%", racun.formatDate(racun.getDatumOtvaranja()), racun.banka.id, racun.klijent.id, racun.valuta.id).fetch();
		
		renderTemplate("RacuniPravnihLica/show.html", racuni);
	}
	
	public static void formaNapraviRacun(Long klijentID){
		List<Banka> banke = Banka.findAll();
		List<Klijent> klijenti = Klijent.findAll();
		List<Valuta> valute = Valuta.findAll();
		renderTemplate("RacuniPravnihLica/racunModal.html",banke,klijenti,valute,klijentID);
	}
	
	public static void racuniBanke(Long bankaID){
		List<RacunPravnihLica> racuni = RacunPravnihLica.find("banka_id = ?", bankaID).fetch();
		renderTemplate("RacuniPravnihLica/show.html",racuni);
	}
}
