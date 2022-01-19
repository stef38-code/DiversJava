package org.example.java.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class PatternVisitor {
    private final List<ForfaitLivraison> forfaits = new ArrayList<>();

    public PatternVisitor() {
        forfaits.add(new LaPoste(7, "La poste ", 15.5));
        forfaits.add(new Livreur(3, "UPS", 17.0, 18.6));
        forfaits.add(new PointRelais(5, "Mondial Relay STATION AVIA", 10.0, 5.5));
    }

    public StringBuilder afficheTarif() {
        LivraisonImpl livraison = new LivraisonImpl();
        for (ForfaitLivraison forfait : forfaits) {
            forfait.accept(livraison);
        }
        return livraison.getAfficheTarif();
    }
}
