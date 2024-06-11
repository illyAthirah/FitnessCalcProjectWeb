package com.fitnessClient;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

public class CalcBMI extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/FitnessCalcProjectWeb/FitnessCalcWS.wsdl")
    private FitnessCalcWS_Service service;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            double weight = Double.parseDouble(request.getParameter("weight"));
            double height = Double.parseDouble(request.getParameter("height"));
            String bmiResult = determineBMI(weight, height);
            double bmi = Double.parseDouble(bmiResult);
            String bmiStatus = getBMIStatus(bmi);
            
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Servlet CalcBMI</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #F8EDE3; color: #333; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
            out.println(".container { text-align: center; background: #D0B8A8; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.println("h1 { color: #102C57; }");
            out.println("h2 { color: #102C57; }");
            out.println("h3 { color: #102C57; }");
            out.println("button { background-color: #85586F; color: white; border: none; padding: 10px 20px; font-size: 1em; cursor: pointer; border-radius: 5px; }");
            
            out.println("p { font-size: 1.1em; }");
            out.println("a { color: #0073e6; text-decoration: none; }");
            out.println("a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<img src=\"https://lirp.cdn-website.com/69c0b277/dms3rep/multi/opt/BMI+levels-640w.jpg\" alt=\"Description of Image\" style=\"max-width: 80%; height: auto;\">");
            out.println("<h1><b> Result :</b></h1>");
            out.println("<h2>Your BMI is <b>" + bmiResult + "</b></h2>");
            out.println("<h3>Your BMI Status is " + bmiStatus + "</h3>");
            out.println("<p>For more information about the BMI formula, visit the <a href=\"https://www.cdc.gov/nccdphp/dnpao/growthcharts/training/bmiage/page5_1.html\" target=\"_blank\">website</a>.</p>");
            out.println("<button class=\"btn btn-primary\" onclick=\"goBack()\">Go Back</button>");
            out.println("</div>");
            out.println("<script>");
            out.println("function goBack() {");
            out.println("window.history.back();");
            out.println("}");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private String determineBMI(double weight, double height) {
        com.fitnessClient.FitnessCalcWS port = service.getFitnessCalcWSPort();
        return port.determineBMI(weight, height);
    }

    private String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
