package com.fdmgroup.springmoviedatabase.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.springmoviedatabase.model.Movie;
import com.fdmgroup.springmoviedatabase.service.MovieService;

@Controller
@RequestMapping("/Movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	public MovieController(){}
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping(params = "create")
	public String createMovie(Model model){
		
		model.addAttribute("movie", new Movie());
		return "create";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveMovie(@ModelAttribute("movie") @Valid Movie movie, 
			BindingResult result, Model model){
		
		model.addAttribute("movie", movie);
		if(result.hasErrors()){
			return "create";
		} else{
			movieService.create(movie);
			return "viewMovie";	
		}
	}
	
}
