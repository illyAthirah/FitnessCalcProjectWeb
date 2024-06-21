/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fitnessCalc;

import javax.xml.ws.WebFault;
/**
 *
 * @author User
 */

@WebFault(name = "FaultMessage")
public class FaultMessage extends Exception {
     private static final long serialVersionUID = 1L;

    public FaultMessage(String message) {
        super(message);
    }

    public FaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public String getFaultInfo() {
        return "Details about the fault: " + getMessage();
    }
}
