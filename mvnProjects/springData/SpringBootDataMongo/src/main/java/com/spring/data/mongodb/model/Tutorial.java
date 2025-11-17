package com.spring.data.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "tutorials") //@Entity equivalent for MongoDB
@NoArgsConstructor
@AllArgsConstructor
public class Tutorial {
  @Id
  private String id;

  private String title;
  private String description;
  private boolean published;

  public Tutorial(String title, String description, boolean published) {
    this.title = title;
    this.description = description;
    this.published = published;
  }
}
