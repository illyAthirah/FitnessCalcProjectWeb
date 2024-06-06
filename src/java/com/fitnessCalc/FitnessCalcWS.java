/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.fitnessCalc;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author adamm
 */
@WebService(serviceName = "FitnessCalcWS")
public class FitnessCalcWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "determineAge")
    public String determineAge(String idNumber) {
            String birthDateString = idNumber.substring(0, 6);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
            LocalDate birthDate = LocalDate.parse(birthDateString, formatter);
            return String.valueOf(Period.between(birthDate, LocalDate.now()).getYears());
        
    }
    
    @WebMethod(operationName = "displayInformation")
    public String displayInformation(String fullName, String icNum, String gender, double weight, double height) {
    return "Full Name: " + fullName + "\n" +
               "IC Number: " + icNum + "\n" +
               "Gender: " + gender + "\n" +
               "Weight: " + weight + " kg\n" +
               "Height: " + height + " cm";
    }
    
    @WebMethod(operationName = "determineBMI")
    public String determineBMI(double weight, double height) {
    return String.valueOf((weight / (height * height)) * 10000);
    }
}
