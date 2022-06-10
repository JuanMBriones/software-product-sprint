package com.google.sps.servlets;


import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

@WebServlet("/contactServlet")
public class ContactServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
      String email = request.getParameter("email");
      String message = request.getParameter("message");
      
      System.out.println(email+' '+message);
  }
}
