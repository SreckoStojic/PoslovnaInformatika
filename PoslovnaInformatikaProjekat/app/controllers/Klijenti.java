package controllers;

import java.util.List;

import models.Drzava;
import models.Klijent;
import models.NaseljenoMesto;
import play.mvc.Controller;

public class Klijenti extends Controller{
	
	public static void show(String mode)
	{
		List<Drzava> drzave = Drzava.findAll();
		List<NaseljenoMesto> nMesta = NaseljenoMesto.findAll();
		List<Klijent> klijenti = Klijent.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(drzave,nMesta,klijenti,mode);
	}
	
	public static void create(Klijent klijent){
		
		klijent.save();
		
		show("edit");
	}
	
	public static void edit(Klijent klijent){
		Klijent k = Klijent.findById(klijent.id);
		k.setIme(klijent.ime);
		k.setPrezime(klijent.prezime);
		k.setNaseljenoMesto(klijent.naseljenoMesto);
		k.setPravnoLice(klijent.pravnoLice);
		k.save();
		show("edit");
		
	}
	/*
	public static void remove(Drzava drzava){
		Drzava d = Drzava.findById(drzava.id);
		d.delete();
		
		show("edit");
		
	}*/
	
	public static void remove(Long id){
		Klijent k = Klijent.findById(id);
		k.delete();
		
	
		show("edit");
		
	}
	
	public static void filter(Klijent klijent, String mode){
		List<Klijent> klijenti = Klijent.find("ime like ? AND prezime like ? AND naseljenomesto_id = ?",  "%"+klijent.ime+"%", "%"+klijent.prezime+"%", klijent.naseljenoMesto.id).fetch();
		
		renderTemplate("Klijenti/show.html", klijenti);
	}
	
	
}
