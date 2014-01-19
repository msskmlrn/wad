package wad.tehdyt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.tehdyt.service.Osallistuja;
import wad.tehdyt.service.Tiedot;

@Controller
public class tehdytController {
    
    @Autowired
    private Tiedot tiedot;
    
    @RequestMapping("hae")
    public String heiSpring() {
        System.out.println("Heippa!");
        return "tehdyt";
    }

    @RequestMapping(value="check", method=RequestMethod.POST)
    public String listaa(Model model, @ModelAttribute Osallistuja osallistuja) {
        
        System.out.println("OPISKELIJANUMERO"+osallistuja.getOpiskelijanumero());
        
        String tulos = tiedot.getTiedot(osallistuja.getOpiskelijanumero());
        
        model.addAttribute("tulos", tulos);
        
        return "check";
    }
}