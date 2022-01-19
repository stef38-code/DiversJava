package org.example.java.pattern.visitor;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class PatternVisitorTest {
    @Test
    void afficheTarif() {
        PatternVisitor patternVisitor = new PatternVisitor();


        String resultat = patternVisitor.afficheTarif().toString();
        then(resultat).isNotBlank()
                .contains("Type: La poste  Delai: 7 jours tarif:15,5 €")
                .contains("Type: UPS Delai: 3 jours tarif:20,162 €")
                .contains("Type: Mondial Relay STATION AVIA Delai: 5 jours tarif:10,55 €");
    }


}

