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
import javax.xml.ws.WebServiceException;


/**
 *
 * @author adamm
 */
@WebService(serviceName = "FitnessCalcWS")
public class FitnessCalcWS {

    /**
     * This is a sample web service operation
     */
    
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
        double bmi = (weight / (height * height)) * 10000;
        return String.format("%.2f", bmi);
    }
    
     public String bodyFat(double bmi, int age, String gender) {
      double bodyFatPercentage;
      if (gender.equals("Male"))
          bodyFatPercentage = (1.20 * bmi) + (0.23 * age) - 16.2;
      else
          bodyFatPercentage = (1.20 * bmi) + (0.23 * age) - 5.4;
      return String.format("%.2f", bodyFatPercentage);
  }
     
     public String calorieBurnRate(int duration, double met, double weight) {
      double burnRate = (duration*met*weight)/200;
      return String.format("%.2f", burnRate);
  }
     
     public String dailyCalorieNeed(double weight, double height, int age, String gender) {
      double caloryNeed;
      
      if (gender.equals("Male"))
          caloryNeed = (13.397 * weight) + (4.799 * height) - (5.677 * age) + 88.362;
      else
          caloryNeed = (9.247 * weight) + (3.098 * height) - (4.330 * age) + 447.593;
      return String.format("%.2f", caloryNeed);
  }
}
