package wad.henkilotHuoneisiin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.henkilotHuoneisiin.domain.Henkilo;
import wad.henkilotHuoneisiin.domain.Huone;
import wad.henkilotHuoneisiin.service.HenkiloPalvelu;
import wad.henkilotHuoneisiin.service.HuonePalvelu;

@Controller
public class HenkiloController {
    
    @Autowired
    HenkiloPalvelu henkiloPalvelu;
    @Autowired
    HuonePalvelu huonePalvelu;

    @RequestMapping("listaaHenkilot")
    public String listaa(Model model) {
        List<Henkilo> lista = henkiloPalvelu.listaa();
        model.addAttribute("henkilot", lista);
        return "henkilot";
    }

    @RequestMapping(value = "lisaaHenkilo", method = RequestMethod.POST)
    public String lisaaHenkilo(@ModelAttribute Henkilo henkilo) {
        henkiloPalvelu.lisaa(henkilo);
        return "redirect:/listaaHenkilot";
    }

    @RequestMapping(value = "poistaHenkilo/{henkilonNimi}")
    public String poistaHenkilo(@PathVariable String henkilonNimi) {
        
        //poistetaan henkilö myös huoneesta
        for (Huone huone : huonePalvelu.listaa()) {
            if (huone.getHenkilot().size() > 0) {
                for (Henkilo henkilo : huone.getHenkilot()) {
                    if (henkilo.getNimi().equals(henkilonNimi)) {
                        huone.getHenkilot().remove(henkilo);
                        henkiloPalvelu.lisaa(henkilo);
                        huonePalvelu.lisaa(huone);
                        break;
                    }
                }
            }
        }
        
        henkiloPalvelu.poista(henkilonNimi);
        return "redirect:/listaaHenkilot";
    }

    @RequestMapping(value = "naytaHenkilo/{henkilonNimi}")
    public String naytaHenkilo(@PathVariable String henkilonNimi, Model model) {
        Henkilo henkilo = henkiloPalvelu.hae(henkilonNimi);
        model.addAttribute("henkilo", henkilo);
        model.addAttribute("huone", henkilo.getHuone());
        return "henkilonakyma";
    }

    @RequestMapping(value = "siirraHenkilo/{huoneId}/{henkilonNimi}")
    public String siirraHenkilo(@PathVariable Integer huoneId, @PathVariable String henkilonNimi) {
        Huone huone = huonePalvelu.etsiHuone(huoneId);
        Henkilo henkilo = henkiloPalvelu.hae(henkilonNimi);
        if (huone.getHenkilot().size() + 1 <= huone.getKapasiteetti() 
                && !(henkilo.getHuone() != null 
                && ovatkoSamat(henkilo.getHuone().getId(), huone.getId()))) {
            henkilo.setHuone(huone);
            huone.lisaaHenkilo(henkilo);
            henkiloPalvelu.update(henkilo);
            huonePalvelu.update(huone);
        }
        
        return "redirect:/naytaHenkilo/{henkilonNimi}";
    }

    private boolean ovatkoSamat(int eka, int toka) {
        if ((Integer) eka != null) {
            if (eka == toka) {
                return true;
            }
        }
        return false;
    }
    
}