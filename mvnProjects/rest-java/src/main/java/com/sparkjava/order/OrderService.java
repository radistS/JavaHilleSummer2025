package com.sparkjava.order;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import com.google.gson.Gson;
import com.sparkjava.StandardResponse;
import com.sparkjava.StatusResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class OrderService {

    private static List<Order> orderList = new ArrayList<>();

    public static void main(String[] args) {

        //get all orders
        get("/order", (request, response) -> {
            response.type("application/json");
            return new Gson().toJsonTree(orderList);
        });

        // get order by id
        get("/order/:uuid", (request, response) -> {
            response.type("application/json");
            UUID uuid = UUID.fromString(request.params(":uuid"));

            return new Gson().toJsonTree(orderList.stream()
                .filter(o -> o.getUuid().equals(uuid))
                .findFirst().get());
        });

        // create order
        post("/order", (request, response) -> {
            response.type("application/json");

            // receive product from UI
            Product product = new Gson().fromJson(request.body(), Product.class);
            product.setUUID(UUID.randomUUID());

            // we dont have order yet -> we create order and put product inside
            Order order = new Order();
            order.setUuid(UUID.randomUUID());
            order.setCreateAt(new Timestamp(System.currentTimeMillis()));
            order.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            // add product
            order.getProducts().add(product);
            // calculate total cost
            calculateTotalCost(order);

            orderList.add(order);
            return new Gson().toJsonTree(order);
        });

        // create order
        post("/orders", (request, response) -> {
            response.type("application/json");

            // receive product from UI
            Product[] products = new Gson().fromJson(request.body(), Product[].class);

            for (Product product : products) {
                product.setUUID(UUID.randomUUID());
            }

            // we dont have order yet -> we create order and put product inside
            Order order = new Order();
            order.setUuid(UUID.randomUUID());
            order.setCreateAt(new Timestamp(System.currentTimeMillis()));
            order.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            // add product
            order.getProducts().addAll(Arrays.asList(products));
            // calculate total cost
            calculateTotalCost(order);

            orderList.add(order);
            return new Gson().toJsonTree(order);
        });

        // update order
        put("/order/:uuid", (request, response) -> {
            response.type("text");

            UUID uuid = UUID.fromString(request.params(":uuid"));

            try {
                Order order = orderList.stream()
                    .filter(o -> o.getUuid().equals(uuid))
                    .findFirst().orElseThrow(() -> new OrderNotFoundException());
                order.setUpdateAt(new Timestamp(System.currentTimeMillis()));

                Product product = new Gson().fromJson(request.body(), Product.class);
                product.setUUID(UUID.randomUUID());
                order.getProducts().add(product);
                calculateTotalCost(order);

                return new Gson().toJsonTree(order);
            } catch (OrderNotFoundException e){
                response.status(404);
                return  String.format("Can not found order wirh id : %s", uuid);
            }

        });

        delete("/order/:uuidOrder/:uuidProduct", (request, response) -> {
            response.type("application/json");

            UUID uuidOrder = UUID.fromString(request.params(":uuidOrder"));
            UUID uuidProduct = UUID.fromString(request.params(":uuidProduct"));

            Order order = orderList.stream()
                .filter(o -> o.getUuid().equals(uuidOrder))
                .findFirst().orElseThrow(() -> new OrderNotFoundException());

            List<Product> products = order.getProducts();
            Product product = products.stream().filter(o -> o.getUUID().equals(uuidProduct))
                .findFirst().orElseThrow(() -> new ProductNotFoundException());

            products.remove(product);

            return new Gson().toJson(
                new StandardResponse(StatusResponse.DELETED, new Gson().toJsonTree(uuidProduct)));
        });
    }

    private static void calculateTotalCost(Order order) {
        order.setCost(order.getProducts().stream()
            .map(p -> p.getCount() * p.getCost())
            .mapToDouble(p -> p).sum());
    }
}
