package me.sudohippie.weather.service.rest;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class RESTClientTest {
    public static void main(String[] args) throws IOException {
        String endpoint = "http://graphical.weather.gov/xml/sample_products/browser_interface/ndfdXMLclient.php";
        RESTClient client = new RESTClient(endpoint);

        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("listLatLon", "38.99,-77.02 39.70,-104.80");
        params.put("startTime", "2004-01-01T00:00:00");
        params.put("endTime", "2017-09-12T00:00:00");
        params.put("compType", "Between");
        params.put("featureType", "Forecast_Gml2Point");
        params.put("propertyName", "maxt,mint,wx");

        String dataAsString = client.getDataAsString(params);

        System.out.println(dataAsString);
    }
}
