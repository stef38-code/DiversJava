package org.example.java.pattern.singleton;

import lombok.Getter;

public class Voiture  {
    @Getter
    public int nbRoues;
    @Getter
    public String marque;
    @Getter
    public String couleur;
    public void setInfoVoiture(int nbRoues,String marque,String couleur){
        this.nbRoues = nbRoues;
        this.marque = marque;
        this.couleur = couleur;
    }
}
