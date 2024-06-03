
package com.fitnessClient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fitnessClient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DetermineAge_QNAME = new QName("http://fitnessCalc.com/", "determineAge");
    private final static QName _DetermineAgeResponse_QNAME = new QName("http://fitnessCalc.com/", "determineAgeResponse");
    private final static QName _Hello_QNAME = new QName("http://fitnessCalc.com/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://fitnessCalc.com/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fitnessClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DetermineAge }
     * 
     */
    public DetermineAge createDetermineAge() {
        return new DetermineAge();
    }

    /**
     * Create an instance of {@link DetermineAgeResponse }
     * 
     */
    public DetermineAgeResponse createDetermineAgeResponse() {
        return new DetermineAgeResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetermineAge }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DetermineAge }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "determineAge")
    public JAXBElement<DetermineAge> createDetermineAge(DetermineAge value) {
        return new JAXBElement<DetermineAge>(_DetermineAge_QNAME, DetermineAge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetermineAgeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DetermineAgeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "determineAgeResponse")
    public JAXBElement<DetermineAgeResponse> createDetermineAgeResponse(DetermineAgeResponse value) {
        return new JAXBElement<DetermineAgeResponse>(_DetermineAgeResponse_QNAME, DetermineAgeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
