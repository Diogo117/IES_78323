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
public class QuoteCatcher {
    private String quote;
    private int movie_id;

    public QuoteCatcher(String quote, int movie_id) {
        this.quote = quote;
        this.movie_id = movie_id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }
    
    
}
