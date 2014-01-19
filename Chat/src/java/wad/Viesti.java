/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad;

/**
 *
 * @author miika
 */
public class Viesti {
    private String kirjoittaja;
    private String kirjoitus;
    
    public Viesti (String kirjoitus) {
        this.kirjoitus = kirjoitus;
    }

    public String getKirjoittaja() {
        return kirjoittaja;
    }

    public void setKirjoittaja(String kirjoittaja) {
        this.kirjoittaja = kirjoittaja;
    }

    public String getKirjoitus() {
        return kirjoitus;
    }

    public void setKirjoitus(String kirjoitus) {
        this.kirjoitus = kirjoitus;
    }
}
