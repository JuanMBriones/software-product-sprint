package com.google.sps.data;

public final class Comment {
    private final String email;
    private final String comment;
    private final Float sentiment;
  
    public Comment(String email, String comment, Float sentiment) {
      this.email = email;
      this.comment = comment;
      this.sentiment = sentiment;
    }
}
