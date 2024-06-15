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
public class DetermineBurnRate extends HttpServlet {

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
            int duration = Integer.parseInt(request.getParameter("duration"));
            double met = Double.parseDouble(request.getParameter("met"));
            double weight = Double.parseDouble(request.getParameter("weight"));
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Servlet DisplayInfo</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #F8EDE3; color: #333; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
            out.println(".container { text-align: center; background: #DFD3C3; margin-top:30px; padding: 10px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.println("h1 { font-family: Optima; color: #102C57;font-weight: bold; text-align: center;}");
            out.println("p { font-size: 1.1em; }");
            out.println("button { background-color: #85586F; color: white; border: none; padding: 10px 20px; font-size: 1em; cursor: pointer; border-radius: 5px; }");
            out.println("button:hover { background-color: #85586F; }");
            out.println(".maksud { text-align= justify; max-width: 800px; margin: 50px auto; line-height:1.4;padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); background-color: #D0B8A8; }");
            out.println("a { color: #0073e6; text-decoration: none; }");
            out.println("a:hover { text-decoration: underline; }");
            out.println("table { width: 50%; margin: 20px auto; border-collapse: collapse; }");
            out.println("table, th, td { border: 1px solid #333; }");
            out.println("th, td { padding: 10px; text-align: center; }");
            out.println("th { background-color: #DFD3C3; }");
            out.println("</style>");
            out.println("</head>");
            
            out.println("<body>");
            //out.println("<img src=\"https://i.pinimg.com/736x/75/d5/ed/75d5ed307f40703641cb9506fe691173.jpg\" alt=\"Description of Image\" style=\"max-width:37%; margin-top:40px; height: auto;\">"); 
            out.println("<div class=\"div1\">");
            out.println("<h1>DETERMINE CALORIES BURN RATE </h1>");
            
            //maksud body fat
            out.println("<div class=\"maksud\">");
            out.println("<h3>What is Calories Burn Rate? </h3>");
            out.println("The calorie burn rate refers to the number of calories a person expends during a given period of physical activity. This rate varies based on several factors, including the individual's weight, age, sex, metabolic rate, and the intensity and duration of the activity performed. Understanding one's calorie burn rate is crucial for managing weight, as it helps to balance calorie intake with calorie expenditure. Activities such as running, swimming, and cycling typically have higher calorie burn rates compared to less intense activities like walking or yoga.");
            
            out.println("<div class=\"container\">");
            out.println("<h1><b>Your calorie burn rate is </b>" + calorieBurnRate(duration, met, weight) + "%</h1>");

            // Add table
            out.println("<table>");
            out.println("<tr><th>Factor</th><th>Value</th></tr>");
            out.println("<tr><td>Duration</td><td>" + duration + " minutes</td></tr>");
            out.println("<tr><td>Metabolic Equivalent of Task</td><td>" + met + "</td></tr>");
            out.println("<tr><td>Weight</td><td>" + weight + " kg</td></tr>");
            out.println("</table>");
            out.println("<p>Formula derived from <a href=\"https://www.healthline.com/health/what-are-mets\" target=\"_blank\">HealthLine</a>.</p>");
            out.println("<p>MET values gathered from <a href=\"https://www.researchgate.net/figure/2-MET-values-for-physical-activity-levels_tbl2_294283835\" target=\"_blank\">ResearchGate</a>.</p>");
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
     * @param response servlet response)
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

    private String calorieBurnRate(int arg0, double arg1, double arg2) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.fitnessClient.FitnessCalcWS port = service.getFitnessCalcWSPort();
        return port.calorieBurnRate(arg0, arg1, arg2);
    }

}
