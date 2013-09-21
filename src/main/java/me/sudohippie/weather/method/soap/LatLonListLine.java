package me.sudohippie.weather.method.soap;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class LatLonListLine extends NOAASOAPMethod{
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"endPoint1Lat", "endPoint1Lon", "endPoint2Lat", "endPoint2Lon"};
        return orderedArgNames;
    }
}
