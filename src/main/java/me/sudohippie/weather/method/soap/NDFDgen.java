package me.sudohippie.weather.method.soap;

/**
 * Raghav Sidhanti
 * 9/12/13
 */
public class NDFDgen extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"latitude", "longitude", "product", "startTime", "endTime", "Unit", "weatherParameters"};
        return orderedArgNames;
    }
}
