package com.sparkjava;

import static spark.Spark.*;

public class HelloWorldService {
    public static void main(String[] args) {
        //http://localhost:4567/hello
        get("/hello", (req, res) ->
            {
                System.out.println("run method : Hello World!");
                return "Hello World!";
            });


        //http://localhost:4567/hello/alex
        get("/hello/:name", (req, res) -> {
            System.out.println("run method: name");
            return "Hello: " + req.params(":name");
        });
    }
}

