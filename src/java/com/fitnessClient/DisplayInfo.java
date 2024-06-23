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

public class DisplayInfo extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/FitnessCalcProjectWeb/FitnessCalcWS.wsdl")
    private FitnessCalcWS_Service service;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
            String fullName = request.getParameter("fullName");
            String icNum = request.getParameter("icNum");
            String gender = request.getParameter("gender");
            
            if (fullName == null || fullName.isEmpty() ||
            icNum == null || icNum.isEmpty() ||
            gender == null || gender.isEmpty() ||
            request.getParameter("weight") == null || request.getParameter("weight").isEmpty() ||
            request.getParameter("height") == null || request.getParameter("height").isEmpty()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Error: Missing Information</title>");
            out.println("<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #F8EDE3; color: #333; }");
            out.println(".container { max-width: 600px; margin: 50px auto; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); background-color: #D0B8A8; }");
            out.println("h1 { font-family: Optima; color: #102C57;font-weight: bold; text-align: center; margin-top: 50px;}");
            out.println("h4 { color: black; text-align: center; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container text-center\">");
            out.println("<h1>Error: Missing Information</h1>");
            out.println("<h4>Please fill out all fields to proceed.</h4>");            
            out.println("<div style=\"display: flex; justify-content: center; align-items: center;\">");
            out.println("<button type=\"button\" class=\"btn btn-curved\" onclick=\"window.location.href='index.html'\" style=\"color: white; background-color:#85586F; width: 150px; height: 50px;\"> Exit </button>");
            out.println("</div>");

                
            out.println("<script>");
            out.println("function goBack() {");
            out.println("window.history.back();");
            out.println("}");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
            double weight = Double.parseDouble(request.getParameter("weight"));
            double height = Double.parseDouble(request.getParameter("height"));
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Display Info</title>");
            out.println("<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #F8EDE3; color: #333; }");
            out.println(".container { max-width: 600px; margin: 50px auto; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); background-color: #D0B8A8; }");
            out.println("h1 { font-family: Optima; color: #102C57;font-weight: bold; text-align: center; margin-top: 50px;}");
            out.println("h4 { color: black; text-align: center; }");
            out.println("h5 { color: black; margin-top:50px; margin-bottom:10px; font-family:Copperplate; text-align: center; }");
            out.println(".details { margin-top: 10px; }");
            out.println(".details { max-width: 600px; margin: 20px auto; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); background-color: #DFD3C3; }");
            out.println(".details-box{1px solid #ccc; padding: 10px; width:350px; margin:0 auto;}");
            out.println(".btn-curved { border-radius: 20px; }");
            out.println("</style>");
            out.println("</head>");
            
            out.println("<body>\n\n");
            out.println("<div class=\"div1\">");
            out.println("<h1>MY INFORMATION </h1>");
            out.println("<div class=\"container text-center\">"); // Added 'text-center' class
            out.println("<h4>Hello, " + fullName + "!</h4>");
            out.println("<div class=\"details-box mx-auto\">"); // Added 'details-box' class for styling
            out.println("<h5>YOUR DETAILS : </h5>");
            out.println("<div class=\"details\">"); // Added 'details' class for styling
            String age = determineAge(icNum);
            if (age.startsWith("Error")) {
                out.println("<p><b>Age: </b> Age information unavailable</p>");
            } else {
                out.println("<p><b>Age: </b>" + age + " Y/O</p>");
            }

            out.println("<p><b>Height: </b>" + height + " CM</p>");
            out.println("<p><b>Weight:</b> " + weight + " KG</p>");
            out.println("<p><b>Gender:</b> " + gender + "</p>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"btn-group\">");
            out.println("<button type=\"button\" class=\"btn btn-curved\" onclick=\"submitBMIForm()\" style=\"margin-left: 10px; margin-right: 10px; margin-top:10px; color: white; background-color:#85586F;\">Calculate BMI</button>");
            out.println("<button type=\"button\" class=\"btn btn-curved\" onclick=\"submitBodyFatForm()\" style=\"margin-right: 10px; margin-top:10px; color: white; background-color:#85586F;\">Calculate Body Fat</button>");
            out.println("<button type=\"button\" class=\"btn btn-curved\" data-toggle=\"modal\" data-target=\"#calorieModal\" style=\"margin-right: 10px; margin-top:10px; color: white; background-color:#85586F;\">Calculate Calorie Burn Rate</button>");
            out.println("<button type=\"button\" class=\"btn btn-curved\" onclick=\"submitDailyNeedForm()\" style=\"margin-right: 10px; color: white; margin-top:10px; background-color:#85586F; \">Calculate Daily Calorie Need</button>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div style=\"display: flex; justify-content: center; align-items: center;\">");
            out.println("<button type=\"button\" class=\"btn btn-curved\" onclick=\"window.location.href='index.html'\" style=\"color: white; background-color:#85586F; width: 150px; height: 50px;\"> Exit </button>");
            out.println("</div>");
            
            out.println("<form id=\"bmiForm\" action=\"CalcBMI\" method=\"post\" style=\"display:none;\">");
            out.println("<input type=\"hidden\" name=\"height\" value=\"" + height + "\" />");
            out.println("<input type=\"hidden\" name=\"weight\" value=\"" + weight + "\" />");
            out.println("</form>");

            out.println("<form id=\"bodyFatForm\" action=\"DetermineBodyFat\" method=\"post\" style=\"display:none;\">");
            out.println("<input type=\"hidden\" name=\"bmi\" value=\"" + determineBMI(weight, height) + "\" />");
            out.println("<input type=\"hidden\" name=\"age\" value=\"" + determineAge(icNum) + "\" />");
            out.println("<input type=\"hidden\" name=\"gender\" value=\"" + gender + "\" />");
            out.println("</form>");

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
            out.println("<label for=\"duration\">Enter the duration (minutes):</label>");
            out.println("<input type=\"number\" class=\"form-control\" id=\"duration\" name=\"duration\" value=\"\" min=\"1\" required/>");
            out.println("</div>");
            out.println("<div class=\"form-group\">");
            out.println("<label for=\"met\">Enter your activity:</label>");
            out.println("<select class=\"form-control\" id=\"met\" name=\"met\">");
            out.println("<option value=\"1.8\">Writing, desk work, typing</option>");
            out.println("<option value=\"2.3\">Walking, (2.7 km/h), level ground, strolling, very slow</option>");
            out.println("<option value=\"2.9\">Walking, (4 km/h)</option>");
            out.println("<option value=\"3.0\">Bicycling, stationary, 50 W, very light effort</option>");
            out.println("<option value=\"3.3\">Walking, (4.8 km/h)</option>");
            out.println("<option value=\"3.5\">Calisthenics, home exercise, light or moderate effort, general</option>");
            out.println("<option value=\"3.6\">Walking, (5.5 km/h)</option>");
            out.println("<option value=\"4.0\">Bicycling, (<16 km/h), leisure, to work or for pleasure</option>");
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
            out.println("<button type=\"submit\" class=\"btn btn-curved\" style=\"background-color:#85586F; color: white\"; >Submit</button>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");


            out.println("<form id=\"dailyNeedForm\" action=\"DetermineCalorieNeed\" method=\"post\" style=\"display:none;\">");
            out.println("<input type=\"hidden\" name=\"age\" value=\"" + determineAge(icNum) + "\" />");
            out.println("<input type=\"hidden\" name=\"height\" value=\"" + height + "\" />");
            out.println("<input type=\"hidden\" name=\"weight\" value=\"" + weight + "\" />");
            out.println("<input type=\"hidden\" name=\"gender\" value=\"" + gender + "\" />");
            out.println("</form>");

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

    private String determineAge(String ic) {
    try {
        com.fitnessClient.FitnessCalcWS port = service.getFitnessCalcWSPort();
        return port.determineAge(ic);
    } catch (Exception ex) {
        // Log the exception for troubleshooting
        ex.printStackTrace();  // Use appropriate logging framework in a real application
        return "Error: Unable to determine age";  // Return a default message or handle as needed
    }
}
    private String determineBMI(double arg0, double arg1) {
        try
        {
        com.fitnessClient.FitnessCalcWS port = service.getFitnessCalcWSPort();
        return port.determineBMI(arg0, arg1);
        } catch (Exception ex) {
        // Log the exception for troubleshooting
        ex.printStackTrace();  // Use appropriate logging framework in a real application
        return "Error: Unable to calculate BMI";  // Return a default message or handle as needed
        }
    }

}
