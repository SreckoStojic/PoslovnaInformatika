package controllers;

import java.util.Date;
import java.util.List;

import models.AnalitikaIzvoda;
import models.DnevnoStanjeRacuna;
import models.KursnaLista;
import models.NaseljenoMesto;
import models.RacunPravnihLica;
import models.Valuta;
import models.VrstaPlacanja;
import play.mvc.Controller;

public class AnalitikeIzvoda extends Controller{
	
	public static void show(String mode)
	{
		List<AnalitikaIzvoda> analitikeIzvoda = AnalitikaIzvoda.findAll();
		List<RacunPravnihLica> racuni = RacunPravnihLica.findAll();
		List<KursnaLista> kursneListe = KursnaLista.findAll();
		List<VrstaPlacanja> vrstePlacanja = VrstaPlacanja.findAll();
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
		List<Valuta> valute = Valuta.findAll();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(analitikeIzvoda,mode,racuni, valute,naseljenaMesta, vrstePlacanja, kursneListe);
	}
	
	public static void create(AnalitikaIzvoda analitikaIzvoda){
		analitikaIzvoda.setValuta(Valuta.findById(analitikaIzvoda.valuta.id));
		analitikaIzvoda.setVrstaPlacanja(VrstaPlacanja.findById(analitikaIzvoda.vrstaPlacanja.id));
		analitikaIzvoda.setMestoPrijema(NaseljenoMesto.findById(analitikaIzvoda.mestoPrijema.id));
		analitikaIzvoda.setDatumValute(new Date());
		analitikaIzvoda.setDatumPrijema(new Date());
		RacunPravnihLica racunPoverilac = RacunPravnihLica.pronadjiBrojRacuna(analitikaIzvoda.racunPoverioca);
		DnevnoStanjeRacuna dnevnoStanjeRacunaPoverilac = DnevnoStanjeRacuna.pronadjiDnevnoStanjeRacunaNaOsnovuIDRacuna(racunPoverilac.id);
		RacunPravnihLica racunDuznik = RacunPravnihLica.pronadjiBrojRacuna(analitikaIzvoda.racunDuznika);
		if(racunPoverilac.vazeci == false){
			error("Racun poverioca je nevazeci.");
		}else if(racunDuznik.vazeci == false){
			error("Racun duznika je nevazeci.");
		}else {
			if(!analitikaIzvoda.racunDuznika.equals("")){
				DnevnoStanjeRacuna dnevnoStanjeRacunaDuznik = DnevnoStanjeRacuna.pronadjiDnevnoStanjeRacunaNaOsnovuIDRacuna(racunDuznik.id);
				if(dnevnoStanjeRacunaDuznik.getNovoStanje().compareTo(analitikaIzvoda.iznos) > 0){
					dnevnoStanjeRacunaPoverilac.setPrometUKorist(dnevnoStanjeRacunaPoverilac.getPrometUKorist().add(analitikaIzvoda.iznos));
					
					
					dnevnoStanjeRacunaDuznik.setPrometNaTeret(dnevnoStanjeRacunaDuznik.prometNaTeret.add(analitikaIzvoda.iznos));
					dnevnoStanjeRacunaDuznik.setNovoStanje(dnevnoStanjeRacunaDuznik.izracunajNovoStanje(dnevnoStanjeRacunaDuznik.getPrethodnoStanje(), dnevnoStanjeRacunaDuznik.getPrometUKorist(), dnevnoStanjeRacunaDuznik.getPrometNaTeret()));
					dnevnoStanjeRacunaDuznik.save();
				}else {
					error("Duznik nema dovoljno novca na racunu.");
				}
			}else {
				dnevnoStanjeRacunaPoverilac.setPrometUKorist(dnevnoStanjeRacunaPoverilac.getPrometUKorist().add(analitikaIzvoda.iznos));
			}
		
			dnevnoStanjeRacunaPoverilac.setNovoStanje(dnevnoStanjeRacunaPoverilac.izracunajNovoStanje(dnevnoStanjeRacunaPoverilac.getPrethodnoStanje(), dnevnoStanjeRacunaPoverilac.getPrometUKorist(), dnevnoStanjeRacunaPoverilac.getPrometNaTeret()));
			analitikaIzvoda.save();
			dnevnoStanjeRacunaPoverilac.save();
			Application.index();
		}
	}
	
	public static void edit(){
		show("edit");
	}
	
	public static void remove(Long id){
		AnalitikaIzvoda a = AnalitikaIzvoda.findById(id);
		a.delete();
	
		show("edit");
		
	}
	
	public static void nalog(){
		
		List<RacunPravnihLica> racuni = RacunPravnihLica.findAll();
		List<KursnaLista> kursneListe = KursnaLista.findAll();
		List<VrstaPlacanja> vrstePlacanja = VrstaPlacanja.findAll();
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
		List<Valuta> valute = Valuta.findAll();
	 	
		renderTemplate("AnalitikeIzvoda/nalogModal.html", racuni, kursneListe, vrstePlacanja, naseljenaMesta, valute);
	}
}
