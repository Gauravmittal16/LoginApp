
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


public class sucess extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();
        String purpose=request.getParameter("prps");
        String sa=request.getParameter("sa");
        HttpSession session=request.getSession();
        int empno=(int)session.getAttribute("empno");
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
      
       Connection cn=null;
        Statement st=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","8755");
             
        String sql="Insert into leaves values('"+empno+"','"+purpose+"','"+sa+"','"+sqlDate+"');";
         PreparedStatement ps=cn.prepareStatement(sql);    
        ps.executeUpdate(sql);
            
        pw.println("<html><head><style>h1{font-family:Lucida Sans Unicode;}</style></head><body ><h1 align='center' >Your Leave has Successfully sanctioned"
                + "</h1></body></html>");
        cn.close();
        
        }
        catch(Exception e)
        {
            System.out.println("Error"+e);
           
        }
        }

   

}
