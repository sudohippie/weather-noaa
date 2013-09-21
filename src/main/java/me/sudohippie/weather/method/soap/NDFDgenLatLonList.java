package me.sudohippie.weather.method.soap;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class NDFDgenLatLonList extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"listLatLon", "product", "startTime", "endTime", "Unit", "weatherParameters"};
        return orderedArgNames;
    }
}
