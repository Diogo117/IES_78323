/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Lab2_4;

import java.util.ArrayList;

/**
 *
 * @author Diogo
 */
public class Movie {
        private final long id;
	private final String name;
        private final ArrayList quotes;
    
        public Movie(long id, String name) {
                this.quotes = new ArrayList();
		this.id = id;
		this.name = name;
	}
        
        public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
        
        public ArrayList getQuotes() {
		return quotes;
	}
        
        public void addQuote(String quote){
            this.quotes.add(quote);
        }
        
         public String getQuote(int i){
            if(this.quotes.get(i)==null){
                return "error";
            }else{
                return (String) this.quotes.get(i);
            }
            
        }
}
