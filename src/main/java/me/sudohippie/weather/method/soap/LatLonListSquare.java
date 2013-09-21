package me.sudohippie.weather.method.soap;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class LatLonListSquare extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"centerPointLat", "centerPointLon", "distanceLat", "distanceLon", "resolution"};
        return orderedArgNames;
    }
}
