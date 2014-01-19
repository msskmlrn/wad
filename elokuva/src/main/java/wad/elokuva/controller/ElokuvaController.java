package wad.elokuva.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.elokuva.domain.Elokuva;
import wad.elokuva.domain.Genre;
import wad.elokuva.service.ElokuvaPalvelu;
import wad.elokuva.service.GenrePalvelu;

@Controller
public class ElokuvaController {
   @Autowired
   ElokuvaPalvelu elokuvaPalvelu;
   
   @Autowired
   GenrePalvelu genrePalvelu;
   
   @RequestMapping("*")
   public String ohjaa() {
       return "redirect:/listaa";
   }
   
   @RequestMapping("listaa")
   public String listaa(Model model) {
       List<Elokuva> elokuvat = elokuvaPalvelu.listaa();
       model.addAttribute("elokuvat", elokuvat);
       return "elokuvat";
   }
   
   @RequestMapping(value = "lisaa", method = RequestMethod.POST)
   public String lisaaElokuva(@ModelAttribute Elokuva elokuva) {
       elokuvaPalvelu.lisaa(elokuva);
       return "redirect:/listaa";
   }
   
   @RequestMapping(value = "lisaaGenre", method = RequestMethod.POST)
   public String lisaaGenre(@ModelAttribute Genre genre) {
       genrePalvelu.lisaa(genre);
       return "redirect:/listaaGenret";
   }
   
   @RequestMapping("listaaGenret")
   public String listaaGenret(Model model) {
       model.addAttribute("genret", genrePalvelu.listaa());
       return "genret";
   }
   
   @RequestMapping("lisaaElokuvalleGenre/{elokuvaId}/{genreNimi}")
   public String lisaaElokuvalleGenre(@PathVariable Integer elokuvaId, @PathVariable String genreNimi) {
       Elokuva elokuva = elokuvaPalvelu.hae(elokuvaId);
       Genre genre = genrePalvelu.hae(genreNimi);
       elokuva.lisaaGenre(genre);
       genre.lisaaElokuva(elokuva);
       elokuvaPalvelu.paivita(elokuva);
       genrePalvelu.paivita(genre);
       return "redirect:/listaa";
   }
   
   @RequestMapping("nayta/{elokuvaId}")
   public String naytaElokuva(@PathVariable Integer elokuvaId, Model model) {
       Elokuva elokuva = elokuvaPalvelu.hae(elokuvaId);
       model.addAttribute("elokuva", elokuva);
       model.addAttribute("genret", elokuva.getGenret());
       return "elokuvanakyma";
   }
   
   @RequestMapping("naytaGenrella/{genreNimi}")
   public String naytaGenrella(@PathVariable String genreNimi, Model model) {
       Genre genre = genrePalvelu.hae(genreNimi);
       model.addAttribute("genre", genre);
       model.addAttribute("elokuvat", genre.getElokuvat());
       return "genrenakyma";
   }
}
