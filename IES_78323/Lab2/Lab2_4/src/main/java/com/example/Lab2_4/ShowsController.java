/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Lab2_4;

import java.util.ArrayList;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diogo
 */
@RestController
public class ShowsController {

        private final Database dummyBase = new Database();
        

	@GetMapping("/shows")
	public ArrayList greeting() {
            dummyBase.updateDatabase();
            
            return dummyBase.getMovies();
        }
}
