/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Lab2_4;


import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diogo
 */
@RestController
public class QuoteController {

	private String quote = "Quote:";
        private final Database dummyBase = new Database();
        

	@GetMapping("/quote")
	public TextJson greeting() {
            dummyBase.updateDatabase();
            Random r = new Random();
            int randomMovie =  r.nextInt((dummyBase.getMovies().size()));
            Movie pick = dummyBase.getMovie(randomMovie);
            int randomquote =  r.nextInt((pick.getQuotes().size()));
            this.quote = pick.getQuote(randomquote);
            
            return new TextJson(randomMovie,pick.getName(),this.quote);
	}
}
