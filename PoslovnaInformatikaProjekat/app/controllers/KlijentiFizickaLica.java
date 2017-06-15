package controllers;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import models.Drzava;
import models.KlijentFizickoLice;
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

		klijent.save();

		show("edit");
	}

	public static void edit(KlijentFizickoLice klijent) {
		KlijentFizickoLice k = KlijentFizickoLice.findById(klijent.id);
		k.setIme(klijent.ime);
		k.setPrezime(klijent.prezime);
		k.setNaseljenoMesto(klijent.naseljenoMesto);
		k.setAdresa(klijent.adresa);
		k.save();
		show("edit");

	}

	public static void remove(Long id) {
		KlijentFizickoLice k = KlijentFizickoLice.findById(id);
		k.delete();

		show("edit");

	}

	public static void filter(KlijentFizickoLice klijent, String mode) {
		List<KlijentFizickoLice> klijenti = KlijentFizickoLice.find(
				"ime like ? AND prezime like ? AND adresa like ? AND naseljenomesto_id = ?", "%" + klijent.ime + "%",
				"%" + klijent.prezime + "%", "%" + klijent.adresa + "%", klijent.naseljenoMesto.id).fetch();

		renderTemplate("KlijentiFizickaLica/show.html", klijenti);
	}

}
