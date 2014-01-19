package wad.soahitcounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wad.soahitcounter.service.HitCounter;

@Controller
public class hitCounterController {
    
    @Autowired
    private HitCounter hitCounter;
    
    @RequestMapping("hitCounter")
    public String listaa(Model model) {
        
        model.addAttribute("hits", hitCounter.getAndIncrementCount());
        
        return "hitsPage";
    }
}
