package demo;

import jakarta.jws.WebService;

@WebService(
        serviceName = "HelloServiceService",
        portName = "HelloServicePort",
        endpointInterface = "demo.HelloService",
        targetNamespace = "http://demo/")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.printf("Hello, %s!\n", name);
        return "Hello, " + (name == null ? "world" : name) + "!";
    }
}
