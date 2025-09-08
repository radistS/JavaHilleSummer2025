package demo;

import jakarta.xml.ws.Service;
import java.net.URL;
import javax.xml.namespace.QName;

public class DynamicClient {
    public static void main(String[] args) throws Exception {
        URL wsdl = new URL("http://localhost:9999/hello?wsdl");
        QName serviceName = new QName("http://demo/", "HelloServiceService");
        QName portName = new QName("http://demo/", "HelloServicePort");

        Service svc = Service.create(wsdl, serviceName);
        HelloService proxy = svc.getPort(portName, HelloService.class);

        System.out.println(proxy.sayHello("Olexandr"));
    }
}
