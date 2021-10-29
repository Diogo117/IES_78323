/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ipmaapiclient;

import com.mycompany.IpmaApiClient.IpmaCityForecast;
import com.mycompany.IpmaApiClient.IpmaService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Diogo
 */

public class WeatherStarterClass {
    
    
    private int CityCode;
    private String Temp;
    
    public void sendCityCode(int citycode) {
            this.CityCode = citycode;
            
             Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        
            IpmaService service = retrofit.create(IpmaService.class);
            Call<IpmaCityForecast> callSync = service.getForecastForACity(CityCode);
            
            try {
                Response<IpmaCityForecast> apiResponse = callSync.execute();
                IpmaCityForecast forecast = apiResponse.body();

                if (forecast != null) {
                     Temp = forecast.getData().listIterator().next().getTMax();
                } else {
                    Temp = "No results!";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }   
        }
    
    public String getTemperature() {
            return Temp;
        }
}
