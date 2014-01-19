package wad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class kilpailuController {
    
    @RequestMapping("kilpailu")
    public String heiSpring() {
        System.out.println("Heippa!");
        return "syota";
    }
    
    
    @RequestMapping(value="osallistu", method=RequestMethod.POST)
    public String tulostaHenkilo(@ModelAttribute Osallistuja osallistuja) {
       
        System.out.println("Henkilön nimi: " + osallistuja.getNimi());
        System.out.println("Henkilön sähköpostiosoite: " + osallistuja.getEmail());
        
        //return "osallistu";
        return "osallistu";
    }
    
    
}


/*
 * package wad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LaskinController {
    
    @RequestMapping("summa")
    public String summalasku(Model model, int eka, int toka) {
        int tulos = eka + toka;
        
        model.addAttribute("tulos", tulos);
        
        return "laskin";
    }
    
    @RequestMapping("kerto")
    public String kertolasku(Model model, int eka, int toka) {
        int tulos = eka * toka;
        
        model.addAttribute("tulos", tulos);
        
        return "laskin";
    }
    
    @RequestMapping("jako")
    public String jakolasku(Model model, int eka, int toka) {
        double tulos = 1.0 * eka;
        tulos = tulos / toka;
        
        model.addAttribute("tulos", tulos);
        
        return "laskin";
    }
}


/*
@Controller
public class EkaController {

    @RequestMapping("eka")
    public String heiSpring() {
        System.out.println("Heippa!");
        return "index.jsp";
    }
}
 @RequestMapping("eka")
    public String heiSpring(Model model, HttpSession session) {
        System.out.println("Heippa!");

        int kaynteja = 0;
        if (session.getAttribute("kaynnit") != null) {
            kaynteja = (Integer) session.getAttribute("kaynnit");
        }

        kaynteja = kaynteja + 1;
        session.setAttribute("kaynnit", kaynteja);


        model.addAttribute("viesti", kaynteja);
        return "index.jsp";
    }

*/