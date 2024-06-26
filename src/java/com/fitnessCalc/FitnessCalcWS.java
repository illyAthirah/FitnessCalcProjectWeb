/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.fitnessCalc;

import javax.jws.WebService;
import javax.jws.WebMethod;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    public String determineAge(String icNumber) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        Date birthDate = dateFormat.parse(icNumber.substring(0, 6));

        Calendar birthCalendar = Calendar.getInstance();
        birthCalendar.setTime(birthDate);

        Calendar currentCalendar = Calendar.getInstance();

        int age = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);

        if (currentCalendar.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return String.valueOf(age);
    }
    
    @WebMethod(operationName = "displayInformation")
    public String displayInformation(String fullName, String icNum, String gender, double weight, double height) throws FaultMessage {
        if (fullName == null || fullName.isEmpty()) {
            throw new FaultMessage("Full Name cannot empty");
        }
        
        if (icNum == null || icNum.isEmpty()) {
            throw new FaultMessage("IC Number cannot empty");
        }
        
        if (gender == null || gender.isEmpty()) {
            throw new FaultMessage("Gender cannot empty");
        }
        
        if (weight <= 0) {
            throw new FaultMessage("Weight must be greater than zero");
        }
        
        if (height <= 0) {
            throw new FaultMessage("Height must be greater than zero");
        }
        
    return "<br />Full Name: " + fullName + "<br />" +
               "IC Number: " + icNum + "<br />" +
               "Gender: " + gender + "<br />" +
               "Weight: " + weight + " kg<br />" +
               "Height: " + height + " cm";
    }
    
    @WebMethod(operationName = "determineBMI")
    public String determineBMI(double weight, double height) throws FaultMessage {
        if (weight <= 0 || height <= 0) {
            throw new FaultMessage("Weight and Height must be greater than zero");
        }
        double bmi = (weight / (height * height)) * 10000;
        return String.format("%.2f", bmi);
    }
    
     public String bodyFat(double bmi, int age, String gender)throws FaultMessage {
      if (bmi <= 0 || age <= 0) {
            throw new FaultMessage("BMI and Age must be greater than zero");
        }
         double bodyFatPercentage;
      if (gender.equals("Male"))
          bodyFatPercentage = (1.20 * bmi) + (0.23 * age) - 16.2;
      else
          bodyFatPercentage = (1.20 * bmi) + (0.23 * age) - 5.4;
      return String.format("%.2f", bodyFatPercentage);
  }
     
     public String calorieBurnRate(int duration, double met, double weight) throws FaultMessage{
          if (duration <= 0 || met <= 0 || weight <= 0) {
            throw new FaultMessage ("Duration, MET, and Weight must be greater than zero");
        }
         double burnRate = (duration*met*weight)/200;
      return String.format("%.2f", burnRate);
  }
     
     public String dailyCalorieNeed(double weight, double height, int age, String gender) throws FaultMessage {
      if (weight <= 0 || height <= 0 || age <= 0) {
            throw new FaultMessage("Weight, Height, and Age must be greater than zero");
        }
         double caloryNeed;
      
      if (gender.equals("Male"))
          caloryNeed = (13.397 * weight) + (4.799 * height) - (5.677 * age) + 88.362;
      else
          caloryNeed = (9.247 * weight) + (3.098 * height) - (4.330 * age) + 447.593;
      return String.format("%.2f", caloryNeed);
  }
}
