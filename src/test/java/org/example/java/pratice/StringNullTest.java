package org.example.java.pratice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.BDDAssertions.*;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("Test cas String null")
class StringNullTest {

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
    @Order(2)
    @DisplayName("Test cas empty")
    void useCaseNomMajuscule_empty() {
        StringEmpty exemple = new StringEmpty();
        //
        thenNoException().isThrownBy(exemple::useCaseNomMajuscule);
        then(exemple.useCaseNomMajuscule()).isNotNull();

    }
    @Test
    @Order(2)
    @DisplayName("Test cas Optional")
    void useCaseNomMajuscule_optional() {
        StringOptional exemple = new StringOptional();
        //
        thenNoException().isThrownBy(exemple::useCaseNomMajuscule);
        then(exemple.useCaseNomMajuscule()).isNotNull();
    }
}
