package cz.czechitas.java2webapps.lekce2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

//Anotace říká - tahle třída, kt. jsem vytvořila, je Controller
@Controller
public class KostkaController {

    private final Random random;

    public KostkaController(){
        random = new Random();
    }

    //na jakou adresu má být metoda připojena
    @GetMapping("/")
    public ModelAndView hodKostkou(){

        int nahodneCislo = random.nextInt(6) + 1;

        //viewName je to, jak se v templates ten HTML soubor jmenuje
        //model - vypisuje se pak v šabloně
        ModelAndView result = new ModelAndView("kostka");
        //první je String a druhé může být jakýkoliv objekt
        result.addObject("cislo", nahodneCislo);
        result.addObject("obrazek", String.format("/images/kostka-%d.svg", nahodneCislo));
        return result;

    }

}
