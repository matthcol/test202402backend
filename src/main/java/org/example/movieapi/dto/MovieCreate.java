package org.example.movieapi.dto;

import jakarta.validation.constraints.NotNull;
import org.example.movieapi.enums.ColorType;
import utils.StringUtils;

public class MovieCreate {

    @NotNull
    private String name;
    private short year;
    private Short duration;
    private String synopsis;
    private ColorType colorType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public Short getDuration() {
        return duration;
    }

    public void setDuration(Short duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    @Override
    public String toString() {
        return StringUtils.toString(this,"title", "year");
    }
}
