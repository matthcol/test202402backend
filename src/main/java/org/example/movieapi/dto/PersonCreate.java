package org.example.movieapi.dto;

import java.time.LocalDate;

public class PersonCreate {
    private String name;
    private LocalDate birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
