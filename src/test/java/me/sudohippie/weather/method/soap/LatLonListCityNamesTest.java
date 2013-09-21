package me.sudohippie.weather.method.soap;

import me.sudohippie.weather.method.NOAAMethod;
import me.sudohippie.weather.service.NOAAService;

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
