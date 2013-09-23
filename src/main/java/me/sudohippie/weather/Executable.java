package me.sudohippie.weather;

import me.sudohippie.weather.exception.NOAACommunicationException;

/**
 * Any class implementing this interface can be executed to search for data
 * on a NOAA service.
 *
 * User: Raghav Sidhanti
 * Date: 9/22/13
 */
public interface Executable {

    /**
     * This method encapsulates logic related to executing a NOAA request
     * and returning data from the service.
     *
     * @return
     */
    public String executeAndReturnData() throws NOAACommunicationException;
}
