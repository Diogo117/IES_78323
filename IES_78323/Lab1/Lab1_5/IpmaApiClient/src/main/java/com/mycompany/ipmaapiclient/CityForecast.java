/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.IpmaApiClient;

/**
 *
 * @author Diogo
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * the data point with the forecast for a city in a day
 */
public class CityForecast {

    @SerializedName("precipitaProb")
    @Expose
    private String precipitaProb;
    @SerializedName("tMin")
    @Expose
    private String tMin;
    @SerializedName("tMax")
    @Expose
    private String tMax;
    @SerializedName("predWindDir")
    @Expose
    private String predWindDir;
    @SerializedName("idWeatherType")
    @Expose
    private Integer idWeatherType;
    @SerializedName("classWindSpeed")
    @Expose
    private Integer classWindSpeed;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("forecastDate")
    @Expose
    private String forecastDate;
    @SerializedName("latitude")
    @Expose
    private String latitude;
   

    

    public String getPrecipitaProb() {
        return precipitaProb;
    }

    public void setPrecipitaProb(String precipitaProb) {
        this.precipitaProb = precipitaProb;
    }

    public String getTMin() {
        return tMin;
    }

    public void setTMin(String tMin) {
        this.tMin = tMin;
    }

    public String getTMax() {
        return tMax;
    }

    public void setTMax(String tMax) {
        this.tMax = tMax;
    }

    public String getPredWindDir() {
        return predWindDir;
    }

    public void setPredWindDir(String predWindDir) {
        this.predWindDir = predWindDir;
    }

    public Integer getIdWeatherType() {
        return idWeatherType;
    }

    public void setIdWeatherType(Integer idWeatherType) {
        this.idWeatherType = idWeatherType;
    }

    public Integer getClassWindSpeed() {
        return classWindSpeed;
    }

    public void setClassWindSpeed(Integer classWindSpeed) {
        this.classWindSpeed = classWindSpeed;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(String forecastDate) {
        this.forecastDate = forecastDate;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    //Criei esta função porque esava a ter problema em detetar a class WeatherStarterClass na aplicação final.
    
    
    public String getTemp(int code){
        
        String Temp="";
         
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        
            IpmaService service = retrofit.create(IpmaService.class);
            Call<IpmaCityForecast> callSync = service.getForecastForACity(code);
            
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
       return Temp;
    }
}