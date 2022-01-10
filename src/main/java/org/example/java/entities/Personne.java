package org.example.java.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Personne {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
}