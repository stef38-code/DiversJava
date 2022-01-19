package org.example.java.pattern.singleton;

public class VoitureFactory {
    public static volatile Voiture voiture;


    public Voiture getInstance() {
        Voiture localVoiture = voiture;
        if (localVoiture == null) {
            synchronized (this) {
                localVoiture = voiture;

                if (localVoiture == null) {
                    voiture = localVoiture = new Voiture();
                }
            }
        }
        return localVoiture;
    }


}
