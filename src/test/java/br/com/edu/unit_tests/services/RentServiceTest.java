package br.com.edu.unit_tests.services;


import static br.com.edu.unit_tests.builders.UserBuilder.oneUser;
import static br.com.edu.unit_tests.matchers.MineMatchers.*;
import static br.com.edu.unit_tests.utils.DateUtils.areSame;
import static br.com.edu.unit_tests.utils.DateUtils.todayPlus;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.*;

import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.com.edu.unit_tests.entity.Movie;
import br.com.edu.unit_tests.entity.Rent;
import br.com.edu.unit_tests.entity.User;

public class RentServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private RentService service;

    @Before
    public void setup() {
        service = new RentService();
    }

    @Test
    public void shouldRentMovieSuccessfully() throws Exception {
        //scenario
        service = new RentService();
        User user = new User("User 1");
        Movie movie = new Movie("Movie 1", 1, 5.0);

        //act
        Rent rent = service.rentFor(user, movie);

        //validation
        error.checkThat(rent.getValue(), is(equalTo(5.0)));
        error.checkThat(areSame(rent.getCreatedAt(), new Date()), is(true));
        error.checkThat(areSame(rent.getDueDate(), todayPlus(1)), is(true));
    }

    @Test(expected = Exception.class)
    public void shouldRaiseExceptionWhenMovieIsOutOfStock() throws Exception {
        //scenario
        service = new RentService();
        User user = new User("User 1");
        Movie movie = new Movie("Movie 2", 0, 4.0);

        //act
        service.rentFor(user, movie);
    }

    @Test
    public void shouldRaiseExceptionWhenMovieIsOutOfStock2() {
        //scenario
        service = new RentService();
        User user = oneUser().now();
        Movie movie = new Movie("Movie 2", 0, 4.0);

        //act
        try {
            service.rentFor(user, movie);
            Assert.fail("This code should have exploded, but it stayed calm.");
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Out of stock"));
        }
    }


    @Test
    public void shouldRaiseExceptionWhenMovieIsOutOfStock3() throws Exception {
        //scenario
        service = new RentService();
        User user = oneUser().withName("User 1").now();
        Movie movie = new Movie("Movie 2", 0, 4.0);

        exception.expect(Exception.class);
        exception.expectMessage("Out of stock");

        //act
        service.rentFor(user, movie);
    }

    @Test
    public void shouldReturnMovieOnMondayWhenRentOnSaturdays() throws Exception {
        //scenario
        User user = oneUser().withName("User 1").now();
        Movie movie = new Movie("Movie 1", 1, 14.99);

        //act
        Rent rent = service.rentFor(user, movie);

        //validation
        assertThat(rent.getDueDate(), occursOnMonday());
    }

}
