package com.hillel.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MongoBsonExample
{
   public static void main(String[] args)
   {
      // Connect to cluster (default is localhost:27017)

      MongoClient mongoClient = MongoClients.create();
      MongoDatabase database = mongoClient.getDatabase("myTestMongoDb");
      MongoCollection<Document> collection = database.getCollection("developers");

      // Insert new document

      Document employee = new Document()
                             .append("first_name", "Joe")
                             .append("last_name", "Smith")
                             .append("title", "Java Developer")
                             .append("years_of_service", 3)
                             .append("skills", Arrays.asList("java", "spring", "mongodb"))
                             .append("manager", new Document()
                                                   .append("first_name", "Sally")
                                                   .append("last_name", "Johanson"));
      collection.insertOne(employee);

      // Find documents

      Document query = new Document("last_name", "Smith");
      List results = new ArrayList<>();
      collection.find(query).into(results);
      System.out.println(results);

      query =
         new Document("$or", Arrays.asList(
            new Document("last_name", "Smith"),
            new Document("first_name", "Joe")));
      results = new ArrayList<>();
      collection.find(query).into(results);
      System.out.println(results);

      // 4.4 Update document

      query = new Document(
         "skills",
         new Document(
            "$elemMatch",
            new Document("$eq", "spring")));
      Document update = new Document(
         "$push",
         new Document("skills", "security"));
      collection.updateMany(query, update);
//
      // 4.5 Delete documents

      query = new Document(
         "years_of_service",
         new Document("$gt", 1));
      collection.deleteMany(query);
   }
}
