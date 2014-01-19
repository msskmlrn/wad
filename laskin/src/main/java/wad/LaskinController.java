package wad;

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