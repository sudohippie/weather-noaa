package me.chumbo.weather.service.soap;

import me.chumbo.weather.service.NOAAService;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.net.MalformedURLException;
import java.util.Map;

/**
 * Raghav Sidhanti
 * 9/11/13
 */
public class NOAASOAPService extends NOAAService {

    private static final String serviceEndpoint = "http://graphical.weather.gov/xml/SOAP_server/ndfdXMLserver.php";

    @Override
    protected String getData(String methodName, Map<String, String> params) {
        SOAPClient client = new SOAPClient(serviceEndpoint);
        try {
            SOAPMessage message = client.getDataAsSOAPMessage(methodName, params);
            return NOAASOAPUtil.getSOAPMessageContentAsString(message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        return null;
    }
}
