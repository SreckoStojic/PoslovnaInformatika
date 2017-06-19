package controllers;

import java.util.List;

import models.Drzava;
import models.NaseljenoMesto;
import play.mvc.Controller;

public class Drzave extends Controller{
	
	public static void show(String mode)
	{
		List<Drzava> drzave = Drzava.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(drzave,mode);
	}
	
	public static void create(Drzava drzava){
		
		drzava.save();
		
		show("edit");
	}
	
	public static void edit(Drzava drzava){
		try {
			Drzava d = Drzava.findById(drzava.id);
			d.setNaziv(drzava.naziv);
			d.setOznaka(drzava.oznaka);
			
			d.save();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Drzavu.");
		}
		show("edit");
		
	}
	
	public static void remove(Long id){
		try {
			Drzava d = Drzava.findById(id);
			d.delete();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Drzavu.");
		}
		
	
		show("edit");
		
	}
	
	public static void filter(Drzava drzava){
		List<Drzava> drzave = Drzava.find("byOznakaLikeAndNazivLike", "%"+drzava.oznaka+"%","%"+drzava.naziv+"%").fetch();
		
		renderTemplate("Drzave/show.html", drzave);
	}
	
	
}
