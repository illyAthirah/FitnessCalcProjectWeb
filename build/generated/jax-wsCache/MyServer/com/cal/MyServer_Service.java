
package com.cal;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * Eclipse Metro/2.4.8 (RELEASE-2.4.8-e044505; 2022-01-04T13:29:23+0000) JAXWS-RI/2.3.5 JAXWS-API/2.3.3 JAXB-RI/2.3.5 JAXB-API/2.3.3
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MyServer", targetNamespace = "http://basicCalc.com/", wsdlLocation = "http://localhost:8080/BasicCalc/MyServer?wsdl")
public class MyServer_Service
    extends Service
{

    private final static URL MYSERVER_WSDL_LOCATION;
    private final static WebServiceException MYSERVER_EXCEPTION;
    private final static QName MYSERVER_QNAME = new QName("http://basicCalc.com/", "MyServer");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/BasicCalc/MyServer?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MYSERVER_WSDL_LOCATION = url;
        MYSERVER_EXCEPTION = e;
    }

    public MyServer_Service() {
        super(__getWsdlLocation(), MYSERVER_QNAME);
    }

    public MyServer_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), MYSERVER_QNAME, features);
    }

    public MyServer_Service(URL wsdlLocation) {
        super(wsdlLocation, MYSERVER_QNAME);
    }

    public MyServer_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MYSERVER_QNAME, features);
    }

    public MyServer_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MyServer_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MyServer
     */
    @WebEndpoint(name = "MyServerPort")
    public MyServer getMyServerPort() {
        return super.getPort(new QName("http://basicCalc.com/", "MyServerPort"), MyServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MyServer
     */
    @WebEndpoint(name = "MyServerPort")
    public MyServer getMyServerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://basicCalc.com/", "MyServerPort"), MyServer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MYSERVER_EXCEPTION!= null) {
            throw MYSERVER_EXCEPTION;
        }
        return MYSERVER_WSDL_LOCATION;
    }

}
