/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.lab3_3;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Diogo
 */
public interface MovieRepository extends JpaRepository<Movie, Integer>{
    
}
