package me.sudohippie.weather.method.soap;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class GmlLatLonList extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"listLatLon", "requestedTime", "featureType", "weatherParameters"};
        return orderedArgNames;
    }
}
