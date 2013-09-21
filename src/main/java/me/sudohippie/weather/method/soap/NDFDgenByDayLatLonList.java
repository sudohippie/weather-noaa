package me.sudohippie.weather.method.soap;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class NDFDgenByDayLatLonList extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"listLatLon", "startDate", "numDays", "Unit", "format"};
        return orderedArgNames;
    }
}
