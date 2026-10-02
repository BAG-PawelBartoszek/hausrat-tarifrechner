package de.brockhausag.codingdojo.hausrat.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class AngebotTest {

    @Test
    void getPraemie() {
        var erwartetePraemie = BigDecimal.valueOf(75.35);
        var anfrage = new Anfrage(80, "50667", true, true);
        var angebot = new Angebot(anfrage);

        var aktuellePraemie = angebot.getPraemie();

        assertThat(aktuellePraemie).isEqualTo(erwartetePraemie);
    }

    @Test
    void getMinimalPraemie() {
        var erwartetePraemie = BigDecimal.valueOf(50);
        var anfrage = new Anfrage(20, "90667", false, false);
        var angebot = new Angebot(anfrage);

        var aktuellePraemie = angebot.getPraemie();

        assertThat(aktuellePraemie).isEqualTo(erwartetePraemie);
    }
}