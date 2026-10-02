package de.brockhausag.codingdojo.hausrat.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

@Getter
public class Angebot extends Anfrage {

    private final BigDecimal praemie;

    private static final String ANGEBOT = "ANGEBOT-";

    public Angebot(Anfrage anfrage) {
        if (anfrage == null) {
            throw new IllegalArgumentException("Anfrage darf nicht null sein");
        }

        super(anfrage.getWohnflaeche(), anfrage.getPlz(), anfrage.getSelbstbeteiligung(), anfrage.getFahhrad());
        this.id = ANGEBOT + UUID.randomUUID();
        this.praemie = berechnePraemie();
    }

    public Antrag beantrageAntrag() {
        return new Antrag(this);
    }

    private BigDecimal berechnePraemie() {
        var kalkuliertePraemie = 0.0;
        var versicherungssumme = this.getWohnflaeche() * 650;
        kalkuliertePraemie = versicherungssumme * promilleNachTarifzone() / 1000.0;

        if (this.getFahhrad()) {
            kalkuliertePraemie *= 1.15;
        }

        if (this.getSelbstbeteiligung()) {
            kalkuliertePraemie *= 0.9;
        }

        return kalkuliertePraemie < 50 ? BigDecimal.valueOf(50) : BigDecimal.valueOf(kalkuliertePraemie).setScale(2, RoundingMode.HALF_UP);
    }

    private double promilleNachTarifzone() {
        char firstDigit = this.getPlz().charAt(0);
        if (firstDigit <= '1') return 1.9;
        if (firstDigit <= '5') return 1.4;
        return 1.0;
    }
}
