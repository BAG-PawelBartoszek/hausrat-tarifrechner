package de.brockhausag.codingdojo.hausrat.model;

import java.util.UUID;

public class Antrag extends Angebot {

    private AntragStatus status;

    private static final String ANTRAG = "ANTRAG-";

    public Antrag(Angebot angebot) {
        if (angebot == null) {
            throw new IllegalArgumentException("Angebot darf nicht null sein");
        }

        super(angebot);
        this.id = ANTRAG + UUID.randomUUID();
        this.status = AntragStatus.EINGEREICHT;
    }

    public Vertrag policiere() {
        if (this.status != AntragStatus.EINGEREICHT) {
            throw new IllegalStateException("Policierte oder zurückgezogene Anträge lassen sich nicht mehr ändern. Dieser Antrag ist bereits im Status " + this.status);
        }

        this.status = AntragStatus.POLICIERT;
        return new Vertrag(this);
    }

    public void zurueckziehen() {
        if (this.status != AntragStatus.EINGEREICHT) {
            throw new IllegalStateException("Policierte oder zurückgezogene Anträge lassen sich nicht mehr ändern. Dieser Antrag ist bereits im Status " + this.status);
        }
        this.status = AntragStatus.ZURUECKGEZOGEN;
    }
}
