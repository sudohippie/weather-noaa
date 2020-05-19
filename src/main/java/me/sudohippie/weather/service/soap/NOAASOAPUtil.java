package me.sudohippie.weather.service.soap;

import java.io.ByteArrayOutputStream;
import java.util.Iterator;

import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

/**
 * Raghav Sidhanti
 * 9/12/13
 */
class NOAASOAPUtil {

    static String getRawSOAPMessageAsString(SOAPMessage message){
        if(message == null) return "";

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try {
            message.writeTo(bytes);
        } catch (Exception e) {
            return "";
        }

        return new String(bytes.toByteArray());
    }

    static String getSOAPMessageContentAsString(SOAPMessage message){
        if(message == null) return "";

        try {
            // getData soap part
            SOAPPart part = message.getSOAPPart();
            if(part == null) return "";

            // getData soap envelope
            SOAPEnvelope envelope = part.getEnvelope();
            if(envelope == null) return "";

            // getData soap body
            SOAPBody body = envelope.getBody();
            if(body == null) return "";

            // getData response
            StringBuilder text = new StringBuilder("");
            Iterator<Node> bodyChildElements = body.getChildElements();
            while (bodyChildElements.hasNext()) {
                final Node next = bodyChildElements.next();
                text.append(next.getTextContent());
            }

            return text.toString();

        } catch (SOAPException e) {
            return "";
        }
    }
}
