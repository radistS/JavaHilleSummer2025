package demo;

import jakarta.xml.ws.Endpoint;

public class Server {
    public static void main(String[] args) {
        String url = "http://localhost:9999/hello";
        Endpoint.publish(url, new HelloServiceImpl());
        System.out.println("SOAP endpoint published at " + url + "?wsdl");
    }
}
