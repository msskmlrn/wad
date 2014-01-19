package wad.varasto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.varasto.domain.Huone;
import wad.varasto.service.HuonePalvelu;

@Controller
public class HuoneController {
    
    @Autowired
    private HuonePalvelu huonePalvelu;
    
    @RequestMapping("/huonepalvelu/*")
    public String nayta() {
        return "redirect:/huonepalvelu/";
    }
    
    @RequestMapping("huonepalvelu")
    public String huoneLista(Model model) {
        model.addAttribute("huoneet", huonePalvelu.listaaHuoneet());
        return "huonepalvelu";
    }
    
    @RequestMapping(value = "huonepalvelu/lisaa", method = RequestMethod.POST)
    public String lisaaHuone(@ModelAttribute Huone huone) {
        huonePalvelu.lisaaHuone(huone);
        return "redirect:/huonepalvelu/";
    }
    
    @RequestMapping(value = "huonepalvelu/poista/{huoneId}")
    public String poistaHuone(@PathVariable Integer huoneId) {
        huonePalvelu.poistaHuone(huoneId);
        return "redirect:/huonepalvelu/";
    }
}