package me.sudohippie.weather.service.rest;

import me.sudohippie.weather.exception.NOAACommunicationException;
import me.sudohippie.weather.service.NOAAService;

import java.io.IOException;
import java.util.Map;

/**
 * Raghav Sidhanti
 * 9/11/13
 */
public class NOAARESTService extends NOAAService {

    private String serviceEndpoint = "http://graphical.weather.gov/xml/sample_products/browser_interface/ndfdXMLclient.php";

    @Override
    protected String getData(String methodName, Map<String, String> args) throws NOAACommunicationException {
        RESTClient client = new RESTClient(serviceEndpoint);
        try {
            String response = client.getDataAsString(args);
            return response;
        } catch (IOException e) {
            throw new NOAACommunicationException("Unable to communicate with NOAA REST service at "+serviceEndpoint+
                    ". Embedded exception has more details", e);
        }
    }

    public String getServiceEndpoint() {
        return serviceEndpoint;
    }

    public void setServiceEndpoint(String serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
    }
}
