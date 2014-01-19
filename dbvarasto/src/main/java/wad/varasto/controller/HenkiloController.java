package wad.varasto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.varasto.domain.Henkilo;
import wad.varasto.service.HenkiloPalvelu;

@Controller
public class HenkiloController {
    
    @Autowired HenkiloPalvelu henkiloPalvelu;
    
    @RequestMapping("henkilopalvelu/*")
    public String nayta() {
        return "redirect:/listaaHenkilot";
    }
    
    @RequestMapping("henkilopalvelu")
    public String henkiloLista(Model model) {
        model.addAttribute("henkilot", henkiloPalvelu.listaaHenkilot());
        return "henkilopalvelu";
    }
    
    @RequestMapping(value = "henkilopalvelu/lisaa", method = RequestMethod.POST)
    public String lisaaHenkilo(@ModelAttribute Henkilo henkilo) {
        henkiloPalvelu.lisaaHenkilo(henkilo);
        return "redirect:/henkilopalvelu/";
    }
    
    @RequestMapping(value = "henkilopalvelu/poista/{henkiloId}")
    public String poistaHuone(@PathVariable Integer henkiloId) {
        henkiloPalvelu.poistaHenkilo(henkiloId);
        return "redirect:/henkilopalvelu/";
    }
    
}