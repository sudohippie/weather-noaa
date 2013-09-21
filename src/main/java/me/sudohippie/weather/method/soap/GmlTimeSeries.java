package me.sudohippie.weather.method.soap;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class GmlTimeSeries extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"listLatLon", "startTime", "endTime", "compType", "featureType", "propertyName"};
        return orderedArgNames;
    }
}
