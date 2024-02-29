package org.example.movieapi.utils;

import org.example.movieapi.dto.PersonSimple;

import java.time.LocalDate;

public class PersonSimpleFactory {

    public static PersonSimple personKevinSpacey() {
        var person = new PersonSimple();
        person.setId(123);
        person.setName("Kevin Spacey");
        person.setBirthdate(LocalDate.of(1959,7,26));
        return person;
    }

    public static PersonSimple personKeanuReeves() {
        var person = new PersonSimple();
        person.setId(456);
        person.setName("Keanu Reeves");
        person.setBirthdate(LocalDate.of(1964,9,2));
        return person;
    }

    public static PersonSimple personClintEastwood() {
        var person = new PersonSimple();
        person.setId(789);
        person.setName("Clint Eastwood");
        person.setBirthdate(LocalDate.of(1930,5,31));
        return person;
    }

}
