/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Lab2_4;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diogo
 */
@RestController
public class SearchShow {
    
        private String quote = "Quote:";
        private final Database dummyBase = new Database();
        

	@GetMapping("/quotes")
	public TextJson greeting(@RequestParam(value = "show", defaultValue = "0") String show_id) {
            dummyBase.updateDatabase();
            Random r = new Random();
            Movie pick = dummyBase.getMovie(parseInt(show_id));
            int randomquote =  r.nextInt((pick.getQuotes().size()));
            this.quote = pick.getQuote(randomquote);
            
            return new TextJson(parseInt(show_id),pick.getName(),this.quote);
            
	}
}
