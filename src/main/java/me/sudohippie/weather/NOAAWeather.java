package me.sudohippie.weather;

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
     * @param executable
     * @return
     */
    public String query(Executable executable){
        return executable.executeAndReturnData();
    }
}
