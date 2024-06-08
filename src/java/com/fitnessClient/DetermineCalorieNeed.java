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
public class DetermineCalorieNeed extends HttpServlet {

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
            double weight = Double.parseDouble(request.getParameter("weight"));
            double height = Double.parseDouble(request.getParameter("height"));
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");            
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Servlet DisplayInfo</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #FEFAF6; color: #333; margin-left:0px; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh; }");
            out.println(".container { text-align: center; background: #fff; padding: 5px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
            out.println("h1 { font-family: Optima; color: #102C57;font-weight: bold; text-align: center;}");
            //out.println(".gmbr { max-width: 850px; margin: 120px auto; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); background-color: #EADBC8; }");
            out.println("p { font-size: 1.1em; }");
            out.println("button { background-color: #102C57; color: white; border: none; padding: 10px 20px; font-size: 1em; cursor: pointer; border-radius: 5px; }");
            out.println("button:hover { background-color: #102C57; }");
            out.println("a { color: #0073e6; text-decoration: none; }");
            out.println("a:hover { text-decoration: underline; }");
            out.println("table { width: 50%; margin: 20px auto; border-collapse: collapse; }");
            out.println("table, th, td { border: 1px solid #333; }");
            out.println("th, td { padding: 10px;  }");
            out.println("th { background-color: #DFD3C3; }");
            out.println("</style>");
            out.println("</head>");
            
            out.println("<body>");
            //out.println("<img src=\"https://d2jx2rerrg6sh3.cloudfront.net/image-handler/picture/2019/1/By_photka.jpg\" alt=\"Description of Image\" style=\"max-width: 30%; margin-left:50px; border-right:0 height: auto; position: center;\">");
           
            out.println("<div class=\"gmbr\">");
            out.println("<h1>DETERMINE CALORIES NEED</h1>");
            out.println("<div class=\"container\">");
            out.println("<h1>Your daily calorie need is " + dailyCalorieNeed(weight, height, age, gender) + "KCal</h1>");
            out.println("<p>Here are some suggestions if you're eating fewer or over calories than recommended :- </p>");
           
            out.println("<table>");
            out.println("<tr><th>Factor</th><th>Action</th></tr>");
            out.println("<tr><td>Less Calories Intake Per Day:</td><td>1. Choose foods that are high in nutrients but low in empty calories. Examples include vegetables, fruits, lean proteins, and whole grains. </td></tr>");
            out.println("<tr><td></td><td>2. Eat regular meals and snacks to keep your energy levels stable throughout the day.</td></tr>");
            out.println("<tr><td></td><td>3. Make sure your diet includes a variety of foods to provide all the essential nutrients. Focus on lean proteins, whole grains, fruits, vegetables, and healthy fats. </td></tr>");
            out.println("<tr><td>Over Calories Intake Per Day:</td><td>1. Pay attention to what you eat and enjoy your food without distractions. This can help you recognize hunger and fullness cues.</td></tr>");
            out.println("<tr><td></td><td>2. Use a food diary or app to monitor what you're eating. This can help identify where you might be consuming excess calories.</td></tr>");
            out.println("<tr><td></td><td>3. Pay attention to portion sizes. Eating smaller portions can help reduce calorie intake.</td></tr>");
            out.println("</table>");
            
            out.println("<button class=\"btn btn-primary\" onclick=\"goBack()\">Go Back</button>");
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

    private String dailyCalorieNeed(double arg0, double arg1, int arg2, java.lang.String arg3) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.fitnessClient.FitnessCalcWS port = service.getFitnessCalcWSPort();
        return port.dailyCalorieNeed(arg0, arg1, arg2, arg3);
    }

}
