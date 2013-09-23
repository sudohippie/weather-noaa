package me.sudohippie.weather.method.soap;

import me.sudohippie.weather.NOAAWeather;
import me.sudohippie.weather.exception.NOAACommunicationException;
import me.sudohippie.weather.method.NOAAMethod;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class LatLonListCityNamesTest {
    public static void main(String[] args) throws NOAACommunicationException {
        NOAAMethod method = new LatLonListCityNames();
        method.addArgument("displayLevel", "1");

        NOAAWeather weather = new NOAAWeather();
        String data = weather.query(method);
        System.out.println(data );
    }
}
