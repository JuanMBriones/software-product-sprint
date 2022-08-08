package com.google.sps.data;

import java.util.ArrayList;

public final class Experience {
    private final long id;
    private final String title;
    private final String company;
    private final Image img;
    private final ArrayList<String> tasks;
  
    public Experience(long id, String title, String company, Image img, ArrayList<String> tasks) {
      this.id = id;
      this.title = title;
      this.company = company;
      this.img = img;
      this.tasks = tasks;
    }
  }

