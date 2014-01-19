package wad.springchat.domain;

public class Viesti {
    private String tunnus;
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