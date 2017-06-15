package controllers;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import models.AnalitikaIzvoda;
import models.Klijent;
import models.KlijentFizickoLice;
import models.KlijentPravnoLice;
import play.mvc.Controller;

public class ExportIzvodaKlijenta extends Controller {

	public static void exportKL(Long id) {

		Klijent klijent = Klijent.findById(id);
		try {

			File file = null;
			JAXBContext jaxbContext = null;
			KlijentFizickoLice klijentFL = null;
			KlijentPravnoLice klijentPL = null;
			if (KlijentFizickoLice.findById(id) != null) {
				jaxbContext = JAXBContext.newInstance(KlijentFizickoLice.class);
				klijentFL = KlijentFizickoLice.findById(id);
				file = new File("D:\\" + klijentFL.ime + "-" + klijentFL.prezime + ".xml");
			} else if (KlijentPravnoLice.findById(id) != null) {
				jaxbContext = JAXBContext.newInstance(KlijentPravnoLice.class);

				klijentPL = KlijentPravnoLice.findById(id);
				file = new File("D:\\" + klijentPL.naziv +  ".xml");
			}

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			if (klijentFL != null)
				jaxbMarshaller.marshal(klijentFL, file);
			else
				jaxbMarshaller.marshal(klijentPL, file);
			// output pretty printed

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		renderTemplate("Application/index.html");
	}

	public static void showExport() {
		List<KlijentFizickoLice> klijentiFL = KlijentFizickoLice.findAll();
		List<KlijentPravnoLice> klijentiPL = KlijentPravnoLice.findAll();

		renderTemplate("KlijentiFizickaLica/export.html", klijentiFL, klijentiPL);
	}
}
