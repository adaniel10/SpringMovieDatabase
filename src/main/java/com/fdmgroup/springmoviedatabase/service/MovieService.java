package com.fdmgroup.springmoviedatabase.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.springmoviedatabase.model.Movie;
import com.fdmgroup.springmoviedatabase.model.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public Movie create(Movie movie){
		return movieRepository.saveAndFlush(movie);
	}

	public Movie retrieveOne(long id){
		return movieRepository.findOne(id);
	}
	
	public List<Movie> retrieveAll(){
		return movieRepository.findAll();
	}
	
	public Movie update(long id, Movie movie){
		Movie managedMovie = movieRepository.findOne(id);
		BeanUtils.copyProperties(movie, managedMovie);
		return movieRepository.saveAndFlush(movie);
	}
	
	public void delete(long id){
		movieRepository.delete(id);
	}
	
}
