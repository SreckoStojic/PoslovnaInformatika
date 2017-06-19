package controllers;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import models.AnalitikaIzvoda;
import models.DnevnoStanjeRacuna;
import models.KursUValuti;
import models.KursnaLista;
import models.NaseljenoMesto;
import models.RacunPravnihLica;
import models.Valuta;
import models.VrstaPlacanja;
import play.mvc.Controller;

public class AnalitikeIzvoda extends Controller {

	public static void show(String mode) {
		List<AnalitikaIzvoda> analitikeIzvoda = AnalitikaIzvoda.findAll();
		List<RacunPravnihLica> racuni = RacunPravnihLica.findAll();
		List<KursnaLista> kursneListe = KursnaLista.findAll();
		List<VrstaPlacanja> vrstePlacanja = VrstaPlacanja.findAll();
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
		List<Valuta> valute = Valuta.findAll();
		if (mode == null || mode.equals(""))
			mode = "edit";

		render(analitikeIzvoda, mode, racuni, valute, naseljenaMesta, vrstePlacanja, kursneListe);
	}

	public static void create(AnalitikaIzvoda analitikaIzvoda) {
		analitikaIzvoda.setValuta(Valuta.findById(analitikaIzvoda.valuta.id));
		analitikaIzvoda.setVrstaPlacanja(VrstaPlacanja.findById(analitikaIzvoda.vrstaPlacanja.id));
		analitikaIzvoda.setMestoPrijema(NaseljenoMesto.findById(analitikaIzvoda.mestoPrijema.id));
		analitikaIzvoda.setDatumValute(new Date());
		analitikaIzvoda.setDatumPrijema(new Date());
		RacunPravnihLica racunPoverilac = RacunPravnihLica.pronadjiBrojRacuna(analitikaIzvoda.racunPoverioca);
		DnevnoStanjeRacuna dnevnoStanjeRacunaPoverilac = DnevnoStanjeRacuna
				.pronadjiDnevnoStanjeRacunaNaOsnovuIDRacuna(racunPoverilac.id);
		RacunPravnihLica racunDuznik = RacunPravnihLica.pronadjiBrojRacuna(analitikaIzvoda.racunDuznika);
		if (racunPoverilac.vazeci == false) {
			error("Racun poverioca je nevazeci.");
		} else if (racunDuznik != null && racunDuznik.vazeci == false) {
			error("Racun duznika je nevazeci.");
		} else if (racunDuznik == null && analitikaIzvoda.vrstaPlacanja.naziv.equals("Medjubankarski prenos")) {
			error("Kod medjubankarskog prenosa se mora uneti i racun duznika.");
		} else if (!analitikaIzvoda.racunDuznika.equals("")
				&& analitikaIzvoda.vrstaPlacanja.naziv.equals("Uplata na racun")) {
			error("Kod uplate na racun polje za racun duznika mora biti prazno.");
		} else {
			if (!analitikaIzvoda.racunDuznika.equals("")) {
				DnevnoStanjeRacuna dnevnoStanjeRacunaDuznik = DnevnoStanjeRacuna
						.pronadjiDnevnoStanjeRacunaNaOsnovuIDRacuna(racunDuznik.id);

				BigDecimal kursUKorist = BigDecimal.valueOf(1);
				BigDecimal kursNaTeret = BigDecimal.valueOf(1);
				if (racunPoverilac.valuta.id.equals(racunDuznik.valuta.id)
						&& analitikaIzvoda.valuta.id.equals(racunDuznik.valuta.id)) {
					kursUKorist = BigDecimal.valueOf(1);
					kursNaTeret = BigDecimal.valueOf(1);
				} else if (racunPoverilac.valuta.id.equals(racunDuznik.valuta.id)
						&& !analitikaIzvoda.valuta.id.equals(racunPoverilac.valuta.id)) {
					KursUValuti kursUvalutiKorist = KursUValuti.find("osnovnaValuta_id = ? AND premaValuti_id = ?",
							analitikaIzvoda.valuta.id, racunPoverilac.valuta.id).first();
					kursUKorist = kursUvalutiKorist.srednji;
					KursUValuti kursUvalutiTeret = KursUValuti.find("osnovnaValuta_id = ? AND premaValuti_id = ?",
							analitikaIzvoda.valuta.id, racunDuznik.valuta.id).first();
					kursNaTeret = kursUvalutiTeret.srednji;
				} else if (!racunPoverilac.valuta.id.equals(racunDuznik.valuta.id)
						&& !analitikaIzvoda.valuta.id.equals(racunPoverilac.valuta.id)
						&& !analitikaIzvoda.valuta.id.equals(racunDuznik.valuta.id)) {
					KursUValuti kursUvalutiKorist = KursUValuti.find("osnovnaValuta_id = ? AND premaValuti_id = ?",
							analitikaIzvoda.valuta.id, racunPoverilac.valuta.id).first();
					kursUKorist = kursUvalutiKorist.srednji;
					KursUValuti kursUvalutiTeret = KursUValuti.find("osnovnaValuta_id = ? AND premaValuti_id = ?",
							analitikaIzvoda.valuta.id, racunDuznik.valuta.id).first();
					kursNaTeret = kursUvalutiTeret.srednji;
				} else if (!racunPoverilac.valuta.id.equals(racunDuznik.valuta.id) && racunDuznik != null) {
					KursUValuti kursUvalutiKorist = KursUValuti.find("osnovnaValuta_id = ? AND premaValuti_id = ?",
							analitikaIzvoda.valuta.id, racunPoverilac.valuta.id).first();
					kursUKorist = kursUvalutiKorist.srednji;
					KursUValuti kursUvalutiTeret = KursUValuti.find("osnovnaValuta_id = ? AND premaValuti_id = ?",
							analitikaIzvoda.valuta.id, racunDuznik.valuta.id).first();
					kursNaTeret = kursUvalutiTeret.srednji;
				} else if (racunDuznik == null && !analitikaIzvoda.valuta.id.equals(racunPoverilac.valuta.id)) {
					KursUValuti kursUvalutiKorist = KursUValuti.find("osnovnaValuta_id = ? AND premaValuti_id = ?",
							analitikaIzvoda.valuta.id, racunPoverilac.valuta.id).first();
					kursUKorist = kursUvalutiKorist.srednji;
					KursUValuti kursUvalutiTeret = KursUValuti.find("osnovnaValuta_id = ? AND premaValuti_id = ?",
							racunPoverilac.valuta.id, analitikaIzvoda.valuta.id).first();
					kursNaTeret = kursUvalutiTeret.srednji;
				} else if (racunDuznik == null && analitikaIzvoda.valuta.id.equals(racunPoverilac.valuta.id)) {
					kursUKorist = BigDecimal.valueOf(1);
					kursNaTeret = BigDecimal.valueOf(1);
				}

				if (dnevnoStanjeRacunaDuznik.getNovoStanje()
						.compareTo(analitikaIzvoda.iznos.multiply(kursNaTeret)) > 0) {

					dnevnoStanjeRacunaPoverilac.setPrometUKorist(dnevnoStanjeRacunaPoverilac.getPrometUKorist()
							.add(analitikaIzvoda.iznos.multiply(kursUKorist)));
					dnevnoStanjeRacunaDuznik.setPrometNaTeret(
							dnevnoStanjeRacunaDuznik.prometNaTeret.add(analitikaIzvoda.iznos.multiply(kursNaTeret)));
					dnevnoStanjeRacunaDuznik.setNovoStanje(dnevnoStanjeRacunaDuznik.izracunajNovoStanje(
							dnevnoStanjeRacunaDuznik.getPrethodnoStanje(), dnevnoStanjeRacunaDuznik.getPrometUKorist(),
							dnevnoStanjeRacunaDuznik.getPrometNaTeret()));
					dnevnoStanjeRacunaDuznik.save();

				} else {
					error("Duznik nema dovoljno novca na racunu.");
				}
			} else {
				BigDecimal kursUKorist = BigDecimal.valueOf(1);
				if (analitikaIzvoda.valuta.id.equals(racunPoverilac.valuta.id)) {
					kursUKorist = BigDecimal.valueOf(1);
				} else if (!analitikaIzvoda.valuta.id.equals(racunPoverilac.valuta.id)) {
					KursUValuti kursUvalutiKorist = KursUValuti.find("osnovnaValuta_id = ? AND premaValuti_id = ?",
							analitikaIzvoda.valuta.id, racunPoverilac.valuta.id).first();
					kursUKorist = kursUvalutiKorist.srednji;
				}
				dnevnoStanjeRacunaPoverilac.setPrometUKorist(dnevnoStanjeRacunaPoverilac.getPrometUKorist()
						.add(analitikaIzvoda.iznos.multiply(kursUKorist)));
			}

			dnevnoStanjeRacunaPoverilac.setNovoStanje(dnevnoStanjeRacunaPoverilac.izracunajNovoStanje(
					dnevnoStanjeRacunaPoverilac.getPrethodnoStanje(), dnevnoStanjeRacunaPoverilac.getPrometUKorist(),
					dnevnoStanjeRacunaPoverilac.getPrometNaTeret()));
			analitikaIzvoda.save();
			dnevnoStanjeRacunaPoverilac.save();
			Application.index();
		}
	}

