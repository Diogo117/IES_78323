package com.example.Lab2_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab24Application {

	public static void main(String[] args) {
                
              Database teste = new Database();
              teste.updateDatabase();
              var movies = teste.getMovies();
                
		SpringApplication.run(Lab24Application.class, args);
	}

}
