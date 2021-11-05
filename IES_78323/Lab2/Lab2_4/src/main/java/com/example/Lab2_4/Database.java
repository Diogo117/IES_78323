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
public class Database {
     private final ArrayList movies;
    
        public Database() {
            this.movies = new ArrayList();
		
	}
        
        public void updateDatabase(){
            
            Movie james = new Movie(this.movies.size(),"James Bond");
            james.addQuote("Die another day");
            james.addQuote("Hello");

            this.movies.add(james);

            Movie avat = new Movie(this.movies.size(), "Avatar");
            avat.addQuote("Goodbye");
            avat.addQuote("Tree");
            avat.addQuote("Sky");

            this.movies.add(avat);

            Movie termi = new Movie(this.movies.size(), "Terminator");
            termi.addQuote("I will be back!");
            this.movies.add(termi);     
        }
        
        public ArrayList getMovies(){
            return this.movies;
        }
        
        public Movie getMovie(int i){
            if(this.movies.get(i)==null){
                return new Movie(404,"error");
            }else{
                return (Movie) this.movies.get(i);
            }
            
        }
}
