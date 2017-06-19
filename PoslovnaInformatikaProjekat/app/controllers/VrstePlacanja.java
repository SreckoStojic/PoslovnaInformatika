package controllers;

import java.util.List;

import models.VrstaPlacanja;
import play.mvc.Controller;

public class VrstePlacanja extends Controller{
	
	public static void show(String mode)
	{
		List<VrstaPlacanja> vrstePlacanja = VrstaPlacanja.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(vrstePlacanja,mode);
	}
	
	public static void create(VrstaPlacanja vrstaPlacanja){
		
		vrstaPlacanja.save();
		
		show("edit");
	}
	
	public static void edit(VrstaPlacanja vrstaPlacanja){
		try {
			VrstaPlacanja vp = VrstaPlacanja.findById(vrstaPlacanja.id);
			vp.setNaziv(vrstaPlacanja.naziv);
			vp.save();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Vrstu placanja.");
		}
		
		show("edit");
		
	}
	
	public static void remove(Long id){
		try {
			VrstaPlacanja vp = VrstaPlacanja.findById(id);
			vp.delete();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Vrstu placanja.");
		}
		
	
		show("edit");
		
	}
	
	public static void filter(VrstaPlacanja vrstaPlacanja){
		List<VrstaPlacanja> vrstePlacanja = VrstaPlacanja.find("byNazivLike", "%"+vrstaPlacanja.naziv+"%").fetch();
		
		renderTemplate("VrstePlacanja/show.html", vrstePlacanja);
	}
	
	
}
