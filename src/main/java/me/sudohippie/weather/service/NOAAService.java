package me.sudohippie.weather.service;

import me.sudohippie.weather.method.NOAAMethod;

import java.util.Map;

/**
 * This class represents querying services provided by NOAA.
 *
 * The actual implementation of a particular service is defined by
 * a concrete class.
 *
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
    public String getData(NOAAMethod method){
        // validate method
        method.assertMethodValidity();

        // make a call and get xml content
        String textResponse = getData(method.getMethodName(), method.getArguments());

        if(textResponse != null) return textResponse;
        else return "";
    }

    /**
     * Retrieves data from the appropriate NOAA service as represented by the concrete class.
     *
     * @param methodName
     * @param params
     * @return
     */
    protected abstract String getData(String methodName, Map<String, String> params);
}
