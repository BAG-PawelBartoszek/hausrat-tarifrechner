package de.brockhausag.codingdojo.hausrat.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Anfrage {
    protected String id;
    private final Integer wohnflaeche;
    private final String plz;
    private final Boolean selbstbeteiligung;
    private final Boolean fahhrad;

    private static final String ANFRAGE = "ANFRAGE-";

    public Anfrage(Integer wohnflaeche, String plz, Boolean selbstbeteiligung, Boolean fahhrad) {

        if (wohnflaeche == null) {
            throw new IllegalArgumentException("Wohnfläche darf nicht null sein");
        }

        if (plz == null) {
            throw new IllegalArgumentException("PLZ darf nicht null sein");
        }

        if (wohnflaeche < 20) {
            throw new IllegalArgumentException("Wohnfläche darf nicht kleiner als 20qm sein");
        }

        if (wohnflaeche > 500) {
            throw new IllegalArgumentException("Wohnfläche darf nicht größer als 500qm sein");
        }

        if (!plz.matches("\\d{5}")) {
            throw new IllegalArgumentException("PLZ muss genau 5 Ziffern lang sein");
        }

        if (selbstbeteiligung == null) {
            throw new IllegalArgumentException("Selbstbeteiligung darf nicht null sein");
        }

        if (fahhrad == null) {
            throw new IllegalArgumentException("Fahrrad darf nicht null sein");
        }

        this.id = ANFRAGE + UUID.randomUUID();
        this.wohnflaeche = wohnflaeche;
        this.plz = plz;
        this.selbstbeteiligung = selbstbeteiligung;
        this.fahhrad = fahhrad;
    }

    public Angebot erstelleAngebot() {
        return new Angebot(this);
    }

}
