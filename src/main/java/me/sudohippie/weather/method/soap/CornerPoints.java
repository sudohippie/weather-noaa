package me.sudohippie.weather.method.soap;

/**
 * Raghav Sidhanti
 * 9/20/13
 */
public class CornerPoints extends NOAASOAPMethod {
    @Override
    protected String[] getOrderedArgumentNames() {
        final String[] orderedArgNames = {"sector"};
        return orderedArgNames;
    }
}
