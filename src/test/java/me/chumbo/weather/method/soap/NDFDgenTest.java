package me.chumbo.weather.method.soap;

import me.chumbo.weather.method.NOAAMethod;
import me.chumbo.weather.service.NOAAService;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class NDFDgenTest {
    public static void main(String[] args){
        // construct method
        NOAAMethod method = new NDFDgen();
        method.addArgument("latitude", "35.4");
        method.addArgument("longitude", "-97.6");
        method.addArgument("product", "time-series");
        method.addArgument("startTime", "2013-09-20T00:00");
        method.addArgument("endTime", "2013-09-20T12:00");
        method.addArgument("Unit", "e");
        method.addArgument("weatherParameters", "maxt=true");

        // get data
        String data = NOAAService.getData(method);
        System.out.println(data);
    }
}
