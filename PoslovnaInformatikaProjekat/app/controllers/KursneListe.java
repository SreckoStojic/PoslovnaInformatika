package controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

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
		kursnaLista.setBanka(Banka.findById(kursnaLista.banka.id));
		kursnaLista.save();
		
		show("add");
	}
	
	public static void edit(KursnaLista kursnaLista){
		KursnaLista kl = KursnaLista.findById(kursnaLista.id);
		kl.setPrimenjujeSeOd(kursnaLista.primenjujeSeOd);
		kl.setValuteUListi(kursnaLista.valuteUListi);
		kl.save();
		show("edit");
		
	}
	/*
	public static void remove(NaseljenoMesto nMesto){
		NaseljenoMesto nm = NaseljenoMesto.findById(nMesto.id);
		nm.delete();
		
	
		show("edit");
		
	}*/
	
	public static void remove(Long id){
		KursnaLista kl = KursnaLista.findById(id);
		kl.delete();
		
	
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
