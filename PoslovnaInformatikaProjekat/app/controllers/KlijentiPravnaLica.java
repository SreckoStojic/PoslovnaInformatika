package controllers;

import java.util.List;

import models.Drzava;
import models.Klijent;
import models.KlijentPravnoLice;
import models.NaseljenoMesto;
import play.mvc.Controller;

public class KlijentiPravnaLica extends Controller{
	
	public static void show(String mode)
	{
		List<Drzava> drzave = Drzava.findAll();
		List<NaseljenoMesto> nMesta = NaseljenoMesto.findAll();
		List<KlijentPravnoLice> klijentiPL = KlijentPravnoLice.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(drzave,nMesta,klijentiPL,mode);
	}
	
	public static void create(KlijentPravnoLice klijentPL){
		
		klijentPL.save();
		
		show("edit");
	}
	
	public static void edit(KlijentPravnoLice klijentPL){
		KlijentPravnoLice k = KlijentPravnoLice.findById(klijentPL.id);
		k.setNaziv(klijentPL.naziv);
		k.setAdresa(klijentPL.adresa);
		k.setNaseljenoMesto(klijentPL.naseljenoMesto);
		k.save();
		show("edit");
		
	}

	public static void remove(Long id){
		KlijentPravnoLice k = KlijentPravnoLice.findById(id);
		k.delete();
		
	
		show("edit");
		
	}
	
	public static void filter(KlijentPravnoLice klijentPL, String mode){
		List<KlijentPravnoLice> klijentiPL = KlijentPravnoLice.find("naziv like ? AND adresa like ? AND naseljenomesto_id = ?",  "%"+klijentPL.naziv+"%", "%"+klijentPL.adresa+"%", klijentPL.naseljenoMesto.id).fetch();
		
		renderTemplate("KlijentiPravnaLica/show.html", klijentiPL);
	}
	
	
}
