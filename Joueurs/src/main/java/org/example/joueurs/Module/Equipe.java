package org.example.joueurs.Module;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Equipe {

    private Long id;
    private Long numSerie;
    private String code;
    private String libelle;

    public Equipe(Long id, Long numSerie, String code, String libelle) {
        this.id = id;
        this.numSerie = numSerie;
        this.code = code;
        this.libelle = libelle;
    }

    public Equipe() {
    }

    public Long getId() {
        return id;
    }

    public Long getNumSerie() {
        return numSerie;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumSerie(Long numSerie) {
        this.numSerie = numSerie;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
