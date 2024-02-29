package org.example.movieapi.dto;

import utils.StringUtils;

public class MovieSimple  extends MovieCreate {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return StringUtils.toString(this, "id", "title", "year");
    }
}
