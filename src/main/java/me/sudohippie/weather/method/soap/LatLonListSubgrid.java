package me.sudohippie.weather.method.soap;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class LatLonListSubgrid extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"lowerLeftLatitude", "lowerLeftLongitude", "upperRightLatitude", "upperRightLongitude", "resolution"};
        return orderedArgNames;
    }
}
