package org.example.java.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Adresse {
    private String id;
    private String appartementEscalierEtage;
    private String batimentResidence;
    private String numeroNomVoie;
    private String complementAdresse;
    private String codePostal;
    private String ville;
    private String pays;
}
