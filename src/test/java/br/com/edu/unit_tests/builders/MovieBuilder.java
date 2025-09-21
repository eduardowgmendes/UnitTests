package br.com.edu.unit_tests.builders;

import java.lang.Integer;
import java.lang.Double;
import java.lang.String;

import br.com.edu.unit_tests.entity.Movie;

public class MovieBuilder {

    private Movie movie;

    private MovieBuilder() {
    }

    public static MovieBuilder umMovie() {
        MovieBuilder builder = new MovieBuilder();
        withDefault(builder);
        return builder;
    }

    public static void withDefault(MovieBuilder builder) {
        builder.movie = new Movie();
        Movie movie = builder.movie;
        movie.setName("");
        movie.setInventoryCount(0);
        movie.setPrice(0.0);
    }

    public MovieBuilder withName(String param) {
        movie.setName(param);
        return this;
    }

    public MovieBuilder withInventoryCount(Integer param) {
        movie.setInventoryCount(param);
        return this;
    }

    public MovieBuilder withPrice(Double param) {
        movie.setPrice(param);
        return this;
    }

    public Movie now() {
        return movie;
    }
}
