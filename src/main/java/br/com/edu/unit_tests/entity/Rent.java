package br.com.edu.unit_tests.entity;

import java.util.Date;
import java.util.Objects;

public class Rent {

    private User user;
    private Movie movie;
    private Date createdAt;
    private Date dueDate;
    private Double value;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return Objects.equals(user, rent.user) && Objects.equals(movie, rent.movie) && Objects.equals(createdAt, rent.createdAt) && Objects.equals(dueDate, rent.dueDate) && Objects.equals(value, rent.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, movie, createdAt, dueDate, value);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "user=" + user +
                ", movie=" + movie +
                ", createdAt=" + createdAt +
                ", dueDate=" + dueDate +
                ", value=" + value +
                '}';
    }
}