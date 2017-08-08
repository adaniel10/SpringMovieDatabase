package com.fdmgroup.springmoviedatabase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long movieId;
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 255)
	private String movieTitle;
	@Min(1900)
	private int releaseYear;
	@Min(0)
	@Max(10)
	private int rating;
	
	public Movie(){}
	
	public Movie(String movieTitle, int releaseYear, int rating) {
		this.movieTitle = movieTitle;
		this.releaseYear = releaseYear;
		this.rating = rating;
	}

	public long getMovieId() {
		return movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public int getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", releaseYear=" + releaseYear + ", rating="
				+ rating + "]";
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
