package memcache;

import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

//memcached -d
public class MemcacheExampleRead {
    public static void main(String[] args) {
        implementXMemCachedClient();
    }

    private static void implementXMemCachedClient() {
        try {
            // XMemcached constructor,default weight is 1
            XMemcachedClient xMemCachedclient = new XMemcachedClient("localhost", 11211);

            log("=====> Key: Key1, Value: " + xMemCachedclient.get("key1"));
            log("=====> Key: key2, Value: " + xMemCachedclient.get("key2", 3000));
            log("=====> Key: Odesa, Value: " + xMemCachedclient.get("Odesa", 3000));
            System.out.println(xMemCachedclient.get(List.of("key1", "key2", "Odesa")));

            Thread.sleep(15000);

            log("=====> Key: key1, Value: " + xMemCachedclient.get("key1"));
            log("=====> Key: key1, Value: " + xMemCachedclient.get("key2", 3000));
            log("=====> Key: Odesa, Value: " + xMemCachedclient.get("Odesa", 3000));
            System.out.println(xMemCachedclient.get(List.of("key1", "key2", "Odesa")));


        } catch (IOException | MemcachedException | TimeoutException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Simple log utility
    private static void log(Object object) {
        System.out.println(object);

    }
}
