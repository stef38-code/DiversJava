package org.example.java.pattern.visitor;

public interface Livraison {
    void visit(LaPoste laPoste);

    void visit(Livreur livreur);

    void visit(PointRelais pointRelais);
}
