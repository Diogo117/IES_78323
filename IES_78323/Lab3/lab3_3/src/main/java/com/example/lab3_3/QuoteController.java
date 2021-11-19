/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.lab3_3;

/**
 *
 * @author Diogo
 */
import static java.lang.Integer.parseInt;
import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
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
public class QuoteController {

        
        private final MovieRepository movieRepository;
        private final QuoteRepository quoteRepository;
        
        @Autowired
        public QuoteController(QuoteRepository quoteRepository, MovieRepository movieRepository) {
            this.quoteRepository = quoteRepository;
            this.movieRepository = movieRepository;
        }

        @PostMapping("quote")
        public ResponseEntity<Quote> create(@RequestBody @Valid QuoteCatcher quoteCatcher) {
            Optional<Movie> optionalLibrary = movieRepository.findById(quoteCatcher.getMovie_id());
            if (!optionalLibrary.isPresent()) {
                return ResponseEntity.unprocessableEntity().build();
            }
            Quote quote = new Quote();
            quote.setQuote(quoteCatcher.getQuote());
            quote.setMovie(optionalLibrary.get());

            Quote savedBook = quoteRepository.save(quote);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("quote")
                .buildAndExpand(savedBook.getId()).toUri();

            return ResponseEntity.created(location).body(savedBook);
        }

        @PutMapping("quote/{id}")
        public ResponseEntity<Quote> update(@RequestBody @Valid Quote book, @PathVariable Integer id) {
            Optional<Movie> optionalLibrary = movieRepository.findById(book.getMovie().getId());
            if (!optionalLibrary.isPresent()) {
                return ResponseEntity.unprocessableEntity().build();
            }

            Optional<Quote> optionalBook = quoteRepository.findById(id);
            if (!optionalBook.isPresent()) {
                return ResponseEntity.unprocessableEntity().build();
            }

            book.setMovie(optionalLibrary.get());
            book.setId(optionalBook.get().getId());
            quoteRepository.save(book);

            return ResponseEntity.noContent().build();
        }

        @DeleteMapping("quote/{id}")
        public ResponseEntity<Quote> delete(@PathVariable Integer id) {
            Optional<Quote> optionalBook = quoteRepository.findById(id);
            if (!optionalBook.isPresent()) {
                return ResponseEntity.unprocessableEntity().build();
            }

            quoteRepository.delete(optionalBook.get());

            return ResponseEntity.noContent().build();
        }

        @GetMapping("quotesAll")
        public ResponseEntity<Page<Quote>> getAll(Pageable pageable) {
            return ResponseEntity.ok(quoteRepository.findAll(pageable));
        }

        @GetMapping("quote")
        public ResponseEntity<Quote> getRandom() {
            Random r = new Random();
            int count=0;
            int size = (int) quoteRepository.count();
 
            while(count<=10){ //count<=10 is a safeguard to prevent infinite loops
                int randomquote =  r.nextInt(size+1);
                Optional<Quote> optionalQuote = quoteRepository.findById(randomquote);
                if (optionalQuote.isPresent()) {
                    return ResponseEntity.ok(optionalQuote.get());
                }
                count++;
            }
            return ResponseEntity.unprocessableEntity().build();
        }
        
         @GetMapping("/quotes")
        public ResponseEntity<Movie> getById(@RequestParam Integer show) {
            Optional<Movie> optionalLibrary = movieRepository.findById(show);
            if (!optionalLibrary.isPresent()) {
                return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalLibrary.get());
    }
        
        
         @GetMapping("addQuote")
         public ResponseEntity<Quote> delete(@RequestParam Map<String,String> requestParams) {
             
            int movie_id=parseInt(requestParams.get("movie_id"));
            Optional<Movie> optionalLibrary = movieRepository.findById(movie_id);
            if (!optionalLibrary.isPresent()) {
                return ResponseEntity.unprocessableEntity().build();
            }
            Quote quote = new Quote();
            quote.setQuote(requestParams.get("quote"));
            quote.setMovie(optionalLibrary.get());

            Quote savedBook = quoteRepository.save(quote);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("quote")
                .buildAndExpand(savedBook.getId()).toUri();

            return ResponseEntity.created(location).body(savedBook);
        }
        
}
