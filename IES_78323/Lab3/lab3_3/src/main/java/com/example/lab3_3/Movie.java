/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.lab3_3;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



/**
 *
 * @author Diogo
 */
@Entity
@Table(name = "movie")
public class Movie {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<Quote> quotes = new HashSet<>();

    public Movie(String name) {
        this.name = name;
    }

    public Movie() {
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Quote> getQuotes() {
        return quotes;
    }

    public void setBooks(Set<Quote> quotes) {
        this.quotes = quotes;

        for(Quote b : quotes) {
            b.setMovie(this);
        }
    }
}
