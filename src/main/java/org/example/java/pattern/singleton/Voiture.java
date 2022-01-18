package org.example.java.pattern.singleton;

import lombok.Getter;

import java.util.Objects;

public class Voiture {
    public static Voiture voiture;

    @Getter
    public int nbRoues;
    @Getter
    public String marque;
    @Getter
    public String couleur;

    public static Voiture getInstance() {
        if(Objects.isNull(voiture)){
            synchronized (Voiture.class){
                if (Objects.isNull(voiture)) {
                    voiture = new Voiture();
                }
            }
        }
        return voiture;
    }
     public void setInfoVoiture(int nbRoues,String marque,String couleur){
         this.nbRoues = nbRoues;
         this.marque = marque;
         this.couleur = couleur;
     }

}
