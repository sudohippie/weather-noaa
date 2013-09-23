package me.sudohippie.weather.method.soap;

import me.sudohippie.weather.NOAAWeather;
import me.sudohippie.weather.exception.NOAACommunicationException;
import me.sudohippie.weather.method.NOAAMethod;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class LatLonListZipCodeTest {
    public static void main(String[] args) throws NOAACommunicationException {
        // construct method
        NOAAMethod method = new LatLonListZipCode();
        method.addArgument("zipCodeList", "98007");

        // get data
        NOAAWeather weather = new NOAAWeather();
        String data = weather.query(method);
        System.out.println(data);

    }
}
