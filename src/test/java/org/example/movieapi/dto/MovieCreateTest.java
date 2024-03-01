package org.example.movieapi.dto;


import org.example.movieapi.enums.ColorType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MovieCreateTest {

    // oldschool unit test: 1 value only (need multiple copy/paste)
    @Test
    void testName_oneValue() {
        // given
        String givenName = "Dune: Part Two";
        var movie = new MovieCreate();
        // when: call method to test
        movie.setName(givenName);
        var actualName = movie.getName();
        // then: verify
        assertNotNull(actualName);
        assertEquals(actualName, givenName);
    }

    @ParameterizedTest(name="[{index}] name=''{0}''")
    @ValueSource(strings={
            // NB: wrong buisiness value, accepted here
            "",
            // ok values
            "Z",
            "Dune 2: Part Two",
            "Night of the Day of the Dawn of the Son of the Bride of the Return of the Revenge of the Terror of the Attack of the Evil Mutant Hellbound Flesh Eating Crawling Alien Zombified Subhumanoid Living Dead, Part 5"
    })
    // NB: wrong buisiness value, accepted here
    @NullSource
    void testName(String givenName) {
        // given
        var movie = new MovieCreate();
        // when: call method to test
        movie.setName(givenName);
        var actualName = movie.getName();
        // then: verify
        assertEquals(actualName, givenName);
    }

    @Test
    void testName() {
        fail();
    }

    @Test
    void testYear() {
        fail();
    }

    @Test
    void testDuration() {
        fail();
    }

    @Test
    void testSynopsis() {
        fail();
    }

    @ParameterizedTest
    @EnumSource(ColorType.class) // for all values of this enum type
    @NullSource
    void testColorType(ColorType givenColorType) {
        // given
        var movie = new MovieCreate();
        // when: call method to test
        movie.setColorType(givenColorType);
        var actualColorType = movie.getColorType();
        // then: verify
        assertEquals(actualColorType, givenColorType);
    }
}