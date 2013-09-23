package me.sudohippie.weather;

import me.sudohippie.weather.exception.NOAACommunicationException;

/**
 * This class represents the main entry point in to the NOAA system.
 *
 * Any weather queries, will be executed by this class
 *
 * User: Raghav Sidhanti
 * Date: 9/22/13
 */
public class NOAAWeather {

    /**
     * Given an executable with relevant search information, this
     * method will search the NOAA weather system and return data
     * as a String.
     *
     * @param executable A executable object which contains the request and NOAA service configuration.
     * @return String representation of NOAA's data for the specified request.
     * @exception NOAACommunicationException is thrown when there was a problem while connecting to
     *              the NOAA service.
     */
    public String query(Executable executable) throws NOAACommunicationException {
        return executable.executeAndReturnData();
    }
}
