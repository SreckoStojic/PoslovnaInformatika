package controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import models.Banka;
import models.KursnaLista;
import models.Valuta;
import play.mvc.Controller;

public class KursneListe extends Controller{
	
	public static void show(String mode)
	{
		List<Banka> banke = Banka.findAll();
		List<KursnaLista> kursneListe = KursnaLista.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(banke,kursneListe,mode);
	}
	
	
	public static void create(KursnaLista kursnaLista){
		kursnaLista.setDatum(new Date());
		try {
			kursnaLista.setBanka(Banka.findById(kursnaLista.banka.id));
		}
		catch(NullPointerException e) {
			error("Banka ne postoji.");
		}
		try {
			kursnaLista.save();
		}
		catch(PersistenceException e) {
			error("Niste uneli validne podatke.");
		}
		
		show("add");
	}
	
	public static void edit(KursnaLista kursnaLista){
		try {
			KursnaLista kl = KursnaLista.findById(kursnaLista.id);
			kl.setPrimenjujeSeOd(kursnaLista.primenjujeSeOd);
			kl.setValuteUListi(kursnaLista.valuteUListi);
			kl.save();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Kursnu listu.");
		}
		show("edit");
		
	}
	
	public static void remove(Long id){
		try {
			KursnaLista kl = KursnaLista.findById(id);
			kl.delete();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Kursnu listu.");
		}
		
	
		show("edit");
		
	}
	
	public static void filter(KursnaLista kl){
		List<KursnaLista> kursneListe = KursnaLista.find("datum = ? AND primenjujeSeOd = ? AND  banka_id = ?", kl.formatDate(kl.datum), kl.formatDate(kl.primenjujeSeOd), kl.banka.id).fetch();
		
		renderTemplate("KursneListe/show.html", kursneListe, "edit" );
	}
	
	public static void view(Long id){
		KursnaLista kursnaLista = KursnaLista.findById(id);
	
		renderTemplate("KursneListe/detaljiModal.html", kursnaLista);
	}

}
