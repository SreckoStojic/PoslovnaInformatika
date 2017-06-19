package controllers;

import java.util.List;

import models.Drzava;
import models.KursUValuti;
import models.KursnaLista;
import models.Valuta;
import play.mvc.Controller;

public class KurseviUValuti extends Controller{
	
	public static void show(String mode)
	{
		List<KursUValuti> kursevi = KursUValuti.findAll();
		List<Valuta> valute = Valuta.findAll();
		List<KursnaLista> kursneListe = KursnaLista.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(kursevi,kursneListe,valute,mode);
	}
	
	
	public static void create(KursUValuti kurs){
		
		try {
			kurs.setKursnaLista(KursnaLista.findById(kurs.kursnaLista.id));
		}
		catch(NullPointerException e) {
			error("Kursne liste ne postoje.");
		}
		try {
			kurs.setOsnovnaValuta(Valuta.findById(kurs.osnovnaValuta.id));
		}
		catch(NullPointerException e) {
			error("Osnovna valuta ne postoji.");
		}
		try {
			kurs.setPremaValuti(Valuta.findById(kurs.premaValuti.id));
		}
		catch(NullPointerException e) {
			error("Valute ne postoje.");
		}
		
		kurs.save();
		
		show("add");
	}
	
	public static void edit(KursUValuti kurs){
		try {
			KursUValuti k = KursUValuti.findById(kurs.id);
			k.setKupovni(kurs.kupovni);
			k.setProdajni(kurs.prodajni);
			k.setOsnovnaValuta(kurs.osnovnaValuta);
			k.setPremaValuti(kurs.premaValuti);
			k.izracunajSrednjiKurs();
			k.save();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali kursnu listu.");
		}
		
		show("edit");
		
	}
	
	public static void remove(Long id){
		try {
			KursUValuti k = KursUValuti.findById(id);
			k.delete();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Kurs u valuti.");
		}
		
	
		show("edit");
		
	}
	
	public static void filter(KursUValuti kurs){
		List<KursUValuti> kursevi = KursUValuti.find("kupovni = ? AND prodajni = ?", kurs.kupovni,kurs.prodajni).fetch();
		
		renderTemplate("KurseviUValuti/show.html", kursevi, "edit" );
	}
	

}
