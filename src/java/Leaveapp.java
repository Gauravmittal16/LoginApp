/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.SimpleDateFormat; 
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author user
 */
public class Leaveapp extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           Date d=new Date();
           SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
           String str=formatter.format(d);
           HttpSession session=request.getSession();
           String name=session.getAttribute("username").toString();
           int empno=(int)session.getAttribute("empno");
       out.println("<html>\n" +
"<head><title>leaveapply</title>\n" +
"<style type=\"text/css\">\n" +
"#header\n" +
"{\n" +
"padding:0 100px;\n" +
"width:100%;\n" +
"height:80px;\n" +
"box-sizing:border-box;\n" +
"background: rgba(255,255,255,0.2);\n" +
"box-shadow:0 5px 15px rgba(0,0,0,0.2);\n" +
"\n" +
"}"
               + ""
               + ""
               + "h1{\n" +
"height:40px;\n" +
"}\n" +
"table,td{\n" +
"width:45%;\n" +
"height:70px;\n" +
"font-size:18px;\n" +
"}\n" +
"#sub{width:40%;\n" +
"height:30px;\n" +
"font-weight:Bold;\n" +
"}\n" +
"</style>\n" +
"</head>\n" +
"<body>\n"
+ "<div id=header>" +
"<h1  align='center'>Leave Application</h1>\n</div>" +
"<form action=\"sucess\" method=\"Post\">\n" +
"<table align='center'>\n" +
"<tr><td>Employee No. :<label type=\"label\" name=emno>"+empno+"</label></td><td>Employee Name :<label type=\"label\">"+name+"</label></td></tr>\n" +
"<tr><td>Department   <input type=\"text\" name=\"dept\"/></td><td>Date   :<label type=\"label\" name=dt>"+str+"</label></td></tr></form>\n" +
"<tr><td>Format       <input type=\"text\" name=\"formt\"/></td><td>Dtbase <input type=\"text\" name=\"formt\"/></td></tr></form>\n" +
"<tr><td>Leave case <select><option>EL</option><option>DL</option><option>ML</option></select></td>\n" +
"<td>Purpose <select name=prps><option>Domestic Work</option><option>Urgent Leave</option><option>Money in Ref</option><option>Medical Leave</option></select></td></tr>\n" +
"<tr><td>Sanction Authority<select name=sa><option>HR</option><option>Executive officer</option><option>Senior Manager</option></select></td></tr>\n" +
"<tr><td><input id=\"sub\" type=\"submit\" name=\"submit\"\"</td></tr>\n" +
"</table>\n" +
"</form>\n" +
"</body>\n" +
"</html>");
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

}
