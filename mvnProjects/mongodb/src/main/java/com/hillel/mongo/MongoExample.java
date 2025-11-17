package com.hillel.mongo;

import java.util.ArrayList;

import com.mongodb.client.*;
import java.util.List;
import org.bson.Document;

public class MongoExample {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase database = mongoClient.getDatabase("myTestMongoDb");

            // print existing databases
            mongoClient.listDatabaseNames().forEach(System.out::println);

            boolean collectionExists = mongoClient.getDatabase("myTestMongoDb").listCollectionNames()
                    .into(new ArrayList<>()).contains("user");
            if (!collectionExists) {
                database.createCollection("user");
            }

            System.out.println("---------------");

            // print all collections in customers database
            database.listCollectionNames().forEach(System.out::println);

//          create data
            MongoCollection<Document> collection = database.getCollection("user"); // get collection
            Document document = new Document();
            document.put("name", "Oleksandr Stepurko");
            document.put("company", "Andersen");
            document.put("position", "Java Developer");
            collection.insertOne(document);

            Document document1 = new Document();
            document1.put("name", "Stive Jobs");
            document1.put("position", "CEO");

            Document document2= new Document();
            document2.put("name", "Stive Voznyak");
            document2.put("position", "CTO");
            collection.insertMany(List.of(document1, document2));


            // update data
            Document query = new Document();
            query.put("name", "Oleksandr Stepurko"); // find criteria
            Document newDocument = new Document();
            newDocument.put("company", "EPAM"); // new value
            Document updateObject = new Document();
            updateObject.put("$set", newDocument); // insert
            collection.updateMany(query, updateObject);

//             read data
            Document searchQuery = new Document();
            searchQuery.put("name", "Oleksandr Stepurko");
            FindIterable<Document> cursor = collection.find(searchQuery);
            try (final MongoCursor<Document> cursorIterator = cursor.cursor()) {
                while (cursorIterator.hasNext()) {
                    System.out.println(cursorIterator.next());
                }
            }

//            // delete data
//            Document deleteQuery = new Document();
//            deleteQuery.put("name", "Oleksandr Stepurko");
//            collection.deleteMany(deleteQuery);

            System.out.println("-------------");

            Document searchQuery1 = new Document();
            searchQuery1.put("_id", "691b62cc2a199e21952be8c8");
            cursor = collection.find(searchQuery1);
            try (final MongoCursor<Document> cursorIterator = cursor.cursor()) {
                while (cursorIterator.hasNext()) {
                    System.out.println(cursorIterator.next());
                }
            }
        }

    }
}
