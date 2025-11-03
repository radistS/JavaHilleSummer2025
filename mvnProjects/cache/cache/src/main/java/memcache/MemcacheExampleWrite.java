package memcache;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

// memcached -d
public class MemcacheExampleWrite {
    public static void main(String[] args) {
        implementXMemCachedClient();
    }

    private static void implementXMemCachedClient() {
        String city1 = "Kiev";
        String city2 = "Odesa";
        try {

            // XMemcached constructor,default weight is 1
            XMemcachedClient xMemCachedclient = new XMemcachedClient("localhost", 11211);

            // Set a value
            xMemCachedclient.set("key1", 10, city1);
            xMemCachedclient.set("key2", 10, city2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish");
    }
}
