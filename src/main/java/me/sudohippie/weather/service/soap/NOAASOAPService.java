package me.sudohippie.weather.service.soap;

import me.sudohippie.weather.exception.NOAACommunicationException;
import me.sudohippie.weather.service.NOAAService;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.net.MalformedURLException;
import java.util.Map;

/**
 * Raghav Sidhanti
 * 9/11/13
 */
public class NOAASOAPService extends NOAAService {

    private String serviceEndpoint = "http://graphical.weather.gov/xml/SOAP_server/ndfdXMLserver.php";

    @Override
    protected String getData(String methodName, Map<String, String> params) throws NOAACommunicationException {
        SOAPClient client = new SOAPClient(serviceEndpoint);
        try {
            SOAPMessage message = client.getDataAsSOAPMessage(methodName, params);
            return NOAASOAPUtil.getSOAPMessageContentAsString(message);
        } catch (MalformedURLException e) {
            throw new NOAACommunicationException("Invalid protocol for endpoint: "+serviceEndpoint, e);
        } catch (SOAPException e) {
            throw new NOAACommunicationException("Unable to make SOAP request to "+serviceEndpoint+
                    ". Embedded exception has more details.", e);
        }
    }

    public String getServiceEndpoint() {
        return serviceEndpoint;
    }

    public void setServiceEndpoint(String serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
    }
}
