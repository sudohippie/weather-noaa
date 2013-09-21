package me.chumbo.weather.service.rest;

import me.chumbo.weather.service.NOAAService;

import java.io.IOException;
import java.util.Map;

/**
 * Raghav Sidhanti
 * 9/11/13
 */
public class NOAARESTService extends NOAAService {

    private static final String serviceEndpoint = "http://graphical.weather.gov/xml/sample_products/browser_interface/ndfdXMLclient.php";

    @Override
    protected String getData(String methodName, Map<String, String> args) {
        RESTClient client = new RESTClient(serviceEndpoint);
        try {
            String response = client.getDataAsString(args);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
