package me.sudohippie.weather.service;

import me.sudohippie.weather.method.NOAAMethod;
import me.sudohippie.weather.service.rest.NOAARESTService;
import me.sudohippie.weather.service.soap.NOAASOAPService;

import java.util.Map;

/**
 * Raghav Sidhanti
 * 9/11/13
 */
public abstract class NOAAService {

    /**
     * Using the information with in the NOAAMethod,
     * this class will make a call to the appropriate NOAA
     * service and return a String representation of the data.
     *
     * @param method
     * @return
     */
    public static String getData(NOAAMethod method){
        // validate method
        method.assertMethodValidity();

        // make a call and get xml content
        NOAAService service = newInstance(method.getServiceType());
        String textResponse = service.getData(method.getMethodName(), method.getArguments());

        if(textResponse != null) return textResponse;
        else return "";
    }

    /**
     * Retrieves data the appropriate NOAA service as represented by the concrete class.
     *
     * @param methodName
     * @param params
     * @return
     */
    protected abstract String getData(String methodName, Map<String, String> params);

    private static NOAAService newInstance(NOAAServiceType type){
        switch (type){
            case REST:
                return new NOAARESTService();
            case SOAP:
                return new NOAASOAPService();
            default:
                return null;
        }
    }
}
