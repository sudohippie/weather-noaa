package me.sudohippie.weather.method.rest;

import me.sudohippie.weather.exception.NOAACommunicationException;
import me.sudohippie.weather.method.NOAAMethod;
import me.sudohippie.weather.service.rest.NOAARESTService;
import me.sudohippie.weather.util.Assert;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public abstract class NOAARESTMethod extends NOAAMethod {

    private NOAARESTService service = new NOAARESTService();

    @Override
    public void assertMethodValidity() {
        Iterator<String> keyIter = arguments.keySet().iterator();
        while(keyIter.hasNext()){
            String key = keyIter.next();

            // check values of map are not empty or null
            String value = arguments.get(key);
            Assert.notBlank(value, "Invalid method argument " + key +". Value can not be empty or null");
        }
    }

    @Override
    public void addArgument(String name, String value) {
        // check preconditions
        // name and value is not null or empty
        Assert.notBlank(name, "Invalid argument name. Name can not be empty or null");
        Assert.notBlank(value, "Invalid argument " + name + ". Value can not be empty or null");

        // if all okay, insert to map
        arguments.put(name, value);
    }

    @Override
    protected Map<String, String> getArgumentsTemplate() {
        return new TreeMap<String, String>();
    }

    @Override
    public String executeAndReturnData() throws NOAACommunicationException {
        return service.getData(this);
    }

    /**
     * This NOAA method has a default REST service assigned to it, this may be overridden via this setter method.
     * @param service
     */
    public void setService(NOAARESTService service) {
        this.service = service;
    }

    /**
     * Returns the service to which this method will make a request to.
     *
     * @return
     */
    public NOAARESTService getService() {
        return service;
    }
}
