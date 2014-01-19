package wad.varasto.domain;

public class Esine {
    private static int LASKURI = 1;

    private int id;
    private String nimi;
    private Double paino;

    public Esine() {
        id = LASKURI++;
    }

    public static int getLASKURI() {
        return LASKURI;
    }

    public static void setLASKURI(int LASKURI) {
        Esine.LASKURI = LASKURI;
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

    public Double getPaino() {
        return paino;
    }

    public void setPaino(Double paino) {
        this.paino = paino;
    }
}    