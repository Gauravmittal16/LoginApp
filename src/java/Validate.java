import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;



public class Validate extends HttpServlet
{
    String username;
   int empno;
    public void processRequest(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    { PrintWriter out=res.getWriter();
    try{
    String user=req.getParameter("username");
    int pass=Integer.parseInt(req.getParameter("password"));
  
        Connection con=null;
        Statement st=null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","8755");
        st=con.createStatement();
        String sql="SELECT user,empno FROM employees where password="+pass+"";
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
          username=rs.getString("user");
          empno=rs.getInt("empno");
        }
        
        if(username.equals(user))
        {
           HttpSession session=req.getSession();
           session.setAttribute("username",user);
          session.setAttribute("empno",empno);
           res.sendRedirect("Home");
        }
        else
        {
          res.sendRedirect("Login");  
        }
        rs.close();
        con.close();
        }
        catch(Exception e)
        {
            res.sendRedirect("Login");
        }
    }catch(NumberFormatException exception)
    {       res.sendRedirect("Login");}
        
   out.println("Goodbye!");
     
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