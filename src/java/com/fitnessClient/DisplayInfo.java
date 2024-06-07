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
public class DisplayInfo extends HttpServlet {

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
            String fullName = request.getParameter("fullName");
            String icNum = request.getParameter("icNum");
            String gender = request.getParameter("gender");
            double weight = Double.parseDouble(request.getParameter("weight"));
            double height = Double.parseDouble(request.getParameter("height"));
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Servlet DisplayInfo</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f0f8ff; color: #333; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
            out.println(".container { text-align: center; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.println("h1 { color: #0073e6; }");
            out.println("p { font-size: 1.1em; }");
            out.println("a { color: #0073e6; text-decoration: none; }");
            out.println("a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("<!-- Bootstrap CSS -->");
            out.println("<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h1>Welcome! " + displayInformation(fullName, icNum, gender, weight, height) + "</h1>");
            out.println("<h1>Your are currently " + determineAge(icNum) + "</h1>");

            // Buttons to trigger modals
            out.println("<button type=\"button\" class=\"btn btn-primary\" onclick=\"submitBMIForm()\">Calculate BMI</button>");
            out.println("<button type=\"button\" class=\"btn btn-primary\" onclick=\"submitBodyFatForm()\">Calculate Body Fat</button>");
            out.println("<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#calorieModal\">Calculate Calorie Burn Rate</button>");
            out.println("<button type=\"button\" class=\"btn btn-primary\" onclick=\"submitDailyNeedForm()\">Calculate Daily Calorie Need</button>");


            // Hidden form for BMI calculation
            out.println("<form id=\"bmiForm\" action=\"CalcBMI\" method=\"post\" style=\"display:none;\">");
            out.println("<input type=\"hidden\" name=\"height\" value=\"" + height + "\" />");
            out.println("<input type=\"hidden\" name=\"weight\" value=\"" + weight + "\" />");
            out.println("</form>");


            // Hidden form for Body Fat calculation
            out.println("<form id=\"bodyFatForm\" action=\"DetermineBodyFat\" method=\"post\" style=\"display:none;\">");
            out.println("<input type=\"hidden\" name=\"bmi\" value=\"" + determineBMI(weight, height) + "\" />");
            out.println("<input type=\"hidden\" name=\"age\" value=\"" + determineAge(icNum) + "\" />");
            out.println("<input type=\"hidden\" name=\"gender\" value=\"" + gender + "\" />");
            out.println("</form>");

            // Calorie Form Modal
            out.println("<div class=\"modal fade\" id=\"calorieModal\" tabindex=\"-1\" aria-labelledby=\"calorieModalLabel\" aria-hidden=\"true\">");
            out.println("<div class=\"modal-dialog\">");
            out.println("<div class=\"modal-content\">");
            out.println("<div class=\"modal-header\">");
            out.println("<h5 class=\"modal-title\" id=\"calorieModalLabel\">Calorie Form</h5>");
            out.println("<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">");
            out.println("<span aria-hidden=\"true\">&times;</span>");
            out.println("</button>");
            out.println("</div>");
            out.println("<div class=\"modal-body\">");
            out.println("<form id=\"calorieForm\" action=\"DetermineBurnRate\">");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"duration\">Enter the duration:</label>");
            out.println("<input type=\"text\" class=\"form-control\" id=\"duration\" name=\"duration\" value=\"\" />");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"met\">Enter your activity:</label>");
            out.println("<select class=\"form-control\" id=\"met\" name=\"met\">");
            out.println("<option value=\"0.9\">Sleeping</option>");
            out.println("<option value=\"1.0\">Watching television</option>");
            out.println("<option value=\"1.8\">Writing, desk work, typing</option>");
            out.println("<option value=\"2.3\">Walking, 1.7 mph (2.7 km/h), level ground, strolling, very slow</option>");
            out.println("<option value=\"2.9\">Walking, 2.5 mph (4 km/h)</option>");
            out.println("<option value=\"3.0\">Bicycling, stationary, 50 W, very light effort</option>");
            out.println("<option value=\"3.3\">Walking, 3.0 mph (4.8 km/h)</option>");
            out.println("<option value=\"3.5\">Calisthenics, home exercise, light or moderate effort, general</option>");
            out.println("<option value=\"3.6\">Walking, 3.4 mph (5.5 km/h)</option>");
            out.println("<option value=\"4.0\">Bicycling, less than 10 mph (16 km/h), leisure, to work or for pleasure</option>");
            out.println("<option value=\"5.5\">Bicycling, stationary, 100 W, light effort</option>");
            out.println("<option value=\"7.0\">Jogging, general</option>");
            out.println("<option value=\"8.0\">Calisthenics (e.g., push-ups, sit-ups, pull-ups, jumping jacks), heavy, vigorous effort</option>");
            out.println("<option value=\"8.0\">Running jogging, in place</option>");
            out.println("<option value=\"10.0\">Rope jumping</option>");
            out.println("</select>");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<input type=\"hidden\" class=\"form-control\" id=\"weight\" name=\"weight\" value=\"" + weight + "\" />");
            out.println("</div>");
            out.println("<button type=\"submit\" class=\"btn btn-primary\">Submit</button>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

            // Button to trigger the Daily Calorie Need calculation
            // Hidden form for Daily Calorie Need calculation
            out.println("<form id=\"dailyNeedForm\" action=\"DetermineCalorieNeed\" method=\"post\" style=\"display:none;\">");
            out.println("<input type=\"hidden\" name=\"age\" value=\"" + determineAge(icNum) + "\" />");
            out.println("<input type=\"hidden\" name=\"height\" value=\"" + height + "\" />");
            out.println("<input type=\"hidden\" name=\"weight\" value=\"" + weight + "\" />");
            out.println("<input type=\"hidden\" name=\"gender\" value=\"" + gender + "\" />");
            out.println("</form>");

            // JavaScript to submit the hidden form
            out.println("<script>");
            out.println("function submitBMIForm() {");
            out.println("    document.getElementById('bmiForm').submit();");
            out.println("}");
            out.println("function submitBodyFatForm() { document.getElementById('bodyFatForm').submit(); }");
            out.println("function submitDailyNeedForm() { document.getElementById('dailyNeedForm').submit(); }");

            out.println("</script>");

            out.println("</div>");
            out.println("<!-- Bootstrap JS and dependencies -->");
            out.println("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
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

    private String displayInformation(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, double arg3, double arg4) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.fitnessClient.FitnessCalcWS port = service.getFitnessCalcWSPort();
        return port.displayInformation(arg0, arg1, arg2, arg3, arg4);
    }
    
    private String determineAge(String ic) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.fitnessClient.FitnessCalcWS port = service.getFitnessCalcWSPort();
        return port.determineAge(ic);
    }
    
    private String determineBMI(double arg0, double arg1) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.fitnessClient.FitnessCalcWS port = service.getFitnessCalcWSPort();
        return port.determineBMI(arg0, arg1);
    }

}
