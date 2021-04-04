import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.sql.*;




public class requirementreport extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         HttpSession session=request.getSession();
         int empno=(int)session.getAttribute("empno");
            
            Connection cn=null;
            Statement st=null;
          try{
          Class.forName("com.mysql.jdbc.Driver");
          cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","8755");
        st=cn.createStatement();
        String sql="SELECT require1,requirq2,require3,date FROM reqirem where empno='"+empno+"'";
        ResultSet rs=st.executeQuery(sql);
         out.println("<html>\n" +
"<head>\n" +
"<title>table </title>\n" +
"<style type=\"text/css\" >\n" +
"table,td,th{\n" +
"width:40%;\n" +
"height:30px;\n" +
"border:border-collapse;\n" +
" text-align:center;\n" +
"}\n" +
"\n" +
"#header{\n" +
"padding:0 100px;\n" +
"width:100%;\n" +
"height:80px;\n" +
"box-sizing:border-box;\n" +
"background: rgba(255,255,255,0.2);\n" +
"box-shadow:0 5px 15px rgba(0,0,0,0.2);\n" +
"\n" +
"}\n" +
"\n" +
"\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"<div id=\"header\">\n" +
"<h1 align='center'>Requirement Report</h1>\n" +
"</div>\n" +
"<div style=\"width:full; height:100px;\">\n" +
"</div>\n" +
"<div class=\"rep\">\n" +
"<table align='center'>\n" +
"<tr><th>Employee No.</th><th>Requirement 1</th><th>Requirement 2</th><th>Requirement 3</th><th>Date</th></tr>\n" );
    while(rs.next())
        {   
            String require1=rs.getString("require1");
            String require2=rs.getString("requirq2");
            String require3=rs.getString("require3");
            Date d=rs.getDate("date");
             SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
           String dt=formatter.format(d);
            out.println("<tr><td>"+empno+"</td><td>"+require1+"</td><td>"+require2+"</td><td>"+require3+"</td><td>"+dt+"</td></tr>\n");
        }         
 
out.println("</table>\n" +
"</div>\n" +
"\n" +
"\n" +
"</body>\n" +
"</html>");
            
 
                     rs.close();
                     cn.close();
 
          
          
          }
             catch(Exception e)
          {
              System.out.println("Error"+e);
          }
 
            
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
