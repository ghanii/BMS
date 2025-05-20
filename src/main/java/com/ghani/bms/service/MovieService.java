package com.ghani.bms.service;

import com.ghani.bms.exception.MovieNotFoundException;
import com.ghani.bms.model.Movie;
import com.ghani.bms.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(long id) {
        return movieRepository.findById(id).orElseThrow(()->new MovieNotFoundException("Movie not found for id : "+id));
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie updateMovie(long id, Movie movie) {
        Optional<Movie> movieRes = movieRepository.findById(id);
        movieRes.ifPresent(value -> value.setName(movie.getName()));
        return movieRepository.save(movieRes.get());
    }

    public void deleteMovie(long id) {
        movieRepository.deleteById(id);
    }
}
