
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

    private final static QName _BodyFat_QNAME = new QName("http://fitnessCalc.com/", "bodyFat");
    private final static QName _BodyFatResponse_QNAME = new QName("http://fitnessCalc.com/", "bodyFatResponse");
    private final static QName _CalorieBurnRate_QNAME = new QName("http://fitnessCalc.com/", "calorieBurnRate");
    private final static QName _CalorieBurnRateResponse_QNAME = new QName("http://fitnessCalc.com/", "calorieBurnRateResponse");
    private final static QName _DailyCalorieNeed_QNAME = new QName("http://fitnessCalc.com/", "dailyCalorieNeed");
    private final static QName _DailyCalorieNeedResponse_QNAME = new QName("http://fitnessCalc.com/", "dailyCalorieNeedResponse");
    private final static QName _DetermineAge_QNAME = new QName("http://fitnessCalc.com/", "determineAge");
    private final static QName _DetermineAgeResponse_QNAME = new QName("http://fitnessCalc.com/", "determineAgeResponse");
    private final static QName _DetermineBMI_QNAME = new QName("http://fitnessCalc.com/", "determineBMI");
    private final static QName _DetermineBMIResponse_QNAME = new QName("http://fitnessCalc.com/", "determineBMIResponse");
    private final static QName _DisplayInformation_QNAME = new QName("http://fitnessCalc.com/", "displayInformation");
    private final static QName _DisplayInformationResponse_QNAME = new QName("http://fitnessCalc.com/", "displayInformationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fitnessClient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BodyFat }
     * 
     */
    public BodyFat createBodyFat() {
        return new BodyFat();
    }

    /**
     * Create an instance of {@link BodyFatResponse }
     * 
     */
    public BodyFatResponse createBodyFatResponse() {
        return new BodyFatResponse();
    }

    /**
     * Create an instance of {@link CalorieBurnRate }
     * 
     */
    public CalorieBurnRate createCalorieBurnRate() {
        return new CalorieBurnRate();
    }

    /**
     * Create an instance of {@link CalorieBurnRateResponse }
     * 
     */
    public CalorieBurnRateResponse createCalorieBurnRateResponse() {
        return new CalorieBurnRateResponse();
    }

    /**
     * Create an instance of {@link DailyCalorieNeed }
     * 
     */
    public DailyCalorieNeed createDailyCalorieNeed() {
        return new DailyCalorieNeed();
    }

    /**
     * Create an instance of {@link DailyCalorieNeedResponse }
     * 
     */
    public DailyCalorieNeedResponse createDailyCalorieNeedResponse() {
        return new DailyCalorieNeedResponse();
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
     * Create an instance of {@link DetermineBMI }
     * 
     */
    public DetermineBMI createDetermineBMI() {
        return new DetermineBMI();
    }

    /**
     * Create an instance of {@link DetermineBMIResponse }
     * 
     */
    public DetermineBMIResponse createDetermineBMIResponse() {
        return new DetermineBMIResponse();
    }

    /**
     * Create an instance of {@link DisplayInformation }
     * 
     */
    public DisplayInformation createDisplayInformation() {
        return new DisplayInformation();
    }

    /**
     * Create an instance of {@link DisplayInformationResponse }
     * 
     */
    public DisplayInformationResponse createDisplayInformationResponse() {
        return new DisplayInformationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BodyFat }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BodyFat }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "bodyFat")
    public JAXBElement<BodyFat> createBodyFat(BodyFat value) {
        return new JAXBElement<BodyFat>(_BodyFat_QNAME, BodyFat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BodyFatResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BodyFatResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "bodyFatResponse")
    public JAXBElement<BodyFatResponse> createBodyFatResponse(BodyFatResponse value) {
        return new JAXBElement<BodyFatResponse>(_BodyFatResponse_QNAME, BodyFatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalorieBurnRate }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalorieBurnRate }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "calorieBurnRate")
    public JAXBElement<CalorieBurnRate> createCalorieBurnRate(CalorieBurnRate value) {
        return new JAXBElement<CalorieBurnRate>(_CalorieBurnRate_QNAME, CalorieBurnRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalorieBurnRateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CalorieBurnRateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "calorieBurnRateResponse")
    public JAXBElement<CalorieBurnRateResponse> createCalorieBurnRateResponse(CalorieBurnRateResponse value) {
        return new JAXBElement<CalorieBurnRateResponse>(_CalorieBurnRateResponse_QNAME, CalorieBurnRateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DailyCalorieNeed }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DailyCalorieNeed }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "dailyCalorieNeed")
    public JAXBElement<DailyCalorieNeed> createDailyCalorieNeed(DailyCalorieNeed value) {
        return new JAXBElement<DailyCalorieNeed>(_DailyCalorieNeed_QNAME, DailyCalorieNeed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DailyCalorieNeedResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DailyCalorieNeedResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "dailyCalorieNeedResponse")
    public JAXBElement<DailyCalorieNeedResponse> createDailyCalorieNeedResponse(DailyCalorieNeedResponse value) {
        return new JAXBElement<DailyCalorieNeedResponse>(_DailyCalorieNeedResponse_QNAME, DailyCalorieNeedResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DetermineBMI }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DetermineBMI }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "determineBMI")
    public JAXBElement<DetermineBMI> createDetermineBMI(DetermineBMI value) {
        return new JAXBElement<DetermineBMI>(_DetermineBMI_QNAME, DetermineBMI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetermineBMIResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DetermineBMIResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "determineBMIResponse")
    public JAXBElement<DetermineBMIResponse> createDetermineBMIResponse(DetermineBMIResponse value) {
        return new JAXBElement<DetermineBMIResponse>(_DetermineBMIResponse_QNAME, DetermineBMIResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayInformation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DisplayInformation }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "displayInformation")
    public JAXBElement<DisplayInformation> createDisplayInformation(DisplayInformation value) {
        return new JAXBElement<DisplayInformation>(_DisplayInformation_QNAME, DisplayInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayInformationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DisplayInformationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fitnessCalc.com/", name = "displayInformationResponse")
    public JAXBElement<DisplayInformationResponse> createDisplayInformationResponse(DisplayInformationResponse value) {
        return new JAXBElement<DisplayInformationResponse>(_DisplayInformationResponse_QNAME, DisplayInformationResponse.class, null, value);
    }

}
