
package wad;

public class Osallistuja {
    private String nimi;
    private String email;
    private String osallistuuKilpailuun;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public String getOsallistuuKilpailuun() {
        return osallistuuKilpailuun;
    }

    public void setOsallistuuKilpailuun(String osallistuuKilpailuun) {
        this.osallistuuKilpailuun = osallistuuKilpailuun;
    }
}
