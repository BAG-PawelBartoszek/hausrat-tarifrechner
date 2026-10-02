package de.brockhausag.codingdojo.hausrat;

import de.brockhausag.codingdojo.hausrat.model.Anfrage;
import de.brockhausag.codingdojo.hausrat.model.Angebot;
import de.brockhausag.codingdojo.hausrat.model.Antrag;
import de.brockhausag.codingdojo.hausrat.model.Vertrag;
import de.brockhausag.codingdojo.hausrat.repository.DomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HausratserviceImpl implements Hausratservice {

    private final DomainRepository domainRepository;

    @Override
    public Anfrage ermittleAnfrage(String id) {
        return domainRepository.loadAnfrage(id).orElseThrow();
    }

    @Override
    public Angebot ermittleAngebot(String id) {
        return domainRepository.loadAngebot(id).orElseThrow();
    }

    @Override
    public Angebot berechneBeitrag(Anfrage anfrage) {
        var angebot = anfrage.erstelleAngebot();
        domainRepository.save(anfrage);
        domainRepository.save(angebot);

        return angebot;
    }

    @Override
    public Antrag ermittleAntrag(String id) {
        return domainRepository.loadAntrag(id).orElseThrow();
    }

    @Override
    public Antrag stelleAntrag(Angebot angebot) {
        var antrag = angebot.beantrageAntrag();
        domainRepository.save(antrag);
        return antrag;
    }

    @Override
    public Vertrag policiereAntrag(Antrag antrag) {
        var vertrag = antrag.policiere();
        domainRepository.save(vertrag);
        return vertrag;
    }

    @Override
    public Vertrag holeVertrag(String id) {
        return domainRepository.loadVertrag(id).orElseThrow();
    }

    @Override
    public void zieheAntragZurueck(Antrag antrag) {
        antrag.zurueckziehen();
        domainRepository.save(antrag);
    }
}
