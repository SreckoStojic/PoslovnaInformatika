package controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import models.DnevnoStanjeRacuna;
import models.KursUValuti;
import models.RacunPravnihLica;
import models.Ukidanje;
import models.Valuta;
import play.mvc.Controller;

public class UkidanjeRacuna extends Controller{
	
	public static void show(String mode)
	{
		List<Ukidanje> ukidanjaRacuna = Ukidanje.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(ukidanjaRacuna,mode);
	}
	
	
	public static void create(Ukidanje ukidanjeRacuna){
		ukidanjeRacuna.setDatumUkidanja(new Date());
		ukidanjeRacuna.setRacun(RacunPravnihLica.find("id = ?", ukidanjeRacuna.racun.id).first()); 
		RacunPravnihLica racunZaUkidanje = RacunPravnihLica.find("id = ?", ukidanjeRacuna.racun.id).first();
		RacunPravnihLica racunZaPrenos = RacunPravnihLica.find("brojRacuna = ?", ukidanjeRacuna.prenosenjeNaRacun).first();
		
		DnevnoStanjeRacuna dnevnoStanjeRacunaKojiSePrebacuje = DnevnoStanjeRacuna.pronadjiDnevnoStanjeRacunaNaOsnovuIDRacuna(ukidanjeRacuna.racun.id);
		DnevnoStanjeRacuna dnevnoStanjeRacunaZaPrebacivanje = DnevnoStanjeRacuna.pronadjiDnevnoStanjeRacunaNaOsnovuBrojaRacuna(ukidanjeRacuna.prenosenjeNaRacun);
		
		
		BigDecimal kursUKorist = BigDecimal.valueOf(1);
	
		if(!racunZaUkidanje.valuta.id.equals(racunZaPrenos.valuta.id)){
			KursUValuti kursUValutiKorist = KursUValuti.find("osnovnaValuta_id = ? AND premaValuti_id = ?", racunZaUkidanje.valuta.id, racunZaPrenos.valuta.id).first();
			kursUKorist = kursUValutiKorist.srednji;
		}
		
		dnevnoStanjeRacunaZaPrebacivanje.setPrometUKorist(dnevnoStanjeRacunaZaPrebacivanje.getPrometUKorist().add(dnevnoStanjeRacunaKojiSePrebacuje.getNovoStanje().multiply(kursUKorist)));
		dnevnoStanjeRacunaZaPrebacivanje.setNovoStanje(dnevnoStanjeRacunaZaPrebacivanje.izracunajNovoStanje(dnevnoStanjeRacunaZaPrebacivanje.getPrethodnoStanje(),dnevnoStanjeRacunaZaPrebacivanje.getPrometUKorist(),dnevnoStanjeRacunaZaPrebacivanje.getPrometNaTeret()));
		dnevnoStanjeRacunaZaPrebacivanje.save();
		dnevnoStanjeRacunaKojiSePrebacuje.setPrometNaTeret(dnevnoStanjeRacunaKojiSePrebacuje.getNovoStanje());
		dnevnoStanjeRacunaKojiSePrebacuje.setNovoStanje(dnevnoStanjeRacunaKojiSePrebacuje.izracunajNovoStanje(dnevnoStanjeRacunaKojiSePrebacuje.getPrethodnoStanje(), dnevnoStanjeRacunaKojiSePrebacuje.getPrometUKorist(), dnevnoStanjeRacunaKojiSePrebacuje.getPrometNaTeret()));
		dnevnoStanjeRacunaKojiSePrebacuje.save();
		
		racunZaUkidanje.setVazeci(false);
		racunZaUkidanje.save();
		ukidanjeRacuna.save();

		System.out.println(dnevnoStanjeRacunaKojiSePrebacuje.racun.brojRacuna);
		System.out.println(dnevnoStanjeRacunaZaPrebacivanje.racun.brojRacuna);
		RacuniPravnihLica.show("edit");
		
	}
	/*
	public static void edit(Valuta valuta){
		Valuta v = Valuta.findById(valuta.id);
		v.setOznaka(valuta.oznaka);
		v.setZvanicnaSifra(valuta.zvanicnaSifra);
		v.setDomicilna(valuta.domicilna);
		v.setNaziv(valuta.naziv);
		v.setDrzava(valuta.drzava);
		v.save();
		show("edit");
		
	}
	
	public static void remove(Long id){
		Valuta v = Valuta.findById(id);
		v.delete();
		
	
		show("edit");
		
	}
	
	public static void filter(Valuta valuta){
		List<Valuta> valute = Valuta.find("zvanicnaSifra like ? AND naziv like ? AND  drzava_id = ?",  "%"+valuta.zvanicnaSifra+"%", "%"+valuta.naziv+"%", valuta.drzava.id).fetch();
		
		renderTemplate("Valute/show.html", valute, "edit" );
	}*/

}
