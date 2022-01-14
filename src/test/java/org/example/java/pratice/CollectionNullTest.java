package org.example.java.pratice;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.BDDAssertions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test cas Collection null")
class CollectionNullTest {

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
    @DisplayName("Test cas optional")
    void useCaseGetSize_optional(){
        CollectionOptional exemple = new CollectionOptional();
        //
        thenNoException().isThrownBy(exemple::useCaseGetSize);
        then(exemple.useCaseGetSize()).isEqualTo(0);

    }
}
