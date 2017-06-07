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
		Drzava d = Drzava.findById(drzava.id);
		d.setNaziv(drzava.naziv);
		d.setOznaka(drzava.oznaka);
		
		d.save();
		show("edit");
		
	}
	/*
	public static void remove(Drzava drzava){
		Drzava d = Drzava.findById(drzava.id);
		d.delete();
		
		show("edit");
		
	}*/
	
	public static void remove(Long id){
		Drzava d = Drzava.findById(id);
		d.delete();
		
	
		show("edit");
		
	}
	
	public static void filter(Drzava drzava, String mode){
		List<Drzava> drzave = Drzava.find("byOznakaLikeAndNazivLike", "%"+drzava.oznaka+"%","%"+drzava.naziv+"%").fetch();
		System.out.println(drzave.size());
		
		renderTemplate("Drzave/show.html", drzave);
	}
	
	
}
