package com.google.sps.servlets;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.Value;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import com.google.sps.data.Experience;
import com.google.sps.data.Image;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for listing tasks. */
@WebServlet("/list-experience")
public class ListExperienceServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Experience").build(); // .setOrderBy(OrderBy.desc("id")).build();
    QueryResults<Entity> results = datastore.run(query);

    List<Experience> experiences = new ArrayList<>();
    
    while (results.hasNext()) {
      Entity entity = results.next();
      
      long id = entity.getKey().getId();
      String title = entity.getString("title");
      String company = entity.getString("company");

      ArrayList<String> tasks = new ArrayList<String>();

      List<Value<?>> tasksUncastedList = entity.getList("tasks");
      
      for(int i=0; i<tasksUncastedList.size(); i++) {
          tasks.add(tasksUncastedList.get(i).get().toString());
      }

      
      FullEntity<IncompleteKey> imgObj = entity.getEntity("img");

      Image img = new Image(imgObj.getString("path"), imgObj.getString("alt"));

      Experience exp = new Experience(id, title, company, img, tasks);
      experiences.add(exp);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(experiences));
  }
}

