package de.brockhausag.codingdojo.hausrat.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Vertrag extends Antrag {

    private final String vertragsnummer;

    private static final String VERTRAG = "VERTRAG-";

    public Vertrag(Antrag antrag) {
        if (antrag == null) {
            throw new IllegalArgumentException("Antrag must not be null");
        }
        super(antrag);
        this.id = VERTRAG + UUID.randomUUID();
        this.vertragsnummer = UUID.randomUUID().toString();
    }

}
