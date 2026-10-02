package de.brockhausag.codingdojo.hausrat;

import de.brockhausag.codingdojo.hausrat.model.Anfrage;
import de.brockhausag.codingdojo.hausrat.model.Angebot;
import de.brockhausag.codingdojo.hausrat.model.Antrag;
import de.brockhausag.codingdojo.hausrat.model.Vertrag;

public interface Hausratservice {

    Anfrage ermittleAnfrage(String id);

    Angebot ermittleAngebot(String id);

    Angebot berechneBeitrag(Anfrage anfrage);

    Antrag ermittleAntrag(String id);

    Antrag stelleAntrag(Angebot angebot);

    Vertrag policiereAntrag(Antrag antrag);

    Vertrag holeVertrag(String id);

    void zieheAntragZurueck(Antrag antrag);
}
