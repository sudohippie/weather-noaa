package me.chumbo.weather.method.soap;

import me.chumbo.weather.method.NOAAMethod;
import me.chumbo.weather.service.NOAAService;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class LatLonListCityNamesTest {
    public static void main(String[] args){
        NOAAMethod method = new LatLonListCityNames();
        method.addArgument("displayLevel", "1");

        String data = NOAAService.getData(method);
        System.out.println(data );
    }
}
