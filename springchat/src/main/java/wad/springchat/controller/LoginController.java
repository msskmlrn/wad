package wad.springchat.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    @RequestMapping(value = "Login", method = RequestMethod.GET)
    public String naytaKirjautumislomake() {
        return "Login";
    }
    
    @RequestMapping(value = "Login", method = RequestMethod.POST)
    public String tallennaKirjautuminen(@RequestParam String tunnus, HttpSession session) {
        session.setAttribute("tunnus", tunnus);
        return "redirect:/Chat";
    }
}
