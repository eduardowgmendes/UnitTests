package br.com.edu.unit_tests.rent.services;

import static br.com.edu.unit_tests.rent.utils.DateUtils.addDaysTo;

import java.util.Date;

import br.com.edu.unit_tests.rent.entity.Movie;
import br.com.edu.unit_tests.rent.entity.Rent;
import br.com.edu.unit_tests.rent.entity.User;

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