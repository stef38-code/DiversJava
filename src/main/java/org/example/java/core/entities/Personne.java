package org.example.java.core.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Personne {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private List<Adresse> adresses;
}
