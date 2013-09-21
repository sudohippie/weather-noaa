package me.sudohippie.weather.method.soap;

import me.sudohippie.weather.method.NOAAMethod;
import me.sudohippie.weather.service.NOAAService;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class LatLonListZipCodeTest {
    public static void main(String[] args){
        // construct method
        NOAAMethod method = new LatLonListZipCode();
        method.addArgument("zipCodeList", "98007");

        // get data
        String data = NOAAService.getData(method);
        System.out.println(data);

    }
}
