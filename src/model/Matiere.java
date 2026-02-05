package model;

public class Matiere {

    private int id;
    private String libelle;
    private int coefficient;

    public Matiere() {
    }

    public Matiere(int id, String libelle, int coefficient) {
        this.id = id;
        this.libelle = libelle;
        this.coefficient = coefficient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }
}
