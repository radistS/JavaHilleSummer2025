package com.sparkusers;

import com.google.gson.Gson;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        UserService userService = new UserServiceInMemoryImpl();

        port(4567);

        // Static files (optional css under /public)
        staticFiles.location("/public");

        before((req, res) -> {
            System.out.println(">> " + req.requestMethod() + " " + req.pathInfo());
        });

        ThymeleafTemplateEngine engine = new ThymeleafTemplateEngine();

        // ---------- JSON API ----------
        post("/users", (req, res) -> {
            res.type("application/json");
            User user = new Gson().fromJson(req.body(), User.class);
            user.setId(UUID.randomUUID().toString());
            userService.addUser(user);
            res.status(201);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, user.getId()));
        });

        get("/users", (req, res) -> {
            res.type("application/json");
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS,
                    new Gson().toJsonTree(userService.getUsers())));
        });

        get("/users/:id", (req, res) -> {
            res.type("application/json");
            User user = userService.getUser(req.params(":id"));
            if (user == null) {
                res.status(404);
                return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, "Not found"));
            }
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(user)));
        });

        // ---------- UI ----------
        // List page
        get("/ui/users", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("title", "Users");
            model.put("users", userService.getUsers());
            return engine.render(new ModelAndView(model, "users"));
        });

        // View user
        get("/ui/users/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            User user = userService.getUser(req.params(":id"));
            model.put("user", user);
            model.put("title", user != null ? user.getFirstName() : "Not found");
            return engine.render(new ModelAndView(model, "user"));
        });



        // Handle create
        post("/ui/users", (req, res) -> {
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            String firstName = req.queryParams("firstName");
            String lastName  = req.queryParams("lastName");
            String email     = req.queryParams("email");

            User user = new User()
                    .setId(UUID.randomUUID().toString())
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email);
            userService.addUser(user);
            res.redirect("/ui/users");
            return null;
        });

        // Edit form
        get("/ui/users/:id/edit", (req, res) -> {
            String id = req.params(":id");
            User user = userService.getUser(id);
            Map<String, Object> model = new HashMap<>();
            model.put("title", user == null ? "Not found" : "Edit: " + user.getFirstName());
            model.put("mode", "edit");
            model.put("user", user);
            return engine.render(new ModelAndView(model, "user"));
        });

        // Handle edit
        post("/ui/users/:id/edit", (req, res) -> {
            String id = req.params(":id");
            User existing = userService.getUser(id);
            if (existing != null) {
                existing.setFirstName(req.queryParams("firstName"));
                existing.setLastName(req.queryParams("lastName"));
                existing.setEmail(req.queryParams("email"));
                userService.editUser(existing);
            }
            res.redirect("/ui/users");
            return null;
        });

        // Create form
        get("/ui/new/users", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("title", "Add User");
            model.put("mode", "create");
            model.put("user", new User());
            return engine.render(new ModelAndView(model, "user"));
        });

        // Handle delete
        post("/ui/users/:id/delete", (req, res) -> {
            String id = req.params(":id");
            userService.deleteUser(id);
            res.redirect("/ui/users");
            return null;
        });

        // CSV upload
        post("/ui/users/upload", (req, res) -> {
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            Part filePart = req.raw().getPart("file");
            if (filePart == null || filePart.getSize() == 0) {
                halt(400, "No file uploaded");
            }
            try (InputStream is = filePart.getInputStream()) {
                int imported = importUsersFromCsv(is, userService);
                res.redirect("/ui/users?imported=" + imported);
                return null;
            }
        });
    }

    /** Simple CSV parser: header may include id,firstName,lastName,email (any order). */
    private static int importUsersFromCsv(InputStream in, UserService userService) throws IOException {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String header = br.readLine();
            if (header == null) return 0;
            String[] cols = header.split(",");
            Map<String, Integer> idx = new HashMap<>();
            for (int i = 0; i < cols.length; i++) {
                idx.put(cols[i].trim().toLowerCase(Locale.ROOT), i);
            }
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",", -1);
                String id = getValue(parts, idx.get("id"));
                String firstName = getValue(parts, idx.get("firstname"));
                String lastName = getValue(parts, idx.get("lastname"));
                String email = getValue(parts, idx.get("email"));

                if ((firstName == null || firstName.isEmpty()) &&
                    (lastName == null || lastName.isEmpty()) &&
                    (email == null || email.isEmpty())) continue;

                User u = new User()
                        .setId(id == null || id.isEmpty() ? UUID.randomUUID().toString() : id)
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email);
                userService.addUser(u);
                count++;
            }
        }
        return count;
    }

    private static String getValue(String[] parts, Integer i) {
        if (i == null) return null;
        if (i < 0 || i >= parts.length) return null;
        String v = parts[i];
        return v == null ? null : v.trim();
    }
}
