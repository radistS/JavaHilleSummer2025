package demo;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(name = "HelloService", targetNamespace = "http://demo/")
public interface HelloService {

    @WebMethod
    String sayHello(String name);
}
