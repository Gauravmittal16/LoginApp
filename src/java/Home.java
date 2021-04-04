import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.SimpleDateFormat;



public class Home extends HttpServlet
{
    public void processRequest(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {    
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        HttpSession session=request.getSession(false);
        if(session!=null)
        {
            Date d=new Date();
            SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
        String name=session.getAttribute("username").toString();
           PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><title>user Panel</title>"
                + "<style type=text/css>"
                + "table,td{"
                + "border-collapse:collapse;"
                + "width:40%;"
                + "height:70px;"
                + "text-align:center;"
                + "font-size:20px;"
                + "font-family:Lucida Sans Unicode;}"
                + "a{"
                + "text-decoration:none;"
                + "}"
                + "td:hover"
                + "{background-color:orange;"
                + "}"
                + "#high"
                + "{"
                + "height:400px;}"
                + "#log{font-size:20px;"
                + "}"
                + "#log:hover"
                + "{text-decoration:underline;}"
                + ""
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h1>Hello "+name+"</h1>"
                        + "<table align=center>"
                        + "<tr><th>Transactions</th><th>Reports</th></tr>"
                        + "<tr><td><a href=Leaveapp>Leave apply</a></td><td><a href=Leavereport>Leave Report</a></td></tr>"
                        + "<tr><td><a href=requirements>Requirements</a></td><td><a href=requirementreport>Requirement Report</a></td></tr>"
                        + "<tr></tr>"
                        + "<tr></tr>"
                        + "</table>"
                        + "<div id=high></div>"
                        + "<div ><a align='center' id=log href=logout>Log out</a>"
                        + "</div>"
                        + "</body>"
                        + "</html>");
         
        }
        else{
        response.sendRedirect("Login");
        }   
        
        
        
    }
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