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
		
		kurs.setOsnovnaValuta(Valuta.findById(kurs.osnovnaValuta.id));
		kurs.setPremaValuti(Valuta.findById(kurs.premaValuti.id));
		kurs.setKursnaLista(KursnaLista.findById(kurs.kursnaLista.id));
		kurs.save();
		
		show("add");
	}
	
	public static void edit(KursUValuti kurs){
		KursUValuti k = KursUValuti.findById(kurs.id);
		k.setKupovni(kurs.kupovni);
		k.setProdajni(kurs.prodajni);
		k.setOsnovnaValuta(kurs.osnovnaValuta);
		k.setPremaValuti(kurs.premaValuti);
		//k.setKursnaLista(kurs.kursnaLista);
		k.save();
		show("edit");
		
	}
	
	public static void remove(Long id){
		KursUValuti k = KursUValuti.findById(id);
		k.delete();
		
	
		show("edit");
		
	}
	
	public static void filter(KursUValuti kurs){
		List<KursUValuti> kursevi = KursUValuti.find("kupovni = ? AND prodajni = ?", kurs.kupovni,kurs.prodajni).fetch();
		
		renderTemplate("KurseviUValuti/show.html", kursevi, "edit" );
	}

}
