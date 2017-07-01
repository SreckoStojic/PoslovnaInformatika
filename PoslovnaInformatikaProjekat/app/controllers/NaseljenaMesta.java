package controllers;

import java.util.List;

import javax.persistence.PersistenceException;

import models.Drzava;
import models.NaseljenoMesto;
import play.mvc.Controller;

public class NaseljenaMesta extends Controller{
	
	public static void show(String mode)
	{
		List<Drzava> drzave = Drzava.findAll();
		List<NaseljenoMesto> nMesta = NaseljenoMesto.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(nMesta,drzave,mode);
	}
	
	
	public static void create(NaseljenoMesto nMesto){
		try {
			nMesto.setDrzava(Drzava.findById(nMesto.drzava.id));
			nMesto.save();
		}
		catch(NullPointerException e) {
			error("Drzava ne postoji.");
		}
		catch(PersistenceException e) {
			error("Niste uneli validne podatke.");
		}
		
		show("edit");
	}
	
	public static void edit(NaseljenoMesto nMesto){
		try {
			NaseljenoMesto nm = NaseljenoMesto.findById(nMesto.id);
			nm.setOznaka(nMesto.oznaka);
			nm.setNaziv(nMesto.naziv);
			nm.setPostanskiBroj(nMesto.postanskiBroj);
			nm.setDrzava(nMesto.drzava);
			nm.save();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Naseljeno mesto.");
		}
		catch(PersistenceException e) {
			error("Niste uneli validne podatke.");
		}
		show("edit");
		
	}
	
	public static void remove(Long id){
		try {
			NaseljenoMesto nm = NaseljenoMesto.findById(id);
			nm.delete();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Naseljeno mesto.");
		}
		
	
		show("edit");
		
	}
	
	public static void filter(NaseljenoMesto nMesto){
		//List<NaseljenoMesto> nMesta = NaseljenoMesto.find("byNazivLikeAndPostanskiBrojLikeAndDrzava", "%"+nMesto.naziv+"%", "%"+nMesto.postanskiBroj+"%", nMesto.drzava).fetch();
		List<NaseljenoMesto> nMesta = NaseljenoMesto.find("oznaka like ? AND naziv like ? AND postanskiBroj like ? AND drzava_id = ?",  "%"+nMesto.oznaka+"%", "%"+nMesto.naziv+"%", "%"+nMesto.postanskiBroj+"%", nMesto.drzava.id).fetch();
		
		renderTemplate("NaseljenaMesta/show.html", nMesta, "edit" );
	}
	
	public static void next(Long drzava_id){
		List<NaseljenoMesto> nMesta = NaseljenoMesto.find("drzava_id = ?", drzava_id).fetch();
		//List<NaseljenoMesto> nMesta = NaseljenoMesto.find("naziv like ? AND postanskiBroj like ?", "%"+nMesto.naziv+"%", "%"+nMesto.postanskiBroj+"%").fetch();
		renderTemplate("NaseljenaMesta/show.html", nMesta, "edit" );
	}

}
