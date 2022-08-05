package com.google.sps.servlets;


import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;



import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contactServlet")
public class ContactServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
      String email = request.getParameter("email");
      String message = request.getParameter("message");
      
      System.out.println(email+' '+message);

      Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
      KeyFactory keyFactory = datastore.newKeyFactory().setKind("Comment");
      FullEntity commentEntity = Entity.newBuilder(keyFactory.newKey())
        .set("email", email)
        .set("message", message)
        .set("sentiment", 1)
        .build();
      datastore.put(commentEntity);
      
      response.sendRedirect("https://8081-cs-1078404162001-default.cs-us-central1-pits.cloudshell.dev/");
  }
}
