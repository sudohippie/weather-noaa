package me.chumbo.weather.method.rest;

import me.chumbo.weather.method.NOAAMethod;
import me.chumbo.weather.service.NOAAService;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class GenericRESTMethodTest {
    public static void testNDFDGen(){
        NOAAMethod method = new GenericRESTMethod();
        method.addArgument("lat", "47.6201");
        method.addArgument("lon", "-122.141");
        method.addArgument("product", "time-series");
        method.addArgument("begin", "2013-09-19T10:00");
        method.addArgument("end", "2013-09-20T10:00");
        method.addArgument("Unit", "e");
        method.addArgument("maxt", "maxt");

        String data = NOAAService.getData(method);
        System.out.println(data);
    }

    public static void main(String[] args){
        testNDFDGen();
    }
}
