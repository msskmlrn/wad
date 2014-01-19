package wad.elokuva.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genre implements Serializable {
    @Id
    private String nimi;
    @ManyToMany
    private List<Elokuva> elokuvat;
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    public String getNimi() {
        return this.nimi;
    }

    public void setElokuvat(List<Elokuva> elokuvat) {
        this.elokuvat = elokuvat;
    }

    public List<Elokuva> getElokuvat() {
        return elokuvat;
    }
    public void lisaaElokuva(Elokuva elokuva) {
        this.elokuvat.add(elokuva);
    }
}