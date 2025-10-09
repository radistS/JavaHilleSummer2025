package com.sparkjava;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;

import static spark.Spark.*;

public class SparkRestExample {
    public static void main(String[] args) {
        final UserService userService = new UserServiceDbImpl();

        String uploadDir = "upload";
        File uploadFolder = new File(uploadDir);
        uploadFolder.mkdir();  // create the upload directory if it doesn't exist
        staticFiles.externalLocation(uploadDir);


        // config port (default port : 4567)
        port(4567);

        // create new user in system
        //http://localhost:4567/users
        post("/users", (request, response) -> {
            response.type("application/json");

            User user = new Gson().fromJson(request.body(), User.class);

            String uuid = UUID.randomUUID().toString();
            user.setId(uuid);
            userService.addUser(user);
            response.status(201);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, uuid));
        });

        // get users
        //[GET] http://localhost:4567/users
        get("/users", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(userService.getUsers())));
        });


        // get user by id
        get("/users/:id", (request, response) -> {
            response.type("application/json");

            User user = userService.getUser(request.params(":id"));

            if (Objects.isNull(user)){
                response.status(404);
                return  new Gson().toJson(new StandardResponse(StatusResponse.ERROR, "User not found"));
            } else {
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(user)));
            }

        });


        // update user
        put("/users/:id", (request, response) -> {
            response.type("application/json");

            User toEdit = new Gson().fromJson(request.body(), User.class);
            String id = request.params(":id");
            toEdit.setId(id);
            User editedUser = userService.editUser(toEdit);

            if (editedUser != null) {
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedUser)));
            } else {
                response.status( );
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJson("User not found or error in edit")));
            }
        });

//        // update user part
        patch("/users/:id", (request, response) -> {
            response.type("application/json");

            User toEdit = new Gson().fromJson(request.body(), User.class);
            String id = request.params(":id");
            toEdit.setId(id);
            User editedUser = userService.editUser(toEdit);

            if (editedUser != null) {
                return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(editedUser)));
            } else {
                response.status(404);
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, new Gson().toJson("User not found or error in edit")));
            }
        });

//        //delete user
        delete("/users/:id", (request, response) -> {
            response.type("application/json");

            userService.deleteUser(request.params(":id"));
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "user deleted"));
        });
//
//
//        // check user availability
        options("/users/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, (userService.userExist(request.params(":id"))) ? "User exists" : "User does not exists"));
        });
//
//        post("/upload/file", (req, res) -> {
//            // Set multipart config for handling file uploads
//            MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/temp");
//            req.raw().setAttribute("org.eclipse.jetty.multipartConfig", multipartConfigElement);
//
//            try {
//                // Access the file part from the request
//                Part filePart = req.raw().getPart("file");
//
//                if (filePart == null) {
//                    // If file part is null, something went wrong
//                    res.status(400);
//                    return "No file uploaded or 'file' part not found in the request.";
//                }
//
//                // Get the file name and save the file
//                String fileName = filePart.getSubmittedFileName();
//                if (fileName == null || fileName.isEmpty()) {
//                    res.status(400);
//                    return "File name is missing.";
//                }
//
//                System.out.println("File uploaded: " + fileName);
//
//                try (InputStream is = filePart.getInputStream()) {
//                    Files.copy(is, Paths.get(uploadDir + "/" + fileName));
//                }
//
//                res.status(200);
//                return "File uploaded successfully: " + fileName;
//            } catch (ServletException e) {
//                res.status(400);
//                return "Error in the request: " + e.getMessage();
//            } catch (Exception e) {
//                res.status(500);
//                return "Internal server error: " + e.getMessage();
//            } finally {
//                req.raw().removeAttribute("org.eclipse.jetty.multipartConfig");
//            }
//        });

    }

}
