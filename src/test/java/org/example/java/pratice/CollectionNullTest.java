package org.example.java.pratice;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test cas Collection null")
class CollectionNullTest {

    private List<String> liste;

    @BeforeEach
    void setUp() {
        liste = List.of("AA", "BB");
    }

    @Test
    @Order(1)
    @DisplayName("Test cas NullPointerException")
    void useCaseGetSize_Null() {
        CollectionNull exemple = new CollectionNull();
        //
        thenThrownBy(exemple::useCaseGetSize)
                .isInstanceOf(NullPointerException.class);
    }
    @Test
    @Order(1)
    @DisplayName("Test cas NullPointerException")
    void useCaseGetSize_NullChangeValue() {
        CollectionNull exemple = new CollectionNull();
        //
        exemple.setListe(liste);
        //
        thenNoException().isThrownBy(exemple::useCaseGetSize);
        then(exemple.useCaseGetSize()).isEqualTo(2);
        then(exemple.getListe()).containsAll(liste);
    }
    @Test
    @Order(2)
    @DisplayName("Test cas empty")
    void useCaseGetSize_empty() {
        CollectionEmpty exemple = new CollectionEmpty();
        //
        thenNoException().isThrownBy(exemple::useCaseGetSize);
        then(exemple.useCaseGetSize()).isEqualTo(0);

    }
    @Test
    @Order(3)
    @DisplayName("Test cas empty")
    void useCaseGetSize_emptyChangeValue() {
        CollectionEmpty exemple = new CollectionEmpty();
        exemple.setListe(liste);
        //
        thenNoException().isThrownBy(exemple::useCaseGetSize);
        then(exemple.useCaseGetSize()).isEqualTo(2);
        then(exemple.getListe()).containsAll(liste);

    }
    @Test
    @Order(4)
    @DisplayName("Test cas optional")
    void useCaseGetSize_optional(){
        CollectionOptional exemple = new CollectionOptional();

        //
        thenNoException().isThrownBy(exemple::useCaseGetSize);
        then(exemple.useCaseGetSize()).isEqualTo(0);

    }
    @Test
    @Order(5)
    @DisplayName("Test cas optional")
    void useCaseGetSize_optionalChangeValue(){
        CollectionOptional exemple = new CollectionOptional();
        exemple.setListe(liste);
        //
        thenNoException().isThrownBy(exemple::useCaseGetSize);
        then(exemple.useCaseGetSize()).isEqualTo(2);
        then(exemple.getListe()).containsAll(liste);
    }
}
