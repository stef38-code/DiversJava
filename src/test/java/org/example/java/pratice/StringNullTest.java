package org.example.java.pratice;

import org.junit.jupiter.api.*;

import java.util.Locale;

import static org.assertj.core.api.BDDAssertions.*;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Test cas String null")
class StringNullTest {

    private String nom;

    @BeforeEach
    void setUp() {
        nom = "dupont";
    }

    @Test
    @Order(1)
    @DisplayName("Test cas NullPointerException")
    void useCaseNomMajuscule_null() {
        StringNull exemple = new StringNull();
        //
        thenThrownBy(exemple::useCaseNomMajuscule)
                .isInstanceOf(NullPointerException.class);
    }
    @Test
    @Order(1)
    @DisplayName("Test cas NullPointerException")
    void useCaseNomMajuscule_nullChangeValue() {
        StringNull exemple = new StringNull();
        exemple.setNom(nom);
        //
        thenNoException().isThrownBy(exemple::useCaseNomMajuscule);
        then(exemple.useCaseNomMajuscule()).isNotNull().hasToString(nom.toUpperCase(Locale.ROOT));

    }
    @Test
    @Order(2)
    @DisplayName("Test cas empty")
    void useCaseNomMajuscule_empty() {
        StringEmpty exemple = new StringEmpty();
        //
        thenNoException().isThrownBy(exemple::useCaseNomMajuscule);
        then(exemple.useCaseNomMajuscule()).isNotNull();

    }
    @Test
    @Order(3)
    @DisplayName("Test cas empty")
    void useCaseNomMajuscule_emptyChangeValue() {
        StringEmpty exemple = new StringEmpty();
        exemple.setNom(nom);
        //
        thenNoException().isThrownBy(exemple::useCaseNomMajuscule);
        then(exemple.useCaseNomMajuscule()).isNotNull().hasToString(nom.toUpperCase(Locale.ROOT));

    }
    @Test
    @Order(4)
    @DisplayName("Test cas Optional")
    void useCaseNomMajuscule_optional() {
        StringOptional exemple = new StringOptional();
        //
        thenNoException().isThrownBy(exemple::useCaseNomMajuscule);
        then(exemple.useCaseNomMajuscule()).isNotNull();
    }
    @Test
    @Order(5)
    @DisplayName("Test cas Optional")
    void useCaseNomMajuscule_optionalChangeValue() {
        StringOptional exemple = new StringOptional();
        exemple.setNom(nom);
        //
        thenNoException().isThrownBy(exemple::useCaseNomMajuscule);
        then(exemple.useCaseNomMajuscule()).isNotNull().hasToString(nom.toUpperCase(Locale.ROOT));
    }
}
