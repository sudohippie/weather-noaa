package me.sudohippie.weather.exception;

/**
 * A generic exception which should be thrown when there is an issue communicating with
 * a NOAA service.
 *
 * Raghav Sidhanti
 * 9/23/13
 */
public class NOAACommunicationException extends Exception {
    public NOAACommunicationException(String s){
        super(s);
    }

    public NOAACommunicationException(Exception e){
        super(e);
    }

    public NOAACommunicationException(String s, Exception e) {
        super(s, e);
    }
}
