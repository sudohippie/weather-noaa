package me.sudohippie.weather.service.soap;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Raghav Sidhanti
 * 9/12/13
 */
public class SOAPClientTest {
    public static void main(String[] args) throws IOException, SOAPException {
        String endpoint = "http://graphical.weather.gov/xml/SOAP_server/ndfdXMLserver.php";
        String methodName = "GmlTimeSeries";

        Map<String, String> params = new LinkedHashMap<String, String>();
        params.put("listLatLon", "38.99,-77.02 39.70,-104.80");
        params.put("startTime", "2004-01-01T00:00:00");
        params.put("endTime", "2017-09-12T00:00:00");
        params.put("compType", "Between");
        params.put("featureType", "Forecast_Gml2Point");
        params.put("propertyName", "maxt,mint,wx");

        SOAPClient client = new SOAPClient(endpoint);
        SOAPMessage message = client.getDataAsSOAPMessage(methodName, params);

        System.out.println(NOAASOAPUtil.getSOAPMessageContentAsString(message));
    }
}