	public static void edit() {
		show("edit");
	}

	public static void remove(Long id) {
		AnalitikaIzvoda a = AnalitikaIzvoda.findById(id);
		a.delete();

		show("edit");

	}

	public static void nalog() {

		List<RacunPravnihLica> racuni = RacunPravnihLica.findAll();
		List<KursnaLista> kursneListe = KursnaLista.findAll();
		List<VrstaPlacanja> vrstePlacanja = VrstaPlacanja.findAll();
		List<NaseljenoMesto> naseljenaMesta = NaseljenoMesto.findAll();
		List<Valuta> valute = Valuta.findAll();

		renderTemplate("AnalitikeIzvoda/nalogModal.html", racuni, kursneListe, vrstePlacanja, naseljenaMesta, valute);
	}

	public static void exportUplatnice(AnalitikaIzvoda analitikaIzvoda) {
		AnalitikaIzvoda analitika = AnalitikaIzvoda.findById(analitikaIzvoda.id);
		try {
			File file = new File("C:\\Users\\sara\\Desktop\\" + analitika.id + ".xml");
			JAXBContext jaxbContext = null;
			jaxbContext = JAXBContext.newInstance(AnalitikaIzvoda.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(analitika, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		show("edit");
	}

	public static void importUplatnice(String file) throws JAXBException {
		String fileName = file.substring(12, file.length());
		System.out.println(fileName);
		JAXBContext jaxbContext = JAXBContext.newInstance(AnalitikaIzvoda.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AnalitikaIzvoda analitikaIzvoda = (AnalitikaIzvoda) jaxbUnmarshaller
				.unmarshal(new File("C:\\Users\\sara\\Desktop\\" + fileName));
		System.out.println(AnalitikaIzvoda.count());
		if (AnalitikaIzvoda.findById(analitikaIzvoda.id) == null) {
			analitikaIzvoda.id = null;
			analitikaIzvoda.save();
		}
		show("edit");
	}

}
