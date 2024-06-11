/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fitnessClient;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author adamm
 */
public class DetermineBodyFat extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/FitnessCalcProjectWeb/FitnessCalcWS.wsdl")
    private FitnessCalcWS_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String gender = request.getParameter("gender");
            double bmi = Double.parseDouble(request.getParameter("bmi"));
            int age = Integer.parseInt(request.getParameter("age"));
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Servlet BodyFat</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #F8EDE3; color: #333; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
            out.println(".container { max-width: 600px; margin: 50px auto; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); background-color: #DFD3C3; }");
            out.println(".maksud { text-align= justify; max-width: 850px; margin: 80px auto; line-height:1.4; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); background-color: #D0B8A8; }");
            out.println("h2 { color: #102C57; font-style: italic; font-weight: bold;}");
            out.println("h1 { font-family: Optima; color: #102C57;font-weight: bold;}");
            out.println("button { background-color: #85586F; color: white; border: none; padding: 10px 20px; font-size: 1em; cursor: pointer; border-radius: 5px; }");
            out.println("button:hover { background-color: #85586F; }");
            //out.println(".div1 { font-family: Arial, sans-serif; font-weight: bold; margin-top: 0px}");
            out.println("p { font-size: 1.1em; }");
            out.println("a { color: #0073e6; text-decoration: none; }");
            out.println("a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
            
            out.println("<img src=\"https://www.nutrilove.co.in/wp-content/uploads/2020/05/body-fat-percentage-min-3-1024x852.png\" alt=\"Description of Image\" style=\"max-width: 37%; margin-top:60px; text-align=center; height: auto;\">");
            out.println("<div class=\"div1\">");
            out.println("<h1>DETERMINE BODY FAT </h1>");
            //maksud body fat
            
            out.println("<div class=\"maksud\">");
            out.println("<h3>What is Body Fat? </h3>");
            out.println("Body fat refers to the adipose tissue in the body, which is a specialized connective tissue");
            out.println("composed mostly of fat cells called adipocytes. It serves several important functions,");
            out.println("including energy storage, insulation, and cushioning of vital organs. Body fat is essential for ");
            out.println("maintaining proper bodily functions, but excessive amounts can lead to health problems such as obesity, ");
            out.println(" heart disease, and diabetes. The percentage of body weight that is composed of fat is often");
            out.println("used as a measure of overall health and fitness.");
            
            
            out.println("<div class=\"container\">");
            out.println("<h2>Your body fat is " + bodyFat(bmi, age, gender) + "%</h2>");
            out.println("<p>For more information about the formula, visit the <a href=\"https://www.tgfitness.com/body-fat-percentage-calculator/\" target=\"_blank\">website</a>.</p>");
            out.println("<button class=\"btn btn-primary\" onclick=\"goBack()\">Go Back</button>");
            out.println("</div>");
            out.println("</div>");
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String bodyFat(double arg0, int arg1, java.lang.String arg2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.fitnessClient.FitnessCalcWS port = service.getFitnessCalcWSPort();
        return port.bodyFat(arg0, arg1, arg2);
    }

}
