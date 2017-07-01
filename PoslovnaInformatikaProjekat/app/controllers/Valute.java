package controllers;

import java.util.List;

import javax.persistence.PersistenceException;

import models.Drzava;
import models.KursUValuti;
import models.Valuta;
import play.mvc.Controller;

public class Valute extends Controller{
	
	public static void show(String mode)
	{
		List<Drzava> drzave = Drzava.findAll();
		List<Valuta> valute = Valuta.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(drzave,valute,mode);
	}
	
	
	public static void create(Valuta valuta){
		try {
			valuta.setDrzava(Drzava.findById(valuta.drzava.id));
		}
		catch(NullPointerException e) {
			error("Drzava ne postoji.");
		}
		try {
			valuta.save();
		}
		catch(PersistenceException e) {
			error("Niste uneli validne podatke.");
		}
		show("add");
	}
	
	public static void edit(Valuta valuta){
		try {
			Valuta v = Valuta.findById(valuta.id);
			v.setOznaka(valuta.oznaka);
			v.setZvanicnaSifra(valuta.zvanicnaSifra);
			v.setDomicilna(valuta.domicilna);
			v.setNaziv(valuta.naziv);
			v.setDrzava(valuta.drzava);
			v.save();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Valutu.");
		}
		catch(PersistenceException e) {
			error("Niste uneli validne podatke.");
		}
		show("edit");
		
	}
	
	public static void remove(Long id){
		try {
			Valuta v = Valuta.findById(id);
			v.delete();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Valutu.");
		}
		
	
		show("edit");
		
	}
	
	public static void filter(Valuta valuta){
		List<Valuta> valute = Valuta.find("zvanicnaSifra like ? AND naziv like ? AND  drzava_id = ?",  "%"+valuta.zvanicnaSifra+"%", "%"+valuta.naziv+"%", valuta.drzava.id).fetch();
		
		renderTemplate("Valute/show.html", valute, "edit" );
	}

}
