package controllers;

import java.util.List;

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
		nMesto.setDrzava(Drzava.findById(nMesto.drzava.id));
		nMesto.save();
		
		show("add");
	}
	
	public static void edit(NaseljenoMesto nMesto){
		NaseljenoMesto nm = NaseljenoMesto.findById(nMesto.id);
		nm.setNaziv(nMesto.naziv);
		nm.setPostanskiBroj(nMesto.postanskiBroj);
		nm.setDrzava(nMesto.drzava);
		nm.save();
		show("edit");
		
	}
	
	public static void remove(NaseljenoMesto nMesto){
		NaseljenoMesto nm = NaseljenoMesto.findById(nMesto.id);
		nm.delete();
		
	
		show("edit");
		
	}
	
	public static void remove(String id){
		NaseljenoMesto nm = NaseljenoMesto.findById(id);
		nm.delete();
		
	
		show("edit");
		
	}
	
	public static void filter(NaseljenoMesto nMesto){
		//List<NaseljenoMesto> nMesta = NaseljenoMesto.find("byNazivLikeAndPostanskiBrojLikeAndDrzava", "%"+nMesto.naziv+"%", "%"+nMesto.postanskiBroj+"%", nMesto.drzava).fetch();
		List<NaseljenoMesto> nMesta = NaseljenoMesto.find("naziv like ? AND postanskiBroj like ? AND drzava_id = ?", "%"+nMesto.naziv+"%", "%"+nMesto.postanskiBroj+"%", nMesto.drzava.id).fetch();
		
		renderTemplate("NaseljenaMesta/show.html", nMesta, "edit" );
	}
	
	public static void next(Long drzava_id){
		List<NaseljenoMesto> nMesta = NaseljenoMesto.find("drzava_id = ?", drzava_id).fetch();
		//List<NaseljenoMesto> nMesta = NaseljenoMesto.find("naziv like ? AND postanskiBroj like ?", "%"+nMesto.naziv+"%", "%"+nMesto.postanskiBroj+"%").fetch();
		renderTemplate("NaseljenaMesta/show.html", nMesta, "edit" );
	}

}