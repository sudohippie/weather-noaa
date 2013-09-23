package me.sudohippie.weather.method;

import me.sudohippie.weather.Executable;

import java.util.Map;

/**
 * A NOAA method need to be build and sent to a NOAA service, representing a query for
 * weather data.
 *
 * Concrete classes define the actual behaviour of the method.
 *
 * Raghav Sidhanti
 * 9/11/13
 */
public abstract class NOAAMethod implements Executable {
    protected final Map<String, String> arguments;

    public NOAAMethod() {
        arguments = getArgumentsTemplate();
    }

    /**
     * Checks whether the method instance was created
     * with the correct arguments as specified in NOAA service
     * documentation.
     *
     * @return
     */
    public abstract void assertMethodValidity();

    /**
     * Returns a String representation of the method name.
     *
     * @return
     */
    public String getMethodName(){
        return this.getClass().getSimpleName();
    }

    /**
     * Returns a collection of arguments associated to
     * this NOAA service method.
     *
     * @return
     */
    public Map<String, String> getArguments() {
        Map<String, String> clone = getArgumentsTemplate();
        clone.putAll(arguments);
        return clone;
    }

    /**
     * Adds an input argument for this method.
     *
     * @param name
     * @param value
     */
    public abstract void addArgument(String name, String value);

    /**
     * Returns a collection of arguments that are a part of this method.
     *
     * @return
     */
    protected abstract Map<String, String> getArgumentsTemplate();
}
