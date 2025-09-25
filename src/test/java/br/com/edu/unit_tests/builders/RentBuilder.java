package br.com.edu.unit_tests.builders;

import br.com.edu.unit_tests.rent.entity.User;
import br.com.edu.unit_tests.rent.entity.Movie;

import java.lang.Double;
import java.util.Date;

import br.com.edu.unit_tests.rent.entity.Rent;


public class RentBuilder {
    private Rent rent;

    private RentBuilder() {
    }

    public static RentBuilder oneRent() {
        RentBuilder builder = new RentBuilder();
        withDefault(builder);
        return builder;
    }

    public static void withDefault(RentBuilder builder) {
        builder.rent = new Rent();
        Rent rent = builder.rent;
        rent.setUser(null);
        rent.setMovie(null);
        rent.setCreatedAt(null);
        rent.setDueDate(null);
        rent.setValue(0.0);
    }

    public RentBuilder withUser(User param) {
        rent.setUser(param);
        return this;
    }

    public RentBuilder withMovie(Movie param) {
        rent.setMovie(param);
        return this;
    }

    public RentBuilder createdAt(Date param) {
        rent.setCreatedAt(param);
        return this;
    }

    public RentBuilder dueDate(Date param) {
        rent.setDueDate(param);
        return this;
    }

    public RentBuilder withValue(Double param) {
        rent.setValue(param);
        return this;
    }

    public Rent now() {
        return rent;
    }
}
