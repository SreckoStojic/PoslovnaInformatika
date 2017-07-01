package controllers;

import java.io.File;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import models.Drzava;
import models.KlijentFizickoLice;
import models.KlijentPravnoLice;
import models.NaseljenoMesto;
import play.mvc.Controller;

public class KlijentiFizickaLica extends Controller {

	public static void show(String mode) {
		List<Drzava> drzave = Drzava.findAll();
		List<NaseljenoMesto> nMesta = NaseljenoMesto.findAll();
		List<KlijentFizickoLice> klijenti = KlijentFizickoLice.findAll();
		if (mode == null || mode.equals(""))
			mode = "edit";

		render(drzave, nMesta, klijenti, mode);
	}

	public static void create(KlijentFizickoLice klijent) {
		try {
			klijent.save();
		}
		catch(PersistenceException e) {
			error("Niste uneli validne podatke.");
		}

		show("edit");
	}

	public static void edit(KlijentFizickoLice klijent) {
		try {
			KlijentFizickoLice k = KlijentFizickoLice.findById(klijent.id);
			k.setIme(klijent.ime);
			k.setPrezime(klijent.prezime);
			k.setNaseljenoMesto(klijent.naseljenoMesto);
			k.setAdresa(klijent.adresa);
			k.save();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Klijenta.");
		}
		catch(PersistenceException e) {
			error("Niste uneli validne podatke.");
		}
		show("edit");

	}

	public static void remove(Long id) {
		try {
			KlijentFizickoLice k = KlijentFizickoLice.findById(id);
			k.delete();
		}
		catch(IllegalArgumentException e) {
			error("Niste odabrali Klijenta.");
		}

		show("edit");

	}

	public static void filter(KlijentFizickoLice klijent, String mode) {
		List<KlijentFizickoLice> klijenti = KlijentFizickoLice.find(
				"ime like ? AND prezime like ? AND adresa like ? AND naseljenomesto_id = ?", "%" + klijent.ime + "%",
				"%" + klijent.prezime + "%", "%" + klijent.adresa + "%", klijent.naseljenoMesto.id).fetch();

		renderTemplate("KlijentiFizickaLica/show.html", klijenti);
	}

	public static void exportKl(Long id) {
		KlijentFizickoLice klijentFL = KlijentFizickoLice.findById(id);
		try {

			File file = new File("D:\\" + klijentFL.ime + "-" + klijentFL.prezime + ".xml");
			JAXBContext jaxbContext = null;
			jaxbContext = JAXBContext.newInstance(KlijentFizickoLice.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(klijentFL, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		show("edit");
	}
}
