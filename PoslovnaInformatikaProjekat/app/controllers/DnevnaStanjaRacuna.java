package controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import models.DnevnoStanjeRacuna;
import models.RacunPravnihLica;
import play.mvc.Controller;

public class DnevnaStanjaRacuna extends Controller{
	
	public static void show(String mode, Long dnevnoStanjeRacunaID)
	{
		List<DnevnoStanjeRacuna> dnevnaStanjaRacuna = DnevnoStanjeRacuna.find("racun_id = ?", dnevnoStanjeRacunaID).fetch();
		if(mode == null || mode.equals(""))
			mode = "edit";
		
		render(dnevnaStanjaRacuna,mode);
	}
	
	public static void create(Long racunID){
		DnevnoStanjeRacuna dnevnoStanjeRacuna = new DnevnoStanjeRacuna();
		dnevnoStanjeRacuna.setDatumPrometa(new Date());
		dnevnoStanjeRacuna.setRacun(RacunPravnihLica.findById(racunID));
		if(dnevnoStanjeRacuna.pronadjiDnevnoStanjeRacunaNaOsnovuIDRacuna(racunID) == null){
			dnevnoStanjeRacuna.save();			
		}/*else if(!dnevnoStanjeRacuna.getDatumPrometa().equals(new Date())){
			dnevnoStanjeRacuna.setPrethodnoStanje(dnevnoStanjeRacuna.getNovoStanje());
			dnevnoStanjeRacuna.izracunajNovoStanje(dnevnoStanjeRacuna.getPrethodnoStanje(), dnevnoStanjeRacuna.prometUKorist, dnevnoStanjeRacuna.prometNaTeret);
			dnevnoStanjeRacuna.save();
		}*/
		show("edit", dnevnoStanjeRacuna.racun.id);
	}
	
	public static void edit(DnevnoStanjeRacuna dnevnoStanjeRacuna){
		show("edit", dnevnoStanjeRacuna.racun.id);
	}
	
	public static void remove(Long id){
		DnevnoStanjeRacuna dsr = DnevnoStanjeRacuna.findById(id);
		dsr.delete();
		
		show("edit", dsr.racun.id);
		
	}
	
	public static void filter(DnevnoStanjeRacuna dnevnoStanjeRacuna){
		List<DnevnoStanjeRacuna> dnevnaStanjaRacuna = DnevnoStanjeRacuna.find("datumPrometa = ?", dnevnoStanjeRacuna.formatDate(dnevnoStanjeRacuna.datumPrometa)).fetch();
		
		renderTemplate("DnevnaStanjaRacuna/show.html", dnevnaStanjaRacuna);
	}
	
	
}
