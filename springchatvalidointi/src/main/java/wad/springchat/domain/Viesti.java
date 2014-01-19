package wad.springchat.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Viesti {
    
    private String tunnus;
    @Size(min=1, message="Viestin pitää olla vähintään yhden merkin mittainen")
    @Pattern(regexp="\\w", message="Viesti voi sisältää vain seuraavia merkkejä: a-z, A-Z, 0-9")
    private String viesti;
    
    public Viesti() {
    }
    
    public Viesti(String tunnus, String viesti) {
        this.tunnus = tunnus;
        this.viesti = viesti;
    }

    public String getTunnus() {
        return tunnus;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    public String getViesti() {
        return viesti;
    }

    public void setViesti(String viesti) {
        this.viesti = viesti;
    }
}