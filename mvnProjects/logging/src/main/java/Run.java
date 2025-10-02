import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Run {

    private static final Logger logger = LoggerFactory.getLogger("info-stdout");

    public static void main(String[] args) {
        logger.info("application start ...");
        System.out.println("Hello word ...");
        logger.info("Hello world ... info");
        logger.error("Hello world ... error");
        logger.info("application finish ...");
        logger.info("------------------------------------");

    }
}
