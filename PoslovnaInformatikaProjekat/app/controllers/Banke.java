package controllers;

import java.util.List;

import models.Banka;
import play.mvc.Controller;

public class Banke extends Controller{
	
	public static void show(String mode)
	{
		List<Banka> banke = Banka.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(banke,mode);
	}
	
	public static void create(Banka banka){
		
		banka.save();
		
		show("add");
	}
	
	public static void edit(Banka banka){
		try {
			Banka b = Banka.findById(banka.id);
			b.setSifra(banka.sifra);
			b.setPib(banka.pib);
			b.setNaziv(banka.naziv);
			b.setAdresa(banka.adresa);
			b.setEmail(banka.email);
			b.setWeb(banka.web);
			b.setTelefon(banka.telefon);
			b.setFax(banka.fax);
			b.setBanka(banka.banka);
			b.save();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Banku.");
		}
		show("edit");
		
	}
	
	public static void remove(Long id){
		try {
			Banka b = Banka.findById(id);
			b.delete();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Banku");
		}
		
	
		show("edit");
		
	}
	
	public static void filter(Banka banka){
		List<Banka> banke = Banka.find("sifra like ? AND pib like ? AND  naziv like ? AND adresa like ? AND email like ? AND web like ? AND telefon like ? AND fax like ?",  "%"+banka.sifra+"%", "%"+banka.pib+"%", "%"+banka.naziv+"%", "%"+banka.adresa+"%", "%"+banka.email+"%", "%"+banka.web+"%", "%"+banka.telefon+"%", "%"+banka.fax+"%").fetch();
		
		renderTemplate("Banke/show.html", banke, "edit" );
	}

}
