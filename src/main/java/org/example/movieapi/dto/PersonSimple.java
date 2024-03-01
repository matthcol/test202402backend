package org.example.movieapi.dto;

import java.util.StringJoiner;

public class PersonSimple extends PersonCreate {
    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PersonSimple.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name=" + getName())
                .toString();
    }
}
