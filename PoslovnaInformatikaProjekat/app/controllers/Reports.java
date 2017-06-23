package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import play.Play;
import play.mvc.Controller;
import models.Banka;
import models.Klijent;
import models.KlijentFizickoLice;
import models.KlijentPravnoLice;
import models.RacunPravnihLica;



public class Reports extends Controller {

	public static void show(){
		List<Banka> banke = Banka.findAll();
		List<KlijentFizickoLice> klfl = KlijentFizickoLice.findAll();
		List<KlijentPravnoLice> klpl = KlijentPravnoLice.findAll();
		render(banke, klfl, klpl);
		
	}
	
	public static void exportBanka(Banka banka) throws JRException{
		long id = banka.id;
		System.out.println(id);
		

			Map params = new HashMap<>();
			params.put("idBanke", id);

			String file = Play.applicationPath + File.separator +"app"+ File.separator + "reports" + File.separator + "report1.jasper";

			if (play.db.DB.getConnection() == null) {
				
			}
			
			//System.out.println(banka.naziv);
			

			JasperPrint jp = JasperFillManager.fillReport(file, params, play.db.DB.getConnection());
			//System.out.println(id);
			JasperExportManager.exportReportToPdfFile(jp, Play.applicationPath + File.separator + "izvestaj-banka-" + id + ".pdf");

		
		
		show();
		
	}
	
	public static void exportKlijent(Klijent klijent, Date from, Date untill ) throws JRException{
		long id = klijent.id;
		Map params = new HashMap<>();
		ArrayList<String> brojeviRacuna = new ArrayList<String>();
		List<RacunPravnihLica> r = klijent.getRacuni();
		for(int i=0; i<r.size(); i++ ){
			//System.out.println(r.get(i).brojRacuna);
			brojeviRacuna.add(r.get(i).brojRacuna);
		}
		params.put("brRacuna", brojeviRacuna);
		params.put("from", from);
		params.put("untill", untill);
		//System.out.println(id);
		System.out.println(from);
		System.out.println(untill);
			
		String file = Play.applicationPath + File.separator +"app"+ File.separator + "reports" + File.separator + "report2.jasper";


		if (play.db.DB.getConnection() == null) {
			System.out.println("null");
		}
		
		//System.out.println(banka.naziv);
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");

		JasperPrint jp = JasperFillManager.fillReport(file, params, play.db.DB.getConnection());
		System.out.println(id);
		JasperExportManager.exportReportToPdfFile(jp, Play.applicationPath + File.separator + "izvestaj-klijent-" + id + ".pdf");
		
		show();
		
	}
		
		
	}
	
