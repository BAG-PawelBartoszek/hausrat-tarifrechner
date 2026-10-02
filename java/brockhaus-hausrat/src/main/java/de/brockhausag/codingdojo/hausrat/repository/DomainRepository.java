package de.brockhausag.codingdojo.hausrat.repository;

import de.brockhausag.codingdojo.hausrat.model.Anfrage;
import de.brockhausag.codingdojo.hausrat.model.Angebot;
import de.brockhausag.codingdojo.hausrat.model.Antrag;
import de.brockhausag.codingdojo.hausrat.model.Vertrag;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DomainRepository {
    private final Map<String, Anfrage> anfragen = new HashMap<>();
    private final Map<String, Angebot> angebote = new HashMap<>();
    private final Map<String, Antrag> antraege = new HashMap<>();
    private final Map<String, Vertrag> vertraege = new HashMap<>();

    public void save(Anfrage anfrage) {
        if (anfragen.containsKey(anfrage.getId())) {
            throw new IllegalStateException("Anfrage mit ID " + anfrage.getId() + " existiert bereits");
        }
        anfragen.put(anfrage.getId(), anfrage);
    }

    public Optional<Anfrage> loadAnfrage(String id) {
        return Optional.ofNullable(anfragen.get(id));
    }

    public void save(Angebot angebot) {
        if (angebote.containsKey(angebot.getId())) {
            throw new IllegalStateException("Angebot mit ID " + angebot.getId() + " existiert bereits");
        }
        angebote.put(angebot.getId(), angebot);
    }

    public Optional<Angebot> loadAngebot(String id) {
        return Optional.ofNullable(angebote.get(id));
    }

    public void save(Antrag antrag) {
        if (antraege.containsKey(antrag.getId())) {
            throw new IllegalStateException("Antrag mit ID " + antrag.getId() + " existiert bereits");
        }
        antraege.put(antrag.getId(), antrag);
    }

    public Optional<Antrag> loadAntrag(String id) {
        return Optional.ofNullable(antraege.get(id));
    }

    public void save(Vertrag vertrag) {
        if (vertraege.containsKey(vertrag.getId())) {
            throw new IllegalStateException("Vertrag mit ID " + vertrag.getId() + " existiert bereits");
        }
        vertraege.put(vertrag.getId(), vertrag);
    }

    public Optional<Vertrag> loadVertrag(String id) {
        return Optional.ofNullable(vertraege.get(id));
    }
}
