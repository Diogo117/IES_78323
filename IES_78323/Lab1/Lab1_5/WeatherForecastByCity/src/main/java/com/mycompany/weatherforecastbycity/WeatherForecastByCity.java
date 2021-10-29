/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weatherforecastbycity;

import java.util.Scanner;
import com.mycompany.IpmaApiClient.CityForecast;

/**
 *
 * @author Diogo
 */
public class WeatherForecastByCity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner myObj = new Scanner(System.in);  
        System.out.println("Enter city Code");

        int cityCode = Integer.parseInt(myObj.nextLine());  
        
        CityForecast newSystem = new CityForecast();
        
        String temp = newSystem.getTemp(cityCode);
        
        System.out.print("max temp for today: " + temp);  
        
    }
    
}
