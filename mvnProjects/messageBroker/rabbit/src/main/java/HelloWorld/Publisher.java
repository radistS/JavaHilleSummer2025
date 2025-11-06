package HelloWorld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {
    private final static String QUEUE_NAME = "test";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory(); // rabbit connection factory
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String message = "test message";
        for (int i = 0; i < 300; i++) {
            channel.basicPublish("", QUEUE_NAME, null, (message + i).getBytes());
            System.out.println(" [x] Sent '" + message + "' number # " + i);
            Thread.sleep(1000);
        }
        channel.close();
        connection.close();
    }
}
