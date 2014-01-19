/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.springchat.controller;

import java.util.LinkedList;
import java.util.Queue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.springchat.domain.Viesti;

@Controller
public class ChatController {
    private Queue<Viesti> viestit = new LinkedList<Viesti>();
    
    @RequestMapping("Chat")
    public String naytaViestit(Model model, HttpSession session, HttpServletRequest request) {
       boolean kirjautunut = tarkistaKirjautuminen(session);
       if (!kirjautunut) {
           return "redirect:/Login";
       }
       model.addAttribute("viestit", viestit);
       return "Chat";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String lisaaUusiViesti(@Valid @ModelAttribute("kommentti") Viesti viesti, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "Chat";
        }
        
        boolean kirjautunut = tarkistaKirjautuminen(session);
        if (!kirjautunut) {
            return "redirect:/Login";
        }
        
        String tunnus = "" + session.getAttribute("tunnus");
        Viesti uusiViesti = new Viesti(tunnus, viesti.getViesti());
        if (viestit.size() < 10) {
            viestit.add(uusiViesti);
        } else {
            viestit.poll();
            viestit.add(uusiViesti);
        }
        return "redirect:/Chat";
    }
    
    private boolean tarkistaKirjautuminen(HttpSession session) {
        if (session.getAttribute("tunnus") == null) {
            return false;
        }
        return true;
    }
}