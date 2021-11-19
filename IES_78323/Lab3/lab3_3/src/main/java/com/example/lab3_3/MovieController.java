/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.lab3_3;

import java.net.URI;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




/**
 *
 * @author Diogo
 */
@RestController
public class MovieController {

        
        private final MovieRepository movieRepository;
        private final QuoteRepository quoteRepository;
        
        @Autowired
        public MovieController(MovieRepository movieRepository, QuoteRepository quoteRepository) {
            this.movieRepository = movieRepository;
            this.quoteRepository = quoteRepository;
        }
        
        @GetMapping("/shows/{id}")
        public ResponseEntity<Movie> getById(@PathVariable Integer id) {
            Optional<Movie> optionalLibrary = movieRepository.findById(id);
            if (!optionalLibrary.isPresent()) {
                return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalLibrary.get());
    }
        
    
        @GetMapping("shows")
        public ResponseEntity<Page<Movie>> getAll(Pageable pageable) {
            return ResponseEntity.ok(movieRepository.findAll(pageable));
        }

        
        
        @PostMapping("shows")
        public ResponseEntity<Movie> create(@Valid @RequestBody Movie movie) {
            Movie savedLibrary = movieRepository.save(movie);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("shows")
                .buildAndExpand(savedLibrary.getId()).toUri();

            return ResponseEntity.created(location).body(savedLibrary);
        }

        @PutMapping("shows/{id}")
        public ResponseEntity<Movie> update(@PathVariable Integer id, @Valid @RequestBody Movie movie) {
            Optional<Movie> optionalLibrary = movieRepository.findById(id);
            if (!optionalLibrary.isPresent()) {
                return ResponseEntity.unprocessableEntity().build();
            }

            movie.setId(optionalLibrary.get().getId());
            movieRepository.save(movie);

            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("shows/{id}")
        public ResponseEntity<Movie> delete(@PathVariable Integer id) {
            Optional<Movie> optionalMovie = movieRepository.findById(id);
            if (!optionalMovie.isPresent()) {
                return ResponseEntity.unprocessableEntity().build();
            }

            movieRepository.delete(optionalMovie.get());

            return ResponseEntity.noContent().build();
        }
        
        @GetMapping("addShow")
        public ResponseEntity<Movie> addMovie (@RequestParam String name) {
            Movie movie = new Movie();
            movie.setName(name);
            Movie savedLibrary = movieRepository.save(movie);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("shows")
                .buildAndExpand(savedLibrary.getId()).toUri();

            return ResponseEntity.created(location).body(savedLibrary);
        }
}
