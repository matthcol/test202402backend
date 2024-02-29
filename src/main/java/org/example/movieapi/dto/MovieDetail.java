package org.example.movieapi.dto;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MovieDetail extends MovieSimple {

        private PersonSimple director;
        private List<PersonSimple> actors = new ArrayList<>();

        public PersonSimple getDirector() {
                return director;
        }

        public void setDirector(PersonSimple director) {
                this.director = director;
        }

        public List<PersonSimple> getActors() {
                return actors;
        }

        public void setActors(List<PersonSimple> actors) {
                this.actors = actors;
        }

        @Override
        public String toString() {
                return StringUtils.toString(this, "id", "title", "year");
        }
}
