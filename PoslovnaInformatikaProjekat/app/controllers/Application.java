package controllers;

import java.util.List;

import models.KursnaLista;
import models.NaseljenoMesto;
import models.RacunPravnihLica;
import models.VrstaPlacanja;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() {
    
        renderTemplate("Application/index.html");
    }
}