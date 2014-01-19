package wad.elokuva.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Elokuva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(name = "NIMI")
    private String nimi;
    @Column(name = "PITUUS")
    private double pituus;
    @Column(name = "VUOSI")
    private String vuosi;
    @ManyToMany
    private List<Genre> genret;
    
    public Elokuva() { 
    }
    
    public Elokuva(String nimi, double pituus, String vuosi) {
        this.nimi = nimi;
        this.pituus = pituus;
        this.vuosi = vuosi;
    }
    
    public List<Genre> getGenret() {
        return genret;
    }

    public void setGenret(List<Genre> genret) {
        this.genret = genret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public double getPituus() {
        return pituus;
    }

    public void setPituus(double pituus) {
        this.pituus = pituus;
    }

    public String getVuosi() {
        return vuosi;
    }

    public void setVuosi(String vuosi) {
        this.vuosi = vuosi;
    }
    
    public void lisaaGenre(Genre genre) {
        this.genret.add(genre);
    }
}