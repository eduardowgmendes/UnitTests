package br.com.edu.unit_tests.rent.entity;

import java.util.Objects;

public class Movie {

	private String name;
	private Integer inventoryCount;
	private Double price;
	
	public Movie() {}
	
	public Movie(String name, Integer inventoryCount, Double price) {
		this.name = name;
		this.inventoryCount = inventoryCount;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getInventoryCount() {
		return inventoryCount;
	}
	public void setInventoryCount(Integer inventoryCount) {
		this.inventoryCount = inventoryCount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) && Objects.equals(inventoryCount, movie.inventoryCount) && Objects.equals(price, movie.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inventoryCount, price);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", inventoryCount=" + inventoryCount +
                ", price=" + price +
                '}';
    }
}