package br.com.edu.unit_tests.services;

import static br.com.edu.unit_tests.utils.DateUtils.addDaysTo;

import java.util.Date;

import br.com.edu.unit_tests.entity.Movie;
import br.com.edu.unit_tests.entity.Rent;
import br.com.edu.unit_tests.entity.User;

public class RentService {
	
	public Rent rentFor(User user, Movie movie) throws Exception {
		if(movie.getInventoryCount() == 0) {
			throw new Exception("Out of stock");
		}

		Rent rent = new Rent();
		rent.setMovie(movie);
		rent.setUser(user);
		rent.setCreatedAt(new Date());
		rent.setValue(movie.getPrice());
		
		Date dueDate = new Date();
		dueDate = addDaysTo(dueDate, 1);
		rent.setDueDate(dueDate);

		return rent;
	}

}