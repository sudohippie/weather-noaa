package me.sudohippie.weather.method.soap;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class NDFDgenByDay extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"latitude", "longitude", "startDate", "numDays", "Unit", "format"};
        return orderedArgNames;
    }
}
