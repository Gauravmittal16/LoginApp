/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Login extends HttpServlet
{

public void processRequest(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException    
{
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    out.println("<html>\n" +
"<head>\n" +
"<style type=\"text/css\">\n" +
"h1{\n" +
"color:black;\n" +
"height:110px;\n" +
"font-size:40px;}\n" +
"body\n" +
"{background-color:dimgrey;\n" +
"}\n" +
".modify{\n" +
"width:350px;\n" +
"height:35px;\n" +
"border-top:none;\n" +
"border-left:none;\n" +
"border-right:none;\n" +
"border-bottom: 1px solid black;}\n" +
"table,td{\n" +
"	height:60px;\n" +
"	width:38%;\n" +
"	font-size:20px;\n" +
"	font-family:comic sans MS;\n" +
"	top:100px;\n" +
"	color:black;\n" +
"	background-color:white;\n" +
"	text-align:center;\n" +
"}\n" +
"table{\n" +
"	border:1px solid white;\n" +
" 	 box-shadow: 0px 12px 12px 10px rgba(0,0,0,0.2);\n" +
"    z-index: 1;\n" +
"}\n" +
"	 th{  font-weight:BOLD;\n" +
"		 text-align:center;\n" +
"		 font-family:Arial Rounded MT;\n" +
"		 font-size:30px;\n" +
"	         color:black;}\n" +
"	 a\n" +
"	 {\n" +
"	 text-decoration:none;\n" +
"	 font-size:16px;\n" +
"	 font-family:calibri;\n" +
"	 color:lightblue;\n" +
"	 \n" +
"	 }\n" +
"	 #sub{width:350px;\n" +
"	 height:40px;\n" +
"	 border:1px solid green;\n" +
"	 color:white;\n" +
"	 font-weight:Bold;}\n" +
"	 #sub:hover\n" +
"	 {\n" +
"	 box-shadow: 0px 5px 8px 8px rgba(0,0,0,0.3);\n" +
"    z-index: 1;\n" +
"}\n" +
"	 \n" +
"	 #decor{\n" +
"	 color:blue;\n" +
"	 text-decoration:none;\n" +
"	 \n" +
"	}\n" +
"	#decor:hover{\n" +
"	text-decoration:underline;\n" +
"	color:green;\n" +
"	}\n" +
"	 #frdecr\n" +
"	 {color:blue;\n" +
"	 text-decoration:none;\n" +
"	 \n" +
"	 }\n" +
"	 #frdecr:hover{\n" +
"	text-decoration:underline;\n" +
"	color:red;\n" +
"	}\n" +
"	</style>\n" +
"	 </head>\n" +
"<body>\n" +
"<h1 align='center'>SBS pvt ltd.</h1>\n" +
"<form action=\"Validate\" method=\"Post\" onsubmit=\"return check(event);\">\n" +
"<table align='center' style=\"top:100px\">\n" +
"<tr><th colspan=\"2\"> My Account </th></tr>\n" +
"<tr><td colspan=\"2\"><input type=\"text\" class=\"modify\" placeholder=\"username\"  name=\"username\"></td></tr>\n" +
"<tr><td colspan=\"2\"><input type=\"password\" class=\"modify\" placeholder=\"password\" name=\"password\"></td></tr>\n" +
"<tr><td colspan=\"2\"><input type=\"submit\"  id=\"sub\" value=\"Log In\" style=\"background-color:4183D7\"/></td></tr>\n" +
"<tr><td > Not yet a member of it<a  id=\"decor\" href=\"#\">Sign up?</a></td><td><a id=\"frdecr\" href=\"#\">Forgot password ?</a></td></tr>\n" +
"</table>\n" +
"</form> \n" +
"<script type=\"text/javascript\">\n" +
"function check(e)\n" +
"{\n" +
"var result=true;\n" +
"var i=document.getElementsByTagName(\"input\");\n" +
"for(x=0;x<i.length;x++)\n" +
"{\n" +
"if(i[x].value.length==0)\n" +
"{alert('Please complete required credentials');\n" +
"result=false;\n" +
"return(result);}\n" +
"}\n" +
"var x=confirm(\"Do you want to continue ?\");\n" +
"if(x==true)\n" +
"{alert(' You have submitted');\n" +
"}\n" +
"else\n" +
"{alert('cancelled');\n" +
"e.preventDefault();\n" +
"}\n" +
"return(result);\n" +
"}\n" +
"</script>\n" +
"</script>\n" +
"</body>\n" +
"</html>\n" +
"          ");
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