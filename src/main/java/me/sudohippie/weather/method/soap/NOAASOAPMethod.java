package me.sudohippie.weather.method.soap;

import me.sudohippie.weather.exception.NOAACommunicationException;
import me.sudohippie.weather.method.NOAAMethod;
import me.sudohippie.weather.service.soap.NOAASOAPService;
import me.sudohippie.weather.util.Assert;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public abstract class NOAASOAPMethod extends NOAAMethod {

    private NOAASOAPService service = new NOAASOAPService();

   @Override
    public void assertMethodValidity() {
        String[] orderedArgumentNames = getOrderedArgumentNames();
        int index = 0;

        Iterator<String> keyIter = arguments.keySet().iterator();
        while(keyIter.hasNext()){
            String key = keyIter.next();

            // check values of map are not empty or null
            String value = arguments.get(key);
            Assert.notBlank(value, "Invalid method argument " + key +". Value can not be empty or null");

            // check order
            Assert.isTrue(orderedArgumentNames[index].equals(key), "Invalid method argument order. Arguments must be in order " + Arrays.toString(orderedArgumentNames));
            index ++;
        }
    }

    @Override
    protected Map<String, String> getArgumentsTemplate(){
        String[] argumentNames = getOrderedArgumentNames();
        Map<String, String> arguments;
        if(argumentNames != null && argumentNames.length > 0){
            arguments = new LinkedHashMap<String, String>(argumentNames.length);
            for(String name : argumentNames){
                arguments.put(name, "");
            }
        }else {
            arguments = new LinkedHashMap<String, String>(0);
        }
        return arguments;
    }

    @Override
    public void addArgument(String name, String value) {
        // check preconditions
        // name and value is not null or empty
        Assert.notBlank(name, "Invalid argument name. Name can not be empty or null");
        Assert.notBlank(value, "Invalid argument " + name + ". Value can not be empty or null");

        // name is valid for this method
        Assert.isTrue(arguments.containsKey(name), "Invalid argument " + name + " for this method");

        // if all okay, insert to map
        arguments.put(name, value);
    }

    @Override
    public String executeAndReturnData() throws NOAACommunicationException {
        return service.getData(this);
    }

    /**
     * This NOAA method has a default SOAP service assigned to it, this may be overridden via this setter method.
     * @param service
     */
    public void setService(NOAASOAPService service) {
        this.service = service;
    }

    /**
     * Returns the service to which this method will make a request to.
     *
     * @return
     */
    public NOAASOAPService getService() {
        return service;
    }

    /**
     * This method must return the an ordered list of arguments
     * necessary for the concrete method.
     *
     * Please not that the order of the inputs is very important.
     *
     * @return
     */
    abstract protected String[] getOrderedArgumentNames();
}
